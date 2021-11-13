import Entity.Employer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployer {
    static Employer employer;

    @BeforeAll
    public static void setUp() {employer = new Employer("testEmployer", "abcd1234",
            "0", "gb@gmail.com", "cs");}

    @Test
    public void testConstructor(){
        assertEquals("testEmployer", employer.getUsername());
        assertEquals("abcd1234", employer.getPassword());
        assertEquals(0, employer.getSalary());
        assertEquals(false, employer.getAttendance());
        assertEquals("0", employer.getID());
        assertEquals("gb@gmail.com", employer.getEmail());
    }

    @Test
    public void testToString(){
        String expected = "Employer {Username = testEmployer, Salary = 0, Attendance = false, ID = 0}";
        assertEquals(expected, employer.toString());
    }

}
