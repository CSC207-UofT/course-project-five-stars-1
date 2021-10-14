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
     * Print out the salary based on the provided id.
     * Otherwise, print "Sorry, there does not exist your information"
     * @param id A unique String for each User.
     */
    public void showSalary(String id){
        if (salaryManagement.getSm().containsKey(id)){
            System.out.println("This is your salary for this month:");
            System.out.println(salaryManagement.getSalary(id));
        } else {
            System.out.println("Sorry, there does not exist your information");
        }
    }

}
