import Controller.SalarySystemController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSalarySystemController {
    private static SalarySystemController ssc;

    @BeforeAll
    public static void setUpSalarySystemController(){
        ssc = new SalarySystemController(new HashMap<String, Integer>());
    }

    @Test
    public void testShowSalary(){
        ssc.getSalaryManagement().addSalary("123", 100);
        String actual = ssc.showSalary("123");
        String expected = "This is your salary for this month: 100. This is your salary for this year: 1200. " +
                "This is your yearly salary after tax: 1139.4.";
        assertEquals(expected, actual);
    }

    @Test
    public void testShowSalaryThatIDNotExist(){
        String expected = "Sorry, there does not exist your information";
        String actual = ssc.showSalary("1");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddSalaryU1U2(){
        ssc.getSalaryManagement().addSalary("111", 5000);
        String expected = "Added salary of employee(id: 111) successfully";
        String actual = ssc.addSalary("0", "111", 20000);
        assertEquals(expected, actual);
    }
    @Test
    public void testAddSalary1U2Not(){
        ssc.getSalaryManagement().addSalary("111", 5000);
        String expected = "User information added successfully.";
        String actual = ssc.addSalary("1", "121", 5000);
        assertEquals(expected, actual);
    }
    @Test
    public void testAddSalary1UNotU2(){
        ssc.getSalaryManagement().addSalary("111", 5000);
        String expected = "You don't have the authority to add salary.";
        String actual = ssc.addSalary("1", "111", 20000);
        assertEquals(expected, actual);
    }
}
