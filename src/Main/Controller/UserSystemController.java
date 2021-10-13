package Controller;

import UseCase.UserManager;

import java.util.Objects;

public class UserSystemController {
    private UserManager userManager;

    public UserSystemController(UserManager userManager){
        this.userManager = userManager;
    }
    public void create(String username, String password, int salary, boolean attendance, String id){
        if (Objects.equals(id, "0")){
            userManager.createEmployer(username, password, salary, attendance, id);
        } else {
            userManager.createEmployee(username, password, salary, attendance, id);
        }
    }

    public boolean verify(String username){
        return userManager.verifyUser(username);
    }
}
