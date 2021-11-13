import Controller.SalarySystemController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSalarySystemController {
    private static SalarySystemController ssc;

    @BeforeAll
    public static void setUpSalarySystemController(){
        ssc = new SalarySystemController();
    }

    @Test
    public void testShowSalary(){
        ssc.getSalaryManagement().addSalary("123", 100);
        String actual = ssc.showSalary("123");
        String expected = "This is your salary for this month: 100. This is your salary for this year: 1200. This is your yearly salary after tax: 1139.4.";
        assertEquals(expected, actual);
    }

    @Test
    public void testShowSalaryThatIDNotExist(){
        String expected = "Sorry, there does not exist your information";
        String actual = ssc.showSalary("1");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddSalary() {
        String expected = "There is no user match";
        String actual = ssc.addSalary("0", "111", 1000);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddSalary2(){
        String expected = " Employer has added your salary";
        String actual = ssc.addSalary("0", "112", 10000);
        assertEquals(expected, actual);
        int actually = ssc.getSalaryManagement().getSalary("112");
        assertEquals(10000, actually);
    }
}
