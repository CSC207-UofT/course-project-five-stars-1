package Entity;

public abstract class User{

    public String username;
    public String password;
    public int salary;
    public boolean attendance;
    public String id;


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

    public String getPassword(String password){
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