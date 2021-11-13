package Controller;

import Entity.User;
import Gateway.UserReadWriter;
import UseCase.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Controls the UserManagement system.
 */
public class UserSystemController {
    UserReadWriter readWriter = new UserReadWriter();
    private final UserManager userManager;

    public UserSystemController(ArrayList<User> userList){
        this.userManager = new UserManager(userList);
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

    public void fire(String id){
        this.userManager.fire(id);
    }

}
