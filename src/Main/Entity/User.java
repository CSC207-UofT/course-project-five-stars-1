package Entity;

/**
 * Represents the entire system of a User in the system.
 */
public abstract class User{

    /**
     * Creating the variables responsible for storing User detailed information
     */
    private String username;
    private String password;
    private int salary;
    private boolean attendance;
    private String id;

    /**
     * Constructs instances of User based on Strings of information
     */
    public User(String username, String password, int salary, boolean attendance, String id){
        this.username = username;
        this.password = password;
        this.attendance = attendance;
        this.salary = salary;
        this.id = id;
    }

    /**
     * Get the username of one specific User
     */
    public String getUsername(){
        return username;
    }

    /**
     * Adds the username to one specific User
     * @param  userid String to add to this Student's list
     */
    public void setUsername(String userid){
        this.username = userid;
    }

    /**
     * Get the password of one specific User
     */
    public String getPassword(String password){
        return password;
    }

    /**
     * Adds the password to one specific User
     * @param password String to add to this Student's list
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Get the salary of one specific User
     */
    public int getSalary(){
         return this.salary;
    }

    /**
     * Adds the salary to one specific User
     * @param salary int to add to this Student's list
     */
    public void setSalary(int salary){
        this.salary = salary;
    }

    /**
     * Get the attendance of one specific User
     */
    public boolean getAttendance(){
        return this.attendance;
    }

    /**
     * Adds the salary to one specific User
     * @param attendance boolean to add to this Student's list
     */
    public void setAttendance(boolean attendance){
        this.attendance = attendance;
    }

    /**
     * Get the id of one specific User
     */
    public String getID(){
        return this.id;
    }

    /**
     * Adds the salary to one specific User
     * @param id String to add to this Student's list
     */
    public void setID(String id){
        this.id = id;
    }


    /**
     * Represents the current User by their username
     * @return the username of current User
     */
    @Override
    public String toString(){
        return "Regular User{" + "username=" + username + "}";
    }

}