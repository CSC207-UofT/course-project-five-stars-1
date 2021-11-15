import UseCase.SalaryManagement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSalaryManagement {
    static SalaryManagement sm;

    @BeforeAll
    public static void setUp() {
        sm = new SalaryManagement(new HashMap<String, Integer>());
    }

    @Test
    public void testAddSalary(){
        boolean expected = sm.addSalary("123", 123);
        assertEquals(expected, true);
    }

    @Test
    public void testAddSalaryTwice() {
        boolean expected = sm.addSalary("234", 234);
        assertEquals(expected, true);
        boolean expected2 = sm.addSalary("234", 234);
        assertEquals(expected2, false);
    }

    @Test
    public void testGetSm() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("234", 234);
        assertEquals(expected, sm.getSm());
    }

    @Test
    public void testGetSalary() {
        int salary = sm.getSalary("234");
        assertEquals(salary, 234);
    }

    @Test
    public void testComputeYearlySalary() {
        int salary = sm.computeYearlySalary("123");
        assertEquals(salary, 1476);
    }

    @Test
    public void testSalaryAfterTax(){
        sm.addSalary("111", 45151);
        double salary1 = sm.salaryAfterTax("111");
        assertEquals(salary1, 477875.54150000005);
        sm.addSalary("222", 90000);
        double salary2 = sm.salaryAfterTax("222");
        assertEquals(salary2, 945238.0007);
        sm.addSalary("333", 200000);
        double salary3 = sm.salaryAfterTax("333");
        assertEquals(salary3, 2091526.0007000002);
    }
}