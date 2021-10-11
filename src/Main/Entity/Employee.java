package Entity;

import java.io.Serializable;

public class Employee extends User{

    public Employee(String username, String password, int salary,  boolean Attendance, String ID){
        super(username, password, salary, Attendance, ID);
    }

    @Override
    public String toString(){
        return "Regular User{" + "username=" + username + "}";
    }
}