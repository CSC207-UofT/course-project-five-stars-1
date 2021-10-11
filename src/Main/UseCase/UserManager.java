package UseCase;

import Entity.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    public static ArrayList<User> userlist;

    public UserManager(ArrayList<User> userList){
        userlist = userList;
    }
    public String getUser(String username, Iterable<? extends User> userList){
        for (User u : userList){
            if(u.getUsername().equals(username))
                return u.toString();
        }
        return "The user doesn't exist.";
    }
    public boolean verifyUser(String id, String password){
        for (User u : userlist){
            if (Objects.equals(u.getUsername(), id) && Objects.equals(u.getPassword(id), password))
                return true;
        }
        return false;
    }
    public void createEmployee(String username, String password, int salary, boolean attendance, String id){
        User user = new Employee(username, password, salary, attendance, id);
        userlist.add(user);
    }
}
