package UseCase;

import Entity.Intern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InternManagement {

    private HashMap<Intern, Integer> im;

    public InternManagement(){this.im = new HashMap<Intern, Integer>();}

    public HashMap<Intern, Integer> getIm(){return this.im;}

    public Intern createIntern(String username, String password, String id, String email, String major){
        return new Intern(username, password, id, email, major);
    }

    public void registerInformation(String id1, String username, String password, String id2,
                                    String email, String major, int grade){
        if (Objects.equals(id1, "0")){
            Intern intern = createIntern(username, password, id2, email, major);
            this.im.put(intern, grade);
        } else {
            System.out.println("You can not edit this file");
        }
    }

    public void updateInformation(String id, int standard){
        if (Objects.equals(id, "0")){
            for(Map.Entry<Intern, Integer> ii : this.im.entrySet()){
                ii.getKey().setAcceptable(ii.getValue() >= standard);
            }
        } else {
            System.out.println("You can not edit this file");
        }
    }

    public boolean checkInformation(String id){
        for (Map.Entry<Intern, Integer> ii: this.im.entrySet()){
            if (Objects.equals(ii.getKey().getID(), id)){
                return ii.getKey().isAcceptable();
            }
        }
        return false;
    }
}
