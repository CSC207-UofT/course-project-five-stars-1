package UseCase;

import Entity.*;
import java.util.ArrayList;

public class UserManager {
    public static ArrayList<User> userlist;

    public UserManager(ArrayList<IUser> userList){
        userlist = userList;
    }
    public String getUser(String username){
        for (IUser u : userList){
            if(u.getUsername().equals(username))
                return u.toString();
        }
        return "no such user";
    }
    public boolean verifyUser(String id, String password){
        for (IUser u : userlist){
            if (u.getUsername(). equal(id) && u.getPassword().equals(password))
                return true;
        }
        return false
    }
    public void createRegularUser(String username, String pw){
        IUSer user = new regularUser(username, pw);
        userlist.add(user);
    }
}
