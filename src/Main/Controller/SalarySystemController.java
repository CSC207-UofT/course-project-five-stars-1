package Controller;

import UseCase.SalaryManagement;

import java.util.HashMap;

/**
 * Controls the SalaryManagement system.
 */
public class SalarySystemController {
    private SalaryManagement salaryManagement;

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
    public void showSalary(String id){
        if (salaryManagement.getSm().containsKey(id)){
            System.out.println("This is your salary for this month: " + salaryManagement.getSalary(id));
            System.out.println("This is your salary for this year: " + salaryManagement.computeYearlySalary(id));
            System.out.println("This is your yearly salary after tex: " + salaryManagement.salaryAfterTax(id));
        } else {
            System.out.println("Sorry, there does not exist your information");
        }
    }
    public boolean addSalary(String id, int salary) {
        if (this.salaryManagement.getSm().containsKey(id)) {
            return false;
        } else {
            this.salaryManagement.getSm().put(id, salary);
            return true;
        }
    }

}
