
import Gateway.ScheduleReadWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestScheduleReadWriter {
    static ScheduleReadWriter readWriter = new ScheduleReadWriter();
    static HashMap<String, Integer> schedules;

    @BeforeAll
    public static void setUp() {
        schedules = new HashMap<>();
        schedules.put("1001", 40);
        schedules.put("1002", 50);
    }

    @Test
    public void testSaveToFile() throws IOException, ClassNotFoundException {
        readWriter.saveToFile("schedule.test", schedules);

        OutputStream file = new FileOutputStream("schedule.test2");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(schedules);
        output.close();

        HashMap<String, Integer> actual = readWriter.readFromFile("schedule.test");
        HashMap<String, Integer> expected = readWriter.readFromFile("schedule.test2");

        for (int i = 0; i < actual.keySet().size(); i++){
            assertEquals(actual.keySet().toArray()[i], expected.keySet().toArray()[i]);
        }

        for (int i = 0; i < actual.values().size(); i++){
            assertEquals(actual.values().toArray()[i], expected.values().toArray()[i]);
        }
    }

    @Test
    public void testReadFromFile() throws ClassNotFoundException, IOException {
        HashMap<String, Integer> actual = readWriter.readFromFile("schedule.test");

        int totalHours = 0;
        for (int i = 0; i < actual.keySet().size(); i++){
            totalHours = totalHours + (int)actual.values().toArray()[i];
        }

        assertEquals(totalHours, 90);
    }
}
