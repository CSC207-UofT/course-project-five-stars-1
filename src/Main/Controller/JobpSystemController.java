package Controller;
import UseCase.Jobposition;
import java.util.Objects;

public class JobpSystemController {
    private Jobposition jobposition;
    public JobpSystemController(){this.jobposition = new Jobposition();}
    public Jobposition getJobposition(){
        return jobposition;
    }
    public String addMajor(String id, String major){
        return jobposition.addMajor(id, major);
    }
    public String getMajor(String id){
        return jobposition.getMajor(id);
    }
    public String getReference(String major){
        System.out.println("Here is the job position we recommend to you: ");
        return jobposition.getReference(major);
    }
}
