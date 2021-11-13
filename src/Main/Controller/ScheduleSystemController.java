package Controller;

import UseCase.WeeklySchedule;

public class ScheduleSystemController {
    private WeeklySchedule weeklySchedule;

    public ScheduleSystemController(){this.weeklySchedule = new WeeklySchedule();}

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
