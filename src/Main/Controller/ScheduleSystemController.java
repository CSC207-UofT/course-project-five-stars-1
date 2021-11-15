package Controller;

import UseCase.WeeklySchedule;

import java.util.HashMap;

public class ScheduleSystemController {
    private final WeeklySchedule weeklySchedule;
    /**
     * Getter weeklySchedule
     * create new weeklySchedule.
     */
    public ScheduleSystemController(HashMap<String, Integer> schedules){
        this.weeklySchedule = new WeeklySchedule(schedules);
    }
    /**
     * Getter weeklySchedule
     * @return weeklySchedule.
     */
    public WeeklySchedule getWeeklySchedule() {
        return this.weeklySchedule;
    }
    /**
     * Getter weeklySchedule
     * @return weeklySchedule.addSchedule.
     */
    public String addSchedule(String id){
        return this.weeklySchedule.addSchedule(id);
    }
    /**
     * Getter weeklySchedule
     * @return weeklySchedule.getHour.
     */
    public int checkSchedule(String id){
        return this.weeklySchedule.getHour(id);
    }
    /**
     * Getter weeklySchedule
     * @return weeklySchedule.changeSchedule.
     */
    public String changeSchedule(String id, int changeHour){
        return this.weeklySchedule.changeSchedule(id, changeHour);
    }
}
