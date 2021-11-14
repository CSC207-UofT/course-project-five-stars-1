package UseCase;

import Gateway.JobReadWriter;
import Gateway.SalaryReadWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/**
 * Represents the job system
 */
public class Jobposition {
    /**
     * Creates a Jobposition with an empty Hashmap
     * (A String as its key and a String as its value)
     */
    private final HashMap<String, String> majorMap;

    JobReadWriter readWriter = new JobReadWriter();

    /**
     * Define a constructor.
     */
    public Jobposition(HashMap<String, String> jobs) {
        this.majorMap = new HashMap<>();

        try {
            readWriter.saveToFile("jobs.ser", jobs);
            System.out.println("Jobs list saved!");
        } catch (IOException e) {
            System.out.println("Jobs list did not save.");
        }

        try {
            System.out.println(readWriter.readFromFile("jobs.ser"));
            System.out.println("Jobs  file read successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read.");
        }
    }

    /**
     * Adds major into Jobposition with id as its key and major as its value
     * @param id user's ID
     * @param major user's major
     * @return empty string if user exists,
     * else adds id as key and major as value into majorMap and return major
     */
    public String addMajor(String id, String major){
        if (this.majorMap.containsKey(id)) {
            return "";
        }else{
            this.majorMap.put(id, major);
            return major;
        }
    }

    /**
     * Getter for majorMap
     * @return majorMap
     */
    public HashMap<String, String> getMajorMap (){
        return this.majorMap;
    }

    /**
     * Getter for major
     * @param id user's ID
     * @return User's major by its ID
     */
    public String getMajor(String id){
        return this.majorMap.get(id);
    }

    /**
     * Getter for reference(IT department, Sale department, HR department, Logistics department)
     * based on user's major.
     * @param major user's major
     * @return IT department if major is computer science or data science;
     *         sale department if major is finance or economic;
     *         HR department if major is management or social science;
     *         Logistics department if major is nursery;
     *         "Our company doesn't have suitable job reference for you based on your id
     *         and you can think twice to decide a job you would like to do" if major is not
     *         computer science, finance, management, and nursery.
     */
    public String getReference(String major){
        if (Objects.equals(major, "computer science" ) | Objects.equals(major, "data science")){
            return "IT department";
        } else if(Objects.equals(major, "finance") | Objects.equals(major, "economic")){
            return "sale department";
        } else if(Objects.equals(major, "management") | Objects.equals(major, "social science")){
            return "HR department";
        }else if (Objects.equals(major, "nursery")){
            return "Logistics department";
        }else{
            return "Our company doesn't have suitable job reference for you based on your id and you can think twice" +
                    " to decide a job you would like to do.";
        }

    }


}
