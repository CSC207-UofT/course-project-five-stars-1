package Entity;


public class Employee extends User{

    public Employee(String username, String password, int salary,  boolean attendance, String ID){
        super(username, password, salary, attendance, ID);
    }

    @Override
    public String toString(){
        return "Employee {" + "username=" + username + ", salary = " + salary + ", Attendance = " + attendance +
                ", ID = " + ID + "}";
    }
}