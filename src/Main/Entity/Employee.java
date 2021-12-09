package Entity;

import java.io.Serializable;

/**
 * Represents the entire system of Employee(one of the User)
 */
public class Employee extends User implements Serializable{

    int leave_days;

    public Employee(String username, String password, String id, String email, String major){
        super(username, password, id, email, major);
        this.leave_days = 30;
    }

    /**
     * Represents the current Employee by their Username, Salary, Attendance and ID
     * @return a string with the username, salary, attendance and id of current User.
     */
    @Override
    public String toString(){
        return "Employee {Username = " + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", ID = " + getID() + ", Email = " + getEmail() + ", Major = " + getMajor() +"}";
    }
}