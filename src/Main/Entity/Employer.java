package Entity;

public class Employer extends User{

    public Employer(String username, String password, int salary,  boolean attendance, String ID){
        super(username, password, salary, attendance, ID );
    }

    @Override
    public String toString(){
        return "Employer {" + "username=" + username + ", salary = " + salary + ", attendance = " + attendance +
                ", ID = " + ID + "}";
    }
}