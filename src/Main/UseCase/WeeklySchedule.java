package UseCase;

import Gateway.SalaryReadWriter;

import java.io.IOException;
import java.util.HashMap;

/**
 * Represents a Weekly Schedule system
 */
public class WeeklySchedule {
    /**
     * Creates a WeeklySchedule with an empty Hashmap
     * (A string as its key and an integer as its value)
     */
    private final HashMap<String, Integer> scm;

    SalaryReadWriter readWriter = new SalaryReadWriter();

    /**
     * Define a constructor.
     */
    public WeeklySchedule(HashMap<String, Integer> schedules){
        this.scm = schedules;

        try {
            readWriter.saveToFile("schedules.ser", schedules);
            System.out.println("Schedule list saved!");
        } catch (IOException e) {
            System.out.println("Schedule list did not save.");
        }

        try {
            System.out.println(readWriter.readFromFile("schedules.ser"));
            System.out.println("Schedule file read successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read.");
        }
    }

    /**
     * Adds schedule into WeeklySchedule(scm) with ID as its key and fixed value 40 as its value.
     * @param id user's ID
     * @return "Cannot add your schedule since there is no id" if ID does not match,
     *         else add id as key and 40 as value into scm and return "Add your schedule successfully"
     */
    public String addSchedule(String id) {
        if (this.scm.containsKey(id)) {
            return "Cannot add your schedule since there is no id";
        } else {
            this.scm.put(id, 40);
            return "Add your schedule successfully";
        }
    }

    /**
     * Getter for WeeklySchedule
     * @return WeeklySchedule(scm)
     */
    public HashMap<String, Integer> getSm (){
        return this.scm;
    }

    /**
     * Getter for user's schedule based on provided ID
     * @param id User's ID
     * @return user's schedule as a string
     */
    public int getHour(String id){
        return this.scm.get(id);
    }

    /**
     * Update user's schedule based on provided ID.
     * @param id User's ID
     * @param changeHour add hours (positive or negative)
     * @return "Failed to update your schedule " if ID does not match;
     *         else add changeHour to hour based on the provided ID
     *         and return "Update your schedule successfully"
     */
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
