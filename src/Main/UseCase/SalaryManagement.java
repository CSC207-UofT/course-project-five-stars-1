package UseCase;
// import Entity.User;

import java.util.HashMap;

/**
 * Represents the Salary system of Users.
 */
public class SalaryManagement {

    /**
     * Creates a SalaryManagement with an empty Hashmap (A string as its key and an integer as its value)
     */
    private final HashMap<String, Integer> sm;

    /**
     * Define a constructor.
     */
    public SalaryManagement(){
        this.sm = new HashMap<>();
    }

    /**
     * Adds salary info into SalaryManagement with id as key and salary as value.
     * @param id A unique String for each User.
     * @param salary User's salary.
     * @return false if id exists in SalaryManagement,
     * else adds id as key and salary as value into SalaryManagement.
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
     * Getter for SalaryManagement in the form of Hashmap.
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
        int yearlysalary = salary * 12;
        if (yearlysalary <= 45152){
            return yearlysalary * (1 - 0.0505);
        } else if (yearlysalary <= 90287){
            double one = (yearlysalary - 45152) * (1 - 0.0915);
            double two = 45152 * (1 - 0.0505);
            return one + two;
        } else if (yearlysalary <= 150000){
            double one = 45152 * (1 - 0.0505);
            double two = (90287 - 45152) * (1 - 0.0915);
            double three = (yearlysalary - 90287) * (1 - 0.1116);
            return one + two + three;
        } else if (yearlysalary <= 220000){
            double one = 45152 * (1 - 0.0505);
            double two = (90287 - 45152) * (1 - 0.0915);
            double three = (150000 - 90287) * (1 - 0.1116);
            double four = (yearlysalary - 150000) * (1 - 0.1216);
            return one + two + three + four;
        } else {
            double one = 45152 * (1 - 0.0505);
            double two = (90287 - 45152) * (1 - 0.0915);
            double three = (150000 - 90287) * (1 - 0.1116);
            double four = (220000 - 150000) * (1 - 0.1216);
            double five = (yearlysalary - 220000) * (1 - 0.1316);
            return one + two + three + four + five;
        }
    }
}
