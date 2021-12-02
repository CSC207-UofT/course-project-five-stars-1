import UseCase.InternManager;
import Entity.Intern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class TestInternManager {
    static InternManager im;

    @BeforeAll
    public static void setUp(){im = new InternManager(new HashMap<Intern, Integer>());}

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
        HashMap<Intern, Integer> expected = new HashMap<Intern, Integer>();
        Intern expectedIntern = im.createIntern("ybb", "ybbybb", "50", "ybb@gmail.com", "ybb");
        expected.put(expectedIntern, 65);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateInformation(){
        im.registerInformation("ybb", "ybbybb", "50", "ybb@gmail.com", "ybb", 65);
        im.registerInformation("exx", "exxexx", "65", "exx@hotmail.com", "exx", 75);
        im.updateInformation(70);
        boolean actual1 = im.checkInformation("50");
        boolean actual2 = im.checkInformation("65");
        assertTrue(actual2);
        assertFalse(actual1);
    }
}
