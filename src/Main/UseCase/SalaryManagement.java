package UseCase;
import Entity.User;

import java.util.HashMap;
public class SalaryManagement {
    private HashMap<String, Integer> sm;

    public SalaryManagement(){
        this.sm = new HashMap<String, Integer>();
    }

    public boolean pullSalary(String id, int salary) {
        if (this.sm.containsKey(id)) {
            return false;
        } else {
            this.sm.put(id, salary);
            return true;
        }
    }

    public HashMap<String, Integer> getSm (){
        return this.sm;
    }

    public int getSalary(String id){
        return this.sm.get(id);// throw an exception when the id is not in sm.
    }
    public int computeYearlySalary(int salary){
        return salary * 12;
    }

}
