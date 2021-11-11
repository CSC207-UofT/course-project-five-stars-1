package Controller;

import Entity.User;
import UseCase.SalaryManagement;
import UseCase.UserManager;

import java.util.Objects;

/**
 * Controls the UserManagement system.
 */
public class UserSystemController {
    private UserManager userManager;
    public UserSystemController(){
        this.userManager = new UserManager();
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
    public boolean login(String username, String password, String id, String email, String major){

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
     * @param id A unique id for each user.
     * @return true if id is valid, else false.
     */
    public boolean verify(String id){
        return userManager.verifyUser(id);
    }
}
