package UseCase;

import java.util.HashMap;

public class Schedule {
    private HashMap<String, Integer> scm;
    public Schedule(){
        this.scm = new HashMap<String, Integer>();
    }
    public boolean addSchedule(String id, int hour) {
        if (this.scm.containsKey(id)) {
            return false;
        } else {
            this.scm.put(id, hour);
            return true;
        }
    }
    public HashMap<String, Integer> getSm (){

        return this.scm;
    }
    public int getHour(String id){
        return this.scm.get(id);
    }
    public int computeWeeklyHour(int hour, int changeHour){
        return hour * 5 + changeHour;
    }
    public boolean AddChangeSchdule(int changeHour, String id){
        if (this.scm.containsKey(id)) {
            return false;
        } else {
            this.scm.put(id,changeHour);
            return true;
        }
    }
    public int getChangeHour(String id){
        return this.scm.get(id);
    }
}
