package Controller;

import UseCase.UserManager;

public class UserSystemController {
    private UserManager um;

    public UserSystemController(UserManager um){
        this.um = um;
    }
    public void create(String username, String password){
        um.createRegularUser(username, password);
    }

    public boolean verify(String username){
        return um.verifyUser(username);
    }
}
