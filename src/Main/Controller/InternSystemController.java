package Controller;

import UseCase.InternManagement;

import java.util.Objects;

public class InternSystemController {
    private InternManagement internManagement;

    public InternSystemController(){this.internManagement = new InternManagement();}

    public InternManagement getInternManagement() {
        return internManagement;
    }

    public void registerInformation(String id1, String id2, String username, String password,
                                    String email, String major, int grade){
    if (Objects.equals(id1, "0")){
        this.internManagement.registerInformation(username, password, id2, email, major, grade);
        System.out.println("Successful, you have registered this information to our system.");
    } else {
        System.out.println("You do not have the authority to edit this file");
    }
    }

    public void updateInformation(String id, int standard){
        if (Objects.equals(id, "0")){
            this.internManagement.updateInformation(standard);
            System.out.println("Successful, the file has been edit successfully");
        } else {
            System.out.println("Sorry, you do not have the authority to edit this file");
        }
    }

    public boolean checkInformation(String id){
        return this.internManagement.checkInformation(id);
    }
}
