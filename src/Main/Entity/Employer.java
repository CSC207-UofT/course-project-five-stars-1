package Entity;

public class Employer extends User{
    String privilige;

    public Employer(String username, String password, int salary,  boolean Attendance, String ID){
        super(username, password, salary, Attendance, ID );
    }

    @Override
    public String toString(){
        return "Regular User{" + "username=" + username + "}";
    }
}