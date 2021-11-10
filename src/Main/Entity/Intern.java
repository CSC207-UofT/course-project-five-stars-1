package Entity;

public class Intern extends User{
    public Intern(String username, String password, int salary,  boolean attendance, String id, String email){
        super(username, password, salary, attendance, id, email);
    }

    /**
     * Represents the current Intern by their Username, Salary, Attendance and ID
     * @return a string with the username, salary, attendance and id of current User.
     */
    @Override
    public String toString(){
        return "Intern {Username = " + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", ID = " + getID() + ", Email = " + getEmail() + "}";
    }
}
