import Entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployee {
    static Employee employee;

    @BeforeAll
    public static void setUp() {employee = new Employee("testEmployee", "abcd9876",
            20000, true, "123");}

    @Test
    public void testConstructor(){
        assertEquals("testEmployee", employee.getUsername());
        assertEquals("abcd9876", employee.getPassword());
        assertEquals(20000, employee.getSalary());
        assertEquals(true, employee.getAttendance());
        assertEquals("123", employee.getID());
    }

    @Test
    public void testToString(){
        String expected = "Employee {Username = testEmployee, Salary = 20000, Attendance = true, ID = 123}";
        assertEquals(expected, employee.toString());
    }

}
