package UseCase;

import java.util.HashMap;
import java.util.Objects;

public class WeeklySchedule {
    private HashMap<String, Integer> scm;
    public WeeklySchedule(){
        this.scm = new HashMap<String, Integer>();
    }
    public boolean addSchedule(String id) {
        if (this.scm.containsKey(id)) {
            return false;
        } else {
            this.scm.put(id, 40);
            return true;
        }
    }
    public HashMap<String, Integer> getSm (){
        return this.scm;
    }
    public int getHour(String id){
        return this.scm.get(id);
    }

    public boolean changeSchdule(String id, int changeHour, boolean add){
        if (this.scm.containsKey(id)){
            if (add){
                int hour = this.getHour(id);
                this.scm.replace(id, hour + changeHour);
                return true;
            } else {
                int hour = this.getHour(id);
                this.scm.replace(id, hour - changeHour);
                return true;
            }
        } else {
            return false;
        }
    }

}
