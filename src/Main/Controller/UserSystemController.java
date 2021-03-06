package Controller;

import Entity.User;
import UseCase.UserManager;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;


/**
 * Controls the UserManagement system.
 */
public class UserSystemController {

    private final UserManager userManager;

    public UserSystemController(ArrayList<User> userList){
        this.userManager = new UserManager(userList);
    }

    /**
     * If id equals to "0", then creates an employer in userlist.
     * Otherwise, creates an employee in userlist.
     * @param username User's username.
     * @param password User's password.
     * @param id A unique id for each user.
     */
    public void create(String username, String password, String id, String email, String major){
        if (Objects.equals(id, "0")){
            userManager.createEmployer(username, password, id, email, major);
        } else {
            userManager.createEmployee(username, password, id, email, major);
        }
        System.out.println("Successful!!");
    }
    /**
     * Getter userManager
     * @return userManager
     */
    public UserManager getUserManager(){
        return userManager;
    }
    /**
     * Getter username
     * @param id A unique id for each user.
     * @return a string of username if id exists.
     */
    public String getUser(String id){
        return userManager.getUserFromId(id);
    }

    /**
     * Check valid id.
     * @param email A unique email for each User.
     * @param password password for each User.
     * @return true if id is valid, else false.
     */
    public boolean verify(String email, String password){
        return userManager.verifyUser(email, password);
    }

    public boolean isValidEmail(String email) {
        return userManager.isValidEmail(email);
    }

}
