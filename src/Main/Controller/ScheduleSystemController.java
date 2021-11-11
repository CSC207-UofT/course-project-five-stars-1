package Controller;

import UseCase.WeeklySchedule;

public class ScheduleSystemController {
    private WeeklySchedule weeklySchedule;

    public ScheduleSystemController(){this.weeklySchedule = new WeeklySchedule();}

    public WeeklySchedule getWeeklySchedule() {
        return this.weeklySchedule;
    }

    public boolean addSchedule(String id){
        return this.weeklySchedule.addSchedule(id);
    }

    public int checkSchedule(String id){
        return this.weeklySchedule.getHour(id);
    }

    public boolean changeSchedule(String id, int changeHour, boolean add){
        return this.weeklySchedule.changeSchdule(id, changeHour, add);
    }
}
