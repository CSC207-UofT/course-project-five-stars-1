package Entity;

public abstract class User{

    private String username;
    private String password;
    private int salary;
    private boolean attendance;
    private String id;


    public User(String username, String password, int salary, boolean attendance, String id){
        this.username = username;
        this.password = password;
        this.attendance = attendance;
        this.salary = salary;
        this.id = id;
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

    @Override
    public String toString(){
        return "Regular User{" + "username=" + username + "}";
    }

}