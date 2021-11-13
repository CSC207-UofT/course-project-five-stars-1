package Controller;

import UseCase.WeeklySchedule;

import java.util.HashMap;

public class ScheduleSystemController {
    private final WeeklySchedule weeklySchedule;


    public ScheduleSystemController(HashMap<String, Integer> schedules){
        this.weeklySchedule = new WeeklySchedule(schedules);
    }

    public WeeklySchedule getWeeklySchedule() {
        return this.weeklySchedule;
    }

    public String addSchedule(String id){
        return this.weeklySchedule.addSchedule(id);
    }

    public int checkSchedule(String id){
        return this.weeklySchedule.getHour(id);
    }

    public String changeSchedule(String id, int changeHour){
        return this.weeklySchedule.changeSchedule(id, changeHour);
    }
}
