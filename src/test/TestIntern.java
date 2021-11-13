
import Entity.Intern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestIntern {
    static Intern intern;

    @BeforeAll
    public static void setUp() {intern = new Intern("Lewis Ham", "anton123", "1026",
            "lewis1026@gmail.com", "computer science");}

    @Test
    public void testConstructor() {
        assertEquals("Lewis Ham", intern.getUsername());
        assertEquals("anton123", intern.getPassword());
        assertEquals("1026", intern.getID());
        assertEquals("lewis1026@gmail.com", intern.getEmail());
        assertEquals("computer science", intern.getMajor());
        assertFalse(intern.isAcceptable());
    }

    @Test
    public void testToString(){
        String expected = "Intern {Username = Lewis Ham, Salary = 0, Attendance = false, Acceptable = false, ID = 1026, " +
                "Email = lewis1026@gmail.com}";
        assertEquals(expected, intern.toString());
    }
}
