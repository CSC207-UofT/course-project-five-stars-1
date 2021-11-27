import Gateway.SalaryReadWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSalaryReadWriter {
    static SalaryReadWriter readWriter = new SalaryReadWriter();
    static HashMap<String, Integer> salaries;

    @BeforeAll
    public static void setUp() {
        salaries = new HashMap<>();
        salaries.put("1001", 10000);
        salaries.put("1002", 20000);
    }

    @Test
    public void testSaveToFile() throws IOException, ClassNotFoundException {
        readWriter.saveToFile("salary.test", salaries);

        OutputStream file = new FileOutputStream("salary.test2");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(salaries);
        output.close();

        HashMap<String, Integer> actual = readWriter.readFromFile("salary.test");
        HashMap<String, Integer> expected = readWriter.readFromFile("salary.test2");

        for (int i = 0; i < actual.keySet().size(); i++){
            assertEquals(actual.keySet().toArray()[i], expected.keySet().toArray()[i]);
        }

        for (int i = 0; i < actual.values().size(); i++){
            assertEquals(actual.values().toArray()[i], expected.values().toArray()[i]);
        }
    }

    @Test
    public void testReadFromFile() throws ClassNotFoundException, IOException {
        HashMap<String, Integer> actual = readWriter.readFromFile("salary.test");

        int totalSalary = 0;
        for (int i = 0; i < actual.keySet().size(); i++){
            totalSalary = totalSalary + (int)actual.values().toArray()[i];
        }

        assertEquals(totalSalary, 30000);
    }
}
