package UseCase;

import Entity.*;
import Gateway.UserReadWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents the system of Users
 */
public class UserManager {
    /**
     * Creates a UserManager with an empty list of Users
     */
    public static ArrayList<User> userlist;

    UserReadWriter readWriter = new UserReadWriter();

    public UserManager(ArrayList<User> userList){
        userlist = userList;

        try {
            readWriter.saveToFile("users.ser", userList);
            System.out.println("User list saved!");
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }

        try {
            System.out.println(readWriter.readFromFile("users.ser"));
            System.out.println("User file read successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read.");
        }
    }

    /**
     * Getter for userlist
     * @return userlist
     */
    public ArrayList<User> getUm() {return userlist;}

    /**
     * Getter for the username as a String
     * @param username User's username.
     * @param userList A list with Users.
     * @return a string of username if the username is the same as the username of User in userlist,
     * else return 'The user doesn't exist.'
     */
    public String getUser(String username, Iterable<? extends User> userList){
        for (User u : userList){
            if (u.getUsername().equals(username))
                return u.toString();
        }
        return "The user doesn't exist.";
    }

    /**
     * Getter for the username from id as a String.
     * @param id A unique String for each User.
     * @return a string of username if id is the same as the id of User in userlist,
     * else return 'The user id doesn't exist.'
     */
    public String getUserFromId(String id){
        for (User u : userlist){
            if (u.getID().equals(id))
                return u.toString();
        }
        return "The user id doesn't exist.";
    }

    /**
     * Verify the id is valid.
     * @param email A unique email for each User.
     * @param password password for each User.
     * @return ture if the id is the same as the id of User in userlist,
     * else return false
     */
    public boolean verifyUser(String email, String password){
        for (User u : userlist){
            if (Objects.equals(u.getEmail(), email) & Objects.equals(u.getPassword(), password))
                return true;
        }
        return false;
    }

    /**
     * Adds an employee with username, password, salary, attendance, and id into userlist.
     * @param username User's username.
     * @param password User's password.
     * @param id A unique String for each User.
     */
    public void createEmployee(String username, String password, String id, String email, String major){
        UserFactory factory = new UserFactory();
        User user = factory.getUser("Employee", username, password, id, email, major);
        createEmployeeEmployer(user);
    }

    /**
     * Adds an employer with username, password, salary, attendance, and id into userlist.
     * @param username User's username.
     * @param password User's password.
     * @param id A unique String for each User.
     */
    public void createEmployer(String username, String password, String id, String email, String major){
        UserFactory factory = new UserFactory();
        User user = factory.getUser("Employer", username, password, id, email, major);
        createEmployeeEmployer(user);
    }

    /**
     * Adds user into userlist.
     * @param user user
     */
    private void createEmployeeEmployer(User user) {
        userlist.add(user);
        try {
            readWriter.saveToFile("users.ser", userlist);
            System.out.println("User list saved!");
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }

        try {
            System.out.println(readWriter.readFromFile("users.ser"));
            System.out.println("User file read successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read.");
        }
    }

    /**
     * Fire a User from system
     * @param id user's ID
     * @return false if ID does not match, else return true
     */
    public boolean fire(String id){
        for (User user : userlist){
            if (Objects.equals(user.getID(), id)){
                userlist.remove(user);
                System.out.println("Successful! This employee has been removed");
                return true;
            }
        }
        System.out.println("We did not find the employee");
        return false;
    }
    public static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Verify the email is valid or not
     * @param email user's email
     * @return ture if email is valid, return false otherwise.
     */
    public boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        return matcher.find();
    }


}
