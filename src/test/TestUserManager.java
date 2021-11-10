import UseCase.UserManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Entity.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserManager {
    static UserManager um;

    @BeforeAll
    public static void setUp() {
        um = new UserManager();
    }

    @Test
    public void testCreateEmployer(){
        um = new UserManager();
        ArrayList<User> expected = new ArrayList<>();
        Employer employer = new Employer("testEmployer", "imthebest", 100000, true, "0", "kt@gmail.com");
        expected.add(employer);
        um.createEmployer("testEmployer", "imthebest", 100000, true, "0", "kt@gmail.com");
        assertEquals(expected.get(0).getUsername(), um.getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), um.getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), um.getUm().get(0).getPassword());
        assertEquals(expected.get(0).getPassword(), um.getUm().get(0).getPassword());
        assertEquals(expected.get(0).getSalary(), um.getUm().get(0).getSalary());
        assertEquals(expected.get(0).getEmail(), um.getUm().get(0).getEmail());
    }

    @Test
    public void testCreateEmployee(){
        ArrayList<User> expected = new ArrayList<>();
        Employee employee = new Employee("testEmployee", "imtheworst", 10000, true, "111", "gb@gmail.com");
        expected.add(employee);
        um.createEmployee("testEmployee", "imtheworst", 10000, true, "111", "gb@gmail.com");
        assertEquals(expected.get(0).getUsername(), um.getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), um.getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), um.getUm().get(0).getPassword());
        assertEquals(expected.get(0).getPassword(), um.getUm().get(0).getPassword());
        assertEquals(expected.get(0).getSalary(), um.getUm().get(0).getSalary());
        assertEquals(expected.get(0).getEmail(), um.getUm().get(0).getEmail());
    }

    @Test
    public void testVerifyUser(){
        um.createEmployee("testEmployee", "imtheworst", 10000, true, "111", "gb@gmail.com");
        boolean expected = um.verifyUser("98716348919371937");
        assertEquals(expected, false);
        boolean expected2 = um.verifyUser("111");
        assertEquals(expected2, true);
    }

    @Test
    public void testGetUserFromID(){
        um.createEmployee("testEmployee", "imtheworst", 10000, true, "111", "gb@gmail.com");
        String expected = um.getUserFromId("111");
        String actual = "Employee {Username = testEmployee, Salary = 10000, Attendance = true, ID = 111}";
        assertEquals(expected, actual);
    }


}