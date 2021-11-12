package Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User{

    private String username;
    private String password;
    private int salary = 0;
    private boolean attendance = false;
    private String id;
    private final String email;
    private final String major;


    public User(String username, String password, String id, String email, String major){
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.major = major;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String userid){
        this.username = userid;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getSalary(){
         return this.salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public boolean getAttendance(){
        return this.attendance;
    }
    public void setAttendance(boolean attendance){
        this.attendance = attendance;
    }
    public String getID(){
        return this.id;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getEmail() {return email;}

    public static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        return matcher.find();
    }

    public String getMajor() {return major;}

    @Override
    public String toString(){
        return "Regular User{" + "username=" + username + "}";
    }

}