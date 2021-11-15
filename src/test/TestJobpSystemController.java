import Controller.JobpSystemController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJobpSystemController {
    static JobpSystemController jsc;

    @BeforeAll
    public static void setUpJobPSystemController(){
        jsc = new JobpSystemController(new HashMap<String, String>());
    }

    @Test
    public void testGetJobposition(){
        jsc = new JobpSystemController(new HashMap<String, String>());
        jsc.addMajor("200", "computer science");
        JobpSystemController actual = jsc;
        HashMap<String, String> expected = new HashMap<>();
        expected.put("200", "computer science");
        assertEquals(expected, actual.getJobposition().getMajorMap());
    }

    @Test
    public void testAddMajor(){
        jsc = new JobpSystemController(new HashMap<String, String>());

        String actual = jsc.addMajor("200", "computer science");
        assertEquals("computer science", actual);

        String actual2 = jsc.addMajor("200", "computer science");
        assertEquals("", actual2);

        String actual3 = jsc.addMajor("200", "data science");
        assertEquals("", actual3);

        String actual4 = jsc.addMajor("210", "data science");
        assertEquals("data science", actual4);


    }
    @Test
    public void testGetMajor(){
        jsc.addMajor("200", "computer science");
        jsc.addMajor("210", "data science");
        String actual = jsc.getMajor("200");
        assertEquals("computer science", actual);
        String actual1 = jsc.getMajor("210");
        assertEquals("data science", actual1);
    }

    @Test
    public void testGetReferenceCS(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("computer science");
        String actual = "IT department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceDS(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("data science");
        String actual = "IT department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceFIN(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("finance");
        String actual = "sale department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceECO(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("economic");
        String actual = "sale department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceMANA(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("management");
        String actual = "HR department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceSS(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("social science");
        String actual = "HR department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceNUR(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("nursery");
        String actual = "Logistics department";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetReferenceNONE(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected = jsc.getReference("media");
        String actual = "Our company doesn't have suitable job reference for you based on your id and you can think twice" +
                " to decide a job you would like to do.";
        assertEquals(expected, actual);
        String expected_string = "Here is the job position we recommend to you:";
        assertEquals(expected_string, output.toString().trim());
    }
}
