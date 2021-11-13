package UseCase;

import Entity.Intern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InternManagement {

    private final HashMap<Intern, Integer> im;

    public InternManagement(){this.im = new HashMap<>();}

    public HashMap<Intern, Integer> getIm(){return this.im;}

    public Intern createIntern(String username, String password, String id, String email, String major){
        return new Intern(username, password, id, email, major);
    }

    public void registerInformation(String username, String password, String id,
                                    String email, String major, int grade){
        Intern intern = createIntern(username, password, id, email, major);
        this.im.put(intern, grade);
    }

    public void updateInformation(int standard){
        for(Map.Entry<Intern, Integer> ii : this.im.entrySet()){
            ii.getKey().setAcceptable(ii.getValue() >= standard);
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
