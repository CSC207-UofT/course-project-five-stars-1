package Controller;

import UseCase.SalaryManagement;

public class SalarySystemController {
    private SalaryManagement salaryManagement;

    public SalarySystemController(SalaryManagement salaryManagement){this.salaryManagement = salaryManagement;}

    public void showSalary(String id){
        if (salaryManagement.getSm().containsKey(id)){
            System.out.println("This is your salary for this month:");
            System.out.println(salaryManagement.getSalary(id));
        } else {
            System.out.println("Sorry, there does not exist your information");
        }
    }

}
