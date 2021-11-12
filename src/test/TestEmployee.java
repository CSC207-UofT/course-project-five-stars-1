import Entity.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployee {
    static Employee employee;

    @BeforeAll
    public static void setUp() {employee = new Employee("testEmployee", "abcd9876",
            "123", "kt@gmail.com", "computer science");}

    @Test
    public void testConstructor(){
        assertEquals("testEmployee", employee.getUsername());
        assertEquals("abcd9876", employee.getPassword());
        assertEquals(0, employee.getSalary());
        assertEquals(false, employee.getAttendance());
        assertEquals("123", employee.getID());
        assertEquals("kt@gmail.com", employee.getEmail());
    }

    @Test
    public void testToString(){
        String expected = "Employee {Username = testEmployee, Salary = 0, Attendance = false, ID = 123}";
        assertEquals(expected, employee.toString());
    }

}
