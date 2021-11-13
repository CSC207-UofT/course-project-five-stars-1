package Controller;

import UseCase.SalaryManagement;

// import java.util.HashMap;
import java.util.Objects;

/**
 * Controls the SalaryManagement system.
 */
public class SalarySystemController {
    private final SalaryManagement salaryManagement;

    public SalarySystemController(){
        this.salaryManagement = new SalaryManagement();
    }

    /**
     * Getter SalaryManagement
     * @return salaryManagement.
     */

    public SalaryManagement getSalaryManagement(){
        return salaryManagement;
    }


    /**
     * Print out the salary based on the provided id.
     * Otherwise, print "Sorry, there does not exist your information"
     * @param id A unique String for each User.
     */
    public String showSalary(String id){
        if (salaryManagement.getSm().containsKey(id)){
            return "This is your salary for this month: " + salaryManagement.getSalary(id) + ". " +
                    "This is your salary for this year: " + salaryManagement.computeYearlySalary(id) + ". " +
                    "This is your yearly salary after tax: " + salaryManagement.salaryAfterTax(id) + ".";
        } else {
            return "Sorry, there does not exist your information";
        }
    }
    public String addSalary(String id1, String id2, int salary) {
        if (this.salaryManagement.getSm().containsKey(id2)) {
            return "There is no user match";
        } else {
            if (Objects.equals(id1, "0")){
                this.salaryManagement.getSm().put(id2, salary);
                return " Employer has added your salary";
            }else{
                return "You don't have the authority to add salary.";
            }
        }
    }

}
