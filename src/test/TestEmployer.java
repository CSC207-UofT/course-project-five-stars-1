
import Entity.Employer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployer{
    static Employer er;

    @BeforeAll
    public static void setUp(){er = new Employer("","","", "", "");}

    @Test
    public void testEmployer(){
        er = new Employer("testEmployer",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        assertEquals("testEmployer", er.getUsername());
        assertEquals("imtheworst", er.getPassword());
        assertEquals("111", er.getID());
        assertEquals("gb@gmail.com", er.getEmail());
        assertEquals("computer science", er.getMajor());
    }
    @Test
    public void testToString(){
        er = new Employer("testEmployer",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        String expected = "Employer {Username = testEmployer, " +
                "Salary = 0, Attendance = false, ID = 111, " +
                "Email = gb@gmail.com, Major = computer science}";
        assertEquals(expected, er.toString());}
}