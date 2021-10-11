package Entity;

public class Employer extends User{

    public Employer(String username, String password, int salary,  boolean attendance, String id){
        super(username, password, salary, attendance, id );
    }

    @Override
    public String toString(){
        return "Employer {" + "Username=" + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", ID = " + getID() + "}";
    }
}