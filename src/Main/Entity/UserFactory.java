package Entity;
import Entity.User;
import Entity.Intern;
import Entity.Employer;
import Entity.Employee;

public class UserFactory {
    public static User getUser(String type,String username, String password, String id, String email, String major){
        if("Employee".equalsIgnoreCase(type)){
            return new Employee(username, password, id, email, major);
        }else if("Employer".equalsIgnoreCase(type)){
            return new Employer(username, password, id, email, major);
        }else if (("Intern".equalsIgnoreCase(type))){
            return new Intern(username, password, id, email, major);
        }else{
            return null;
        }
    }
}
