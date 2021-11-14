import Controller.InternSystemController;
import Entity.Intern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestInternSystemController {
    private static InternSystemController internSystemController;

    @BeforeAll
    public static void setUp(){internSystemController = new InternSystemController(new HashMap<Intern, Integer>());}

    @Test
    public void testRegisterInformation1(){
        String expected = "Successful, you have registered this information to our system.";
        String actual = internSystemController.registerInformation("0", "111", "kk", "1233",
                "kk@qq.com", "cs", 90);
        assertEquals(expected, actual);
        assertTrue(internSystemController.getOurMap().containsValue(90));
    }

    @Test
    public void testRegisterInformation2(){
        String expected = "You do not have the authority to edit this file";
        String actual = internSystemController.registerInformation("111", "112", "george", "123456",
                "abc@hotmail.com", "cs", 80);
        assertEquals(expected, actual);
        assertFalse(internSystemController.getOurMap().containsValue(80));
    }

    @Test
    public void testUpdateInformationAndCheckInformation1(){
        String expected = "Successful, the file has been edit successfully";
        internSystemController.registerInformation("0", "112", "george", "123456",
                "abc@hotmail.com", "cs", 80);
        String actual = internSystemController.updateInformation("0", 80);
        assertEquals(expected, actual);
        assertTrue(internSystemController.checkInformation("112"));
    }

    @Test
    public void testUpdateInformationAndCheckInformation2(){
        String expected = "Sorry, you do not have the authority to edit this file";
        String actual = internSystemController.updateInformation("1122", 70);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateInformationAndCheckInformation3(){
        internSystemController.registerInformation("0", "1177", "Khan", "123456",
                "ktabpd@gmail.com", "cs", 84);
        internSystemController.updateInformation("0", 90);
        assertFalse(internSystemController.checkInformation("1177"));
    }
}
