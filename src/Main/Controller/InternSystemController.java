package Controller;

import UseCase.InternManagement;

public class InternSystemController {
    private InternManagement internManagement;

    public InternSystemController(){this.internManagement = new InternManagement();}

    public InternManagement getInternManagement() {
        return internManagement;
    }

    public void registerInformation(String id1, String id2, String username, String password,
                                    String email, String major, int grade){
        this.internManagement.registerInformation(id1, id2, username, password, email, major, grade);
    }

    public void updateInformation(String id, int standard){
        this.internManagement.updateInformation(id, standard);
    }

    public boolean checkInformation(String id){
        return this.internManagement.checkInformation(id);
    }
}
