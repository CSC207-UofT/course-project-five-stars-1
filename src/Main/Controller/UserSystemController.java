package Controller;

import Entity.User;
import UseCase.UserManager;

import java.util.Objects;

public class UserSystemController {
    private UserManager userManager;

    public UserSystemController(){
        this.userManager = new UserManager();
    }
    public void create(String username, String password, int salary, boolean attendance, String id){
        if (Objects.equals(id, "0")){
            userManager.createEmployer(username, password, salary, attendance, id);
            System.out.println("Successful!!");
        } else {
            userManager.createEmployee(username, password, salary, attendance, id);
            System.out.println("Successful!!");
        }
    }

    public String getUser(String id){
        return userManager.getUserFromId(id);
    }

    public boolean verify(String id){
        return userManager.verifyUser(id);
    }
}
