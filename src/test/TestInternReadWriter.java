import Entity.Intern;
import Gateway.InternReadWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInternReadWriter {
    static InternReadWriter readWriter = new InternReadWriter();
    static HashMap<Intern, Integer> interns;
    static Intern intern;

    @BeforeAll
    public static void setUp() {
        interns = new HashMap<>();
        intern = new Intern("Lewis Ham", "anton123", "1026",
                "lewis1026@gmail.com", "computer science");
        interns.put(intern, 60);
    }

    @Test
    public void testSaveToFile() throws IOException, ClassNotFoundException {
        readWriter.saveToFile("intern.test", interns);

        OutputStream file = new FileOutputStream("intern.test2");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(interns);
        output.close();

        HashMap<String, Integer> actual = readWriter.readFromFile("intern.test");
        HashMap<String, Integer> expected = readWriter.readFromFile("intern.test2");

        for (int i = 0; i < actual.keySet().size(); i++){
            assertEquals(actual.keySet().toArray()[i].toString(), expected.keySet().toArray()[i].toString());
        }

        for (int i = 0; i < actual.values().size(); i++){
            assertEquals(actual.values().toArray()[i], expected.values().toArray()[i]);
        }
    }

    @Test
    public void testReadFromFile() throws ClassNotFoundException, IOException {
        HashMap<String, Integer> actual = readWriter.readFromFile("intern.test");
        String expected = "Intern {Username = Lewis Ham, Salary = 0, Attendance = false, Acceptable = false, ID = 1026, Email = lewis1026@gmail.com}";

        for (int i = 0; i < actual.keySet().size(); i++){
            assertEquals(actual.keySet().toArray()[i].toString(), expected);
        }
    }
}
