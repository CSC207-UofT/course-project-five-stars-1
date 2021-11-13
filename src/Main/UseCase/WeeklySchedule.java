package UseCase;

import java.util.HashMap;
import java.util.Objects;

public class WeeklySchedule {
    private HashMap<String, Integer> scm;
    public WeeklySchedule(){
        this.scm = new HashMap<String, Integer>();
    }
    public String addSchedule(String id) {
        if (this.scm.containsKey(id)) {
            return "Cannot add your schedule since there is no id";
        } else {
            this.scm.put(id, 40);
            return "Add your schedule successfully";
        }
    }
    public HashMap<String, Integer> getSm (){
        return this.scm;
    }
    public int getHour(String id){
        return this.scm.get(id);
    }

    public String changeSchedule(String id, int changeHour){
        if (this.scm.containsKey(id)){
            int hour = this.getHour(id);
            this.scm.replace(id, hour + changeHour);
            return "Update your schedule successfully";
        } else {
            return "Failed to update your schedule ";
        }
    }

}
