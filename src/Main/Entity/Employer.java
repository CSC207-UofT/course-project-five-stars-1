package Entity;

/**
 * Represents the entire system of Employer(one of the User)
 */
public class Employer extends User{
    public Employer(String username, String password, int salary,  boolean attendance, String id, String email, String major){
        super(username, password, salary, attendance, id, email, major);
    }

    /**
     * Represents the current Employer by their Username, Salary, Attendance and ID
     * @return a string with the username, salary, attendance and id of current User.
     */
    @Override
    public String toString(){
        return "Employer {Username = " + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", ID = " + getID() + ", Email = " + getEmail() + ", Major = " + getMajor() +  "}";
    }
}