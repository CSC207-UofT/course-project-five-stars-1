package Entity;

import java.io.Serializable;

/**
 * Represents an intern in the system
 */
public class Intern extends User implements Serializable {

    private boolean acceptable;
    int leave_days;

    public Intern(String username, String password, String id, String email, String major){
        super(username, password, id, email, major);
        this.acceptable = false;
        this.leave_days = 30;
    }

    /**
     * Getter for acceptable state as a boolean
     * @return acceptable state as a boolean
     */
    public boolean isAcceptable(){return this.acceptable;}

    /**
     * Set the acceptable state
     * @param acceptable User's acceptable state, only for intern.
     */
    public void setAcceptable(boolean acceptable) {
        this.acceptable = acceptable;
    }

    /**
     * Represents the current Intern by their Username, Salary, Attendance, Acceptable states and ID
     * @return a String with the username, salary, attendance, acceptable states and id of current User.
     */
    @Override
    public String toString(){
        return "Intern {Username = " + getUsername() + ", Salary = " + getSalary() + ", Attendance = "
                + getAttendance() + ", Acceptable = " + isAcceptable() + ", ID = " + getID() + ", Email = " + getEmail() + "}";
    }
}
