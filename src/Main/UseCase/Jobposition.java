package UseCase;

import java.util.HashMap;
import java.util.Objects;

public class Jobposition {
    private final HashMap<String, String> majorMap;

    public Jobposition() { this. majorMap = new HashMap<>();}

    public String addMajor(String id, String major){
        if (this.majorMap.containsKey(id)) {
            return "";
        }else{
            this.majorMap.put(id, major);
            return major;
        }
    }
    public HashMap<String, String> getMajorMap (){
        return this.majorMap;
    }
    public String getMajor(String id){
        return this.majorMap.get(id);
    }
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
            return " Our company doesn't have suitable job reference for you based on your id and you can think twice" +
                    " to decide a job you would like to do ";
        }

    }


}
