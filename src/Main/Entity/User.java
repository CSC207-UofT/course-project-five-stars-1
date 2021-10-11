package Entity;

public abstract class User{

    public String username;
    public String password;
    public int salary;
    public boolean Attendance;
    public String ID;


    public User(String username, String password, int salary, boolean Attendance, String ID){
        this.username = username;
        this.password = password;
        this.Attendance = Attendance;
        this.salary = salary;
        this.ID = ID;
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
        return this.Attendance;
    }
    public void setAttendance(boolean Attendance){
        this.Attendance = Attendance;
    }
    public String getID(){
        return this.ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }



    @Override
    public String toString(){
        return "Rugular User{" + "username=" + username + "}";
    }

}