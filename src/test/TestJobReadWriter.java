import Gateway.JobReadWriter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestJobReadWriter {
    static JobReadWriter readWriter = new JobReadWriter();
    static HashMap<String, String> jobs;

    @BeforeAll
    public static void setUp() {
        jobs = new HashMap<>();
        jobs.put("1001", "computer science");
        jobs.put("789", "economics");
    }

    @Test
    public void testSaveToFile() throws IOException, ClassNotFoundException {
        readWriter.saveToFile("job.test", jobs);

        OutputStream file = new FileOutputStream("job.test2");
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        output.writeObject(jobs);
        output.close();

        HashMap<String, String> actual = readWriter.readFromFile("job.test");
        HashMap<String, String> expected = readWriter.readFromFile("job.test2");

        boolean correct1 = actual.containsKey("1001") & actual.containsKey("789") &
                actual.containsValue("economics") & actual.containsValue("computer science");

        boolean correct2 = expected.containsKey("1001") & expected.containsKey("789") &
                expected.containsValue("economics") & expected.containsValue("computer science");

        assertEquals(correct1, correct2);

    }

    @Test
    public void testReadFromFile() throws ClassNotFoundException, IOException {
        HashMap<String, String> actual = readWriter.readFromFile("job.test");

        boolean correct = actual.containsKey("1001") & actual.containsKey("789") &
                actual.containsValue("economics") & actual.containsValue("computer science");

        assertTrue(correct);

    }
}

