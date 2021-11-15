package Controller;
import UseCase.Jobposition;

import java.util.HashMap;
// import java.util.Objects;
/**
 * Controls the Jobposition system.
 */
public class JobpSystemController {
    private final Jobposition jobposition;

    public JobpSystemController(HashMap<String, String> jobs){
        this.jobposition = new Jobposition(jobs);
    }
    /**
     * Getter jobposition
     * @return jobposition.
     */
    public Jobposition getJobposition(){
        return jobposition;
    }

    /**
     * Create user's major in system
     * @param id user's ID
     * @param major user's Major
     * @return '' if user exists,
     * else add user into system with major and return major as a string if user does not exist in system.
     */
    public String addMajor(String id, String major){
        return jobposition.addMajor(id, major);
    }

    /**
     * Getter user's major based on the provided ID
     * @param id user's ID
     * @return major as a string based on the provided ID
     */
    public String getMajor(String id){
        return jobposition.getMajor(id);
    }
    /**
     * Get the department based on the major.
     * @return the department name as a string,
     * else return "Our company doesn't have suitable job reference for you based on your id
     * and you can think twice to decide a job you would like to do" if major is not
     * computer science, finance, management, and nursery.
     */
    public String getReference(String major){
        System.out.println("Here is the job position we recommend to you: ");
        return jobposition.getReference(major);
    }
}
