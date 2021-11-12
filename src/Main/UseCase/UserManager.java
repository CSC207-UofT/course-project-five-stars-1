package UseCase;

import Entity.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents the system of Users
 */
public class UserManager {
    /**
     * Creates a UserManager with an empty list of Users
     */
    public static ArrayList<User> userlist;
    public UserManager(){
        userlist = new ArrayList<User>();
    }
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
        User user = new Employee(username, password, id, email, major);
        userlist.add(user);
    }

    /**
     * Adds an employer with username, password, salary, attendance, and id into userlist.
     * @param username User's username.
     * @param password User's password.
     * @param id A unique String for each User.
     */
    public void createEmployer(String username, String password, String id, String email, String major){
        User user = new Employer(username, password, id, email, major);
        userlist.add(user);
    }

    /**
     * Remove an employee from our userSystem.
     * @param id employee's id.
     *
     */
    public void fire(String id){
        for (User user : userlist){
            if (Objects.equals(user.getID(), id)){
                userlist.remove(user);
                System.out.println("Successful! This employee has been removed");
                break;
            }
        }
        System.out.println("We did not find the employee");
    }
}
