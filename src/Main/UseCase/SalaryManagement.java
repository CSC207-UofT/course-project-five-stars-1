package UseCase;
import Entity.User;

import java.util.HashMap;
public class SalaryManagement {
    public HashMap<String, Integer> sm = new HashMap<String, Integer>();

    public SalaryManagement(HashMap<String, Integer> sm){
        this.sm = sm;}
    public boolean pullSalary(String id, int salary) {
        if (this.sm.containsKey(id)) {
            return false;
        } else {
            this.sm.put(id, salary);
            return true;
        }
    }

    public int getSalary(String id){
        return this.sm.get(id);// throw an exception when the id is not in sm.
    }
    public int computeYearlySalary(int salary){
        return salary * 12;
    }

}
