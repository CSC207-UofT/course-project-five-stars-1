package Entity;


public class Employee extends User{

    public Employee(String username, String password, int salary,  boolean attendance, String id){
        super(username, password, salary, attendance, id);
    }

    @Override
    public String toString(){
        return "Employee {" + "Username=" + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", ID = " + getID() + "}";
    }
}