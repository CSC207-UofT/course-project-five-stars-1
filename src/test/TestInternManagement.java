import Entity.Intern;
import UseCase.InternManagement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class TestInternManagement {
    static InternManagement internManagement;

    @BeforeAll
    public static void setUp(){internManagement = new InternManagement(new HashMap<Intern, Integer>());}

    @Test
    public void testCreateIntern(){
        Intern intern = new Intern("jack", "123456", "123", "jack@hotmail.com", "computer science");
        assertEquals(intern, internManagement.createIntern("jack", "123456", "123", "jack@hotmail.com", "computer science"));
    }

    @Test
    public void testRegisterInformation(){
        Intern intern = new Intern("jack", "123456", "123", "jack@hotmail.com", "computer science");
        int expected = 90;
        internManagement.registerInformation("jack", "123456", "123", "jack@hotmail.com", "computer science", 90);
        int actual = internManagement.getIm().get(intern);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateAndCheckInformation1(){
        internManagement.registerInformation("pizza", "123456", "1022", "pizza@hotmail.com", "computer science", 75);
        internManagement.updateInformation(85);
        assertFalse(internManagement.checkInformation("1022"));
    }

    @Test
    public void testUpdateAndCheckInformation2(){
        internManagement.registerInformation("klee", "123456", "1034", "klee@qq.com", "cs", 86);
        internManagement.updateInformation(80);
        assertTrue(internManagement.checkInformation("1034"));
    }
}
