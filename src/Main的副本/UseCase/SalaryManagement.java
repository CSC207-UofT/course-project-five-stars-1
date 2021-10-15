package UseCase;
import Entity.User;

import java.util.HashMap;

/**
 * Represents the Salary system of Users.
 */
public class SalaryManagement {

    /**
     * Creates a SalaryManagement with an empty Hashmap (A string as its key and an integer as its value)
     */
    private HashMap<String, Integer> sm;

    /**
     * Define a constructor.
     */
    public SalaryManagement(){
        this.sm = new HashMap<String, Integer>();
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
     * @param salary User's salary.
     * @return an integer.
     */
    public int computeYearlySalary(int salary){
        return salary * 12;
    }

}
