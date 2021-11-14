package Controller;

import Entity.Intern;
import Gateway.InternReadWriter;
import UseCase.InternManagement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
/**
 * Controls the Intern system.
 */
public class InternSystemController {
    private final InternManagement internManagement;

    InternReadWriter readWriter = new InternReadWriter();

    public InternSystemController(HashMap<Intern, Integer> intern){
        this.internManagement = new InternManagement(intern);
    }
    /**
     * Getter internManagement
     * @return internManagement.
     */
    public HashMap<Intern, Integer> getOurMap() {
        return internManagement.getIm();
    }


    /**
     * Print out you are registered.
     * Otherwise, print "You do not have the authority to edit this file"
     * @param id1 A unique String for each User.
     * @param id2 A unique String for each User.
     * @param username A unique String for each User.
     * @param password A unique String for each User.
     * @param email A unique String for each User.
     * @param major A unique String for each User.
     * @param grade A unique integer for each User.
     */
    public String registerInformation(String id1, String id2, String username, String password,
                                    String email, String major, int grade){
        if (Objects.equals(id1, "0")){
            this.internManagement.registerInformation(username, password, id2, email, major, grade);
            return "Successful, you have registered this information to our system.";
        } else {
            return "You do not have the authority to edit this file";
        }
    }
    /**
     * Print out the file is edited successfully.
     * Otherwise, print "Sorry, you do not have the authority to edit this file"
     * @param id A unique String for each User.
     * @param standard A unique Integer for each User.
     */
    public String updateInformation(String id, int standard){
        if (Objects.equals(id, "0")){
            this.internManagement.updateInformation(standard);
            return "Successful, the file has been edit successfully";
        } else {
            return "Sorry, you do not have the authority to edit this file";
        }
    }
    /**
     * Getter internManagement
     * @return internManagement.
     */
    public boolean checkInformation(String id){
        return this.internManagement.checkInformation(id);
    }
}
