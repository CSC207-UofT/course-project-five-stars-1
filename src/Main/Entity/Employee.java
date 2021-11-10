package Entity;

/**
 * Represents the entire system of Employee(one of the User)
 */
public class Employee extends User{

    public Employee(String username, String password, int salary,  boolean attendance, String id, String email){
        super(username, password, salary, attendance, id, email);
    }

    /**
     * Represents the current Employee by their Username, Salary, Attendance and ID
     * @return a string with the username, salary, attendance and id of current User.
     */
    @Override
    public String toString(){
        return "Employee {Username = " + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", ID = " + getID() + ", Email = " + getEmail() + "}";
    }
}