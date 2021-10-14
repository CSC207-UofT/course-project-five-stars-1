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
    public UserManager(ArrayList<User> userList){
        userlist = userList;
    }

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
     * Getter for the id as a String.
     * @param id A unique String for each User.
     * @param userList A list with Users.
     * @return a string of id if id is the same as the id of User in userlist,
     * else return 'The user id doesn't exist.'
     */
    public String getUserFromId(String id, Iterable<? extends User> userList){
        for (User u : userList){
            if (u.getID().equals(id))
                return id;
        }
        return "The user id doesn't exist.";
    }

    /**
     * Verify the id is valid.
     * @param id A unique String for each User.
     * @return ture if the id is the same as the id of User in userlist,
     * else return false
     */
    public boolean verifyUser(String id){
        for (User u : userlist){
            if (Objects.equals(u.getID(), id))
                return true;
        }
        return false;
    }

    /**
     * Adds an employee with username, password, salary, attendance, and id into userlist.
     * @param username User's username.
     * @param password User's password.
     * @param salary User's salary.
     * @param attendance User's attendance.
     * @param id A unique String for each User.
     */
    public void createEmployee(String username, String password, int salary, boolean attendance, String id){
        User user = new Employee(username, password, salary, attendance, id);
        userlist.add(user);
    }

    /**
     * Adds an employer with username, password, salary, attendance, and id into userlist.
     * @param username User's username.
     * @param password User's password.
     * @param salary User's salary.
     * @param attendance User's attendance.
     * @param id A unique String for each User.
     */
    public void createEmployer(String username, String password, int salary, boolean attendance, String id){
        User user = new Employer(username, password, salary, attendance, id);
        userlist.add(user);
    }

}
