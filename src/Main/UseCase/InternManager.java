package UseCase;

import Entity.Intern;
import Entity.UserFactory;
import Gateway.InternReadWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents the intern system
 */
public class InternManager {
    /**
     * Creates a InternManager with an empty Hashmap
     * (Intern as its key and an integer as its value)
     */
    private final HashMap<Intern, Integer> im;
    /**
     * Define a constructor.
     */
    public InternManager(HashMap<Intern, Integer> intern){
        this.im = new HashMap<>();

        InternReadWriter readWriter = new InternReadWriter();

        try {
            readWriter.saveToFile("intern.ser", intern);
            System.out.println("Intern list saved!");
        } catch (IOException e) {
            System.out.println("Intern list did not save.");
        }

        try {
            System.out.println(readWriter.readFromFile("intern.ser"));
            System.out.println("Intern file read successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Cannot read.");
        }}

    /**
     * Getter for InternManager in the form of Hashmap.
     * @return a Hashmap with Intern as key and an integer as value.
     */
    public HashMap<Intern, Integer> getIm(){return this.im;}

    /**
     * Creates a new intern into system with its username, password, id, email, major
     * @param username intern's username
     * @param password intern's password
     * @param id intern's id
     * @param email intern's email
     * @param major intern's major
     * @return a user with its username, password, id, email, major as an Intern
     */

    public Intern createIntern(String username, String password, String id, String email, String major){
        return new Intern(username, password, id, email, major);
    }

    /**
     * Adds intern's register information into InternManager with Intern as key, grade as value.
     * @param username intern's username
     * @param password intern's password
     * @param id intern's ID
     * @param email intern's email
     * @param major intern's major
     * @param grade intern's grade
     */
    public void registerInformation(String username, String password, String id,
                                    String email, String major, int grade){
        Intern intern = createIntern(username, password, id, email, major);
        this.im.put(intern, grade);
    }

    /**
     * Updates acceptable state for intern if intern's grade greater than or equals to standard.
     * @param standard acceptable standard for intern
     */
    public void updateInformation(int standard){
        for(Map.Entry<Intern, Integer> ii : this.im.entrySet()){
            ii.getKey().setAcceptable(ii.getValue() >= standard);
        }
    }

    /**
     * Check valid information for intern by id
     * @param id intern's id
     * @return intern's acceptable states if intern's id is valid, return false otherwise.
     */
    public boolean checkInformation(String id){
        for (Map.Entry<Intern, Integer> ii: this.im.entrySet()){
            if (Objects.equals(ii.getKey().getID(), id)){
                return ii.getKey().isAcceptable();
            }
        }
        return false;
    }
}
