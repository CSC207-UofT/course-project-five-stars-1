import UseCase.InternManager;
import Entity.Intern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class TestInternManager {
    static InternManager im;

    @BeforeAll
    public static void setUp(){im = new InternManager(new HashMap<>());}

    @Test
    public void testCreateNewIntern(){
        Intern expected = im.createIntern("ybb", "ybbybb", "50", "ybb@gmail.com", "ybb");
        assertEquals(expected.getUsername(), "ybb");
        assertEquals(expected.getPassword(), "ybbybb");
        assertEquals(expected.getID(), "50");
        assertEquals(expected.getEmail(), "ybb@gmail.com");
        assertEquals(expected.getMajor(), "ybb");
        assertFalse(expected.isAcceptable());
        assertFalse(expected.getAttendance());
        assertEquals(expected.getSalary(), 0);
    }

    @Test
    public void testRegisterInformation(){
        im.registerInformation("ybb", "ybbybb", "50", "ybb@gmail.com", "ybb", 65);
        HashMap<Intern, Integer> actual = im.getIm();
        Intern expected = im.createIntern("ybb", "ybbybb", "50", "ybb@gmail.com", "ybb");
        assertTrue(actual.containsValue(65));
        assertEquals(actual.keySet().toArray()[0].toString(),expected.toString());
    }

    @Test
    public void testUpdateInformation(){
        im.updateInformation(70);
        boolean actual1 = im.checkInformation("50");
        assertFalse(actual1);
    }
}
