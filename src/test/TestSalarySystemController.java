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
    public void testShowSalaryIDMatch(){
        ssc.getSalaryManagement().addSalary("123", 123);
        int expected_salary = ssc.getSalaryManagement().getSalary("123");
        int actual = ssc.showSalary("123");
        assertEquals(expected_salary, actual);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected_salary_string = "This is your salary for this month: " + ssc.showSalary("123");
        assertEquals(expected_salary_string, output.toString().trim());
    }


    @Test
    public void testShowSalaryIDNotMatch(){
        int expected_salary = ssc.showSalary("1");
        assertEquals(expected_salary, 0);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        ssc.showSalary("1");
        String expected_string = "Sorry, there does not exist your information";
        assertEquals(expected_string, output.toString().trim());
    }
}
