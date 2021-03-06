package Controller;

import UseCase.SalaryManager;

// import java.util.HashMap;
import java.util.HashMap;
import java.util.Objects;

/**
 * Controls the SalaryManagement system.
 */
public class SalarySystemController {
    private final SalaryManager salaryManagement;

    public SalarySystemController(HashMap<String, Integer> salaries){
        this.salaryManagement = new SalaryManager(salaries);
    }

    /**
     * Getter SalaryManagement
     * @return salaryManagement.
     */

    public SalaryManager getSalaryManagement(){
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
    /**
     * Print out the salary based on the provided id.
     * Otherwise, print "Sorry, there does not exist your information"
     * @param id1 A unique String for each User.
     * @param id2 A unique String for each User.
     * @param salary A unique int to represent salary.
     */
    public String addSalary(String id1, String id2, int salary) {
        if (Objects.equals(id1, "0")){
            this.salaryManagement.getSm().put(id2, salary);
            return "Added salary of employee(id: " + id2 + ") successfully";
        }else{
            return "You don't have the authority to add salary.";
        }
    }

}
