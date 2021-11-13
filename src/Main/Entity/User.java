package Entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a User in the system.
 */
public abstract class User{

    private String username;
    private String password;
    private int salary = 0;
    private boolean attendance = false;
    private String id;
    private final String email;
    private final String major;

    /**
     * Creates a new user with username, password, id, email, and major
     *
     * @param username user's username.
     * @param password user's password.
     * @param id user's id.
     * @param email user's email.
     * @param major user's major.
     */
    public User(String username, String password, String id, String email, String major){
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.major = major;
    }

    /**
     * Getter for the username as a string
     * @return username as a String
     */
    public String getUsername(){
        return username;
    }

    /**
     * Set Username
     * @param username user's username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Getter for the password as a string
     * @return password as a String
     */
    public String getPassword(){
        return password;
    }

    /**
     * Set the password.
     * @param password User's password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Getter for salary as an int
     * @return salary as an int
     */
    public int getSalary(){
         return this.salary;
    }

    /**
     * Set the salary
     * @param salary User's salary
     */
    public void setSalary(int salary){
        this.salary = salary;
    }

    /**
     * Getter for attendance as a boolean
     * @return attendance as a boolean
     */
    public boolean getAttendance(){
        return this.attendance;
    }

    /**
     * Set the attendance
     * @param attendance User's attendance
     */
    public void setAttendance(boolean attendance){
        this.attendance = attendance;
    }

    /**
     * Getter for ID as a string
     * @return ID as a String
     */
    public String getID(){
        return this.id;
    }

    /**
     * Set the ID
     * @param id User's ID
     */
    public void setID(String id){
        this.id = id;
    }

    /**
     * Getter for email as a string
     * @return Email as a String
     */
    public String getEmail() {return email;}

    /**
     * Verify the email
     */
    public static final Pattern VALID_EMAIL_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Verify the email is valid or not
     * @param email user's email
     * @return ture if email is valid, return false otherwise.
     */
    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email);
        return matcher.find();
    }

    /**
     * Getter for major as a string
     * @return major as a String
     */

    public String getMajor() {return major;}

    /**
     * Represents the current User by its username.
     * @return a string with the username.
     */
    @Override
    public String toString(){
        return "User{" + "username=" + username + "}";
    }

}