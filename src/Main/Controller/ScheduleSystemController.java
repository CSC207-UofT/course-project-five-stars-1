package Controller;
import UseCase.WeeklySchedule;
import java.util.HashMap;

/**
 * Controls the WeeklySchedule system.
 */
public class ScheduleSystemController {
    private final WeeklySchedule weeklySchedule;

    public ScheduleSystemController(HashMap<String, Integer> schedules){
        this.weeklySchedule = new WeeklySchedule(schedules);
    }

    /**
     * Getter for WeeklySchedule
     * @return Weekly Schedule
     */
    public WeeklySchedule getWeeklySchedule() {
        return this.weeklySchedule;
    }

    /**
     * Add schedule into system based on the provided ID
     * @param id user's ID
     * @return "Cannot add your schedule since your information exists" if ID exists in system.
     * Add user into system with 40 hours schedule and
     * return "Add your schedule successfully" if ID does not exist in system
     */
    public String addSchedule(String id){
        return this.weeklySchedule.addSchedule(id);
    }

    /**
     * Get the hours based on the provided ID
     * @param id user's ID
     * @return the hours as an integer based on the ID
     */
    public int checkSchedule(String id){
        return this.weeklySchedule.getHour(id);
    }

    /**
     * Change the schedule
     * @param id user's ID
     * @param changeHour changing hour
     * @return "Failed to update your schedule " if ID does not exist in the system.
     * modify the schedule through provided ID and return "Update your schedule successfully" if ID exists.
     */
    public String changeSchedule(String id, int changeHour){
        return this.weeklySchedule.changeSchedule(id, changeHour);
    }
}
