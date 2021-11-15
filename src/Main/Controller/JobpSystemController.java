package Controller;
import UseCase.Jobposition;

import java.util.HashMap;
// import java.util.Objects;

public class JobpSystemController {
    private final Jobposition jobposition;
    /**
     * Getter jobposition
     * create new jobposition.
     */
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
     * Getter jobposition
     * @return jobposition.addMajor.
     */
    public String addMajor(String id, String major){
        return jobposition.addMajor(id, major);
    }
    public String getMajor(String id){
        return jobposition.getMajor(id);
    }
    /**
     * Getter jobposition
     * @return str
     */
    public String getReference(String major){
        System.out.println("Here is the job position we recommend to you: ");
        return jobposition.getReference(major);
    }
}
