import UseCase.JobPositions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJobPositions {
    static JobPositions jp;

    @BeforeAll
    public static void setUp() {
        jp = new JobPositions(new HashMap<String, String>());
    }

    @Test
    public void testAddMajorUNotExist(){
        jp = new JobPositions(new HashMap<String, String>());
        String actual = jp.addMajor("234", "computer science");
        String expected = "computer science";
        assertEquals(expected, actual);
    }

    @Test
    public void testAddMajorUExist() {
        jp.addMajor("234", "computer science");
        String actual = jp.addMajor("234", "computer science");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMajorMap(){
        HashMap<String, String> expected = new HashMap<>();
        expected.put("234", "computer science");
        assertEquals(expected, jp.getMajorMap());
    }

    @Test
    public void testGetMajor(){
        jp = new JobPositions(new HashMap<String, String>());
        jp.addMajor("234", "computer science");
        String actual = jp.getMajor("234");
        String expected = "computer science";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetReference(){
        String expectedCS = jp.getReference("computer science");
        String actualCS = "IT department";
        assertEquals(expectedCS, actualCS);

        String expectedDS = jp.getReference("data science");
        String actualDS = "IT department";
        assertEquals(expectedDS, actualDS);

        String expectedFIN = jp.getReference("finance");
        String actualFIN = "sale department";
        assertEquals(expectedFIN, actualFIN);

        String expectedECO = jp.getReference("economic");
        String actualECO = "sale department";
        assertEquals(expectedECO, actualECO);

        String expectedMANA = jp.getReference("management");
        String actualMANA = "HR department";
        assertEquals(expectedMANA, actualMANA);

        String expectedSS = jp.getReference("social science");
        String actualSS = "HR department";
        assertEquals(expectedSS, actualSS);

        String expectedNUR = jp.getReference("nursery");
        String actualNUR = "Logistics department";
        assertEquals(expectedNUR, actualNUR);

        String expectedNONE = jp.getReference("media");
        String actualSSNONE = "Our company doesn't have suitable job reference for you based on your id and you can think " +
                "twice to decide a job you would like to do.";
        assertEquals(expectedNONE, actualSSNONE);


    }
}
