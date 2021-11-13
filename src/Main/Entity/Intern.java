package Entity;

public class Intern extends User{
    private boolean acceptable;

    public Intern(String username, String password, String id, String email, String major){
        super(username, password, id, email, major);
        this.acceptable = false;
    }
    public boolean isAcceptable(){return this.acceptable;}

    public void setAcceptable(boolean acceptable) {
        this.acceptable = acceptable;
    }

    /**
     * Represents the current Intern by their Username, Salary, Attendance and ID
     * @return a string with the username, salary, attendance and id of current User.
     */
    @Override
    public String toString(){
        return "Intern {Username = " + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", Acceptable = " + isAcceptable() + ", ID = " + getID() + ", Email = " + getEmail() + "}";
    }
}
