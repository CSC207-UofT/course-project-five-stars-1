package UseCase;

import Entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Represents the system of Users
 */
public class UserManager {
    /**
     * Creates a UserManager with an empty list of Users
     */
    public static ArrayList<User> userlist;
<<<<<<< HEAD
    public UserManager(){userlist = new ArrayList<User>();
=======
    public UserManager(){
        userlist = new ArrayList<>();
>>>>>>> origin/main
    }

    /**
     * Getter for SalaryManagement in the form of Hashmap.
     * @return a Hashmap with a string as key and an integer as value.
     */
    public ArrayList<User> getUm (){
        return userlist;
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
