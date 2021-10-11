package UseCase;
import Entity.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    public static ArrayList<User> userlist;

    public UserManager(ArrayList<User> userList){
        userlist = userList;
    }
    public String getUser(String id, Iterable<? extends User> userList){
        for (User u : userList){
            if(u.getUsername().equals(id))
                return u.toString();
        }
        return "The user doesn't exist.";
    }
    public boolean verifyUser(String id){
        for (User u : userlist){
            if (Objects.equals(u.getID(), id))
                return true;
        }
        return false;
    }
    public void createEmployee(String username, String password, int salary, boolean attendance, String id){
        User user = new Employee(username, password, salary, attendance, id);
        userlist.add(user);
    }
    public void createEmployer(String username, String password, int salary, boolean attendance, String id){
        User user = new Employer(username, password, salary, attendance, id);
        userlist.add(user);
    }


}
