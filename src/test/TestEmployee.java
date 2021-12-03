import Entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployee {
    static Employee ee;

    @BeforeAll
    public static void setUp(){ee = new Employee("","","", "", "");}

    @Test
    public void testEmployee(){
        ee = new Employee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        assertEquals("testEmployee", ee.getUsername());
        assertEquals("imtheworst", ee.getPassword());
        assertEquals("111", ee.getID());
        assertEquals("gb@gmail.com", ee.getEmail());
        assertEquals("computer science", ee.getMajor());
    }
    @Test
    public void testToString(){
        ee = new Employee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        String expected = "Employee {Username = testEmployee, " +
                "Salary = 0, Attendance = false, ID = 111, " +
                "Email = gb@gmail.com, Major = computer science}";
        assertEquals(expected, ee.toString());}
}
