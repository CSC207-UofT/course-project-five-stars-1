package UseCase;
// import Entity.User;

import java.io.IOException;
import java.util.HashMap;
import Gateway.SalaryReadWriter;

/**
 * Represents the Salary system of Users.
 */
public class SalaryManager {

    /**
     * Creates a SalaryManager with an empty Hashmap
     * (A string as its key and an integer as its value)
     */
    private final HashMap<String, Integer> sm;

    SalaryReadWriter readWriter = new SalaryReadWriter();

    /**
     * Define a constructor.
     */
    public SalaryManager(HashMap<String, Integer> salaries){
        this.sm = salaries;

        try {
            readWriter.saveToFile("salaries.ser", salaries);
            System.out.println("Salary list saved!");
        } catch (IOException e) {
            System.out.println("Salary list did not save.");
        }

        try {
            System.out.println(readWriter.readFromFile("salaries.ser"));
            System.out.println("Salary file read successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read.");
        }
    }

    /**
     * Adds salary info into SalaryManager with id as key and salary as value.
     * @param id A unique String for each User.
     * @param salary User's salary.
     * @return false if id exists in SalaryManager,
     *         else adds id as key and salary as value into SalaryManager and return true
     */
    public boolean addSalary(String id, int salary) {
        if (this.sm.containsKey(id)) {
            return false;
        } else {
            this.sm.put(id, salary);
            return true;
        }
    }

    /**
     * Getter for SalaryManager in the form of Hashmap.
     * @return a Hashmap with a string as key and an integer as value.
     */
    public HashMap<String, Integer> getSm (){
        return this.sm;
    }

    /**
     * Getter the salary based on the provided id.
     * @param id A unique String for each User.
     * @return the salary as an integer, corresponding to the provided id.
     */
    public int getSalary(String id){
        return this.sm.get(id);// throw an exception when the id is not in sm.
    }

    /**
     *
     * Computes the yearly salary.
     * @param id User's id.
     * @return an integer.
     */
    public int computeYearlySalary(String id){
        return getSalary(id) * 12;
    }

    /**
     * Computes the yearly salary after tax.
     * @param id User's id.
     * @return a double represented the User's yearly salary after tax.
     */
    public double salaryAfterTax(String id){
        int salary = getSalary(id);
        int yearly_salary = salary * 12;
        if (yearly_salary <= 45152){
            return yearly_salary * (1 - 0.0505);
        } else if (yearly_salary <= 90287){
            double one = (yearly_salary - 45152) * (1 - 0.0915);
            double two = 45152 * (1 - 0.0505);
            return one + two;
        } else if (yearly_salary <= 150000){
            double one = 45152 * (1 - 0.0505);
            double two = (90287 - 45152) * (1 - 0.0915);
            double three = (yearly_salary - 90287) * (1 - 0.1116);
            return one + two + three;
        } else if (yearly_salary <= 220000){
            double one = 45152 * (1 - 0.0505);
            double two = (90287 - 45152) * (1 - 0.0915);
            double three = (150000 - 90287) * (1 - 0.1116);
            double four = (yearly_salary - 150000) * (1 - 0.1216);
            return one + two + three + four;
        } else {
            double one = 45152 * (1 - 0.0505);
            double two = (90287 - 45152) * (1 - 0.0915);
            double three = (150000 - 90287) * (1 - 0.1116);
            double four = (220000 - 150000) * (1 - 0.1216);
            double five = (yearly_salary - 220000) * (1 - 0.1316);
            return one + two + three + four + five;
        }
    }
}
