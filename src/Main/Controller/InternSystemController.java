package Controller;

import Entity.Intern;
import Gateway.InternReadWriter;
import UseCase.InternManagement;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class InternSystemController {
    private final InternManagement internManagement;

    InternReadWriter readWriter = new InternReadWriter();

    public InternSystemController(HashMap<Intern, Integer> intern){
        this.internManagement = new InternManagement(intern);
    }

    public HashMap<Intern, Integer> getOurMap() {
        return internManagement.getIm();
    }

    public String registerInformation(String id1, String id2, String username, String password,
                                    String email, String major, int grade){
        if (Objects.equals(id1, "0")){
            this.internManagement.registerInformation(username, password, id2, email, major, grade);
            return "Successful, you have registered this information to our system.";
        } else {
            return "You do not have the authority to edit this file";
        }
    }

    public String updateInformation(String id, int standard){
        if (Objects.equals(id, "0")){
            this.internManagement.updateInformation(standard);
            return "Successful, the file has been edit successfully";
        } else {
            return "Sorry, you do not have the authority to edit this file";
        }
    }

    public boolean checkInformation(String id){
        return this.internManagement.checkInformation(id);
    }
}
