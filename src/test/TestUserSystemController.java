import Controller.UserSystemController;
import Entity.Employee;
import Entity.Employer;
import Entity.User;
import UseCase.UserManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserSystemController {
    private static UserSystemController usc;
    private static UserManager um;

    @BeforeAll
    public static void setUpUserSystemController() {usc = new UserSystemController();}

    @Test
    public void testCreateEmployer(){
        usc = new UserSystemController();
        ArrayList<User> expected = new ArrayList<>();
        Employer employer = new Employer("testEmployer", "imthebest", 100000, true, "0");
        expected.add(employer);
        usc.getUserManager().createEmployer("testEmployer", "imthebest", 100000, true, "0");
        usc.create("testEmployer", "imthebest", 100000, true, "0");
        assertEquals(expected.get(0).getUsername(), usc.getUserManager().getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), usc.getUserManager().getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getSalary(), usc.getUserManager().getUm().get(0).getSalary());

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        usc.create("testEmployer", "imthebest", 100000, true, "0");
        String expected_string = "Successful!!";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testCreateEmployee(){
        usc = new UserSystemController();
        ArrayList<User> expected = new ArrayList<>();
        Employee employee = new Employee("testEmployee", "imthebest", 100000, true, "111");
        expected.add(employee);
        usc.getUserManager().createEmployee("testEmployee", "imthebest", 100000, true, "111");
        usc.create("testEmployee", "imthebest", 100000, true, "111");
        assertEquals(expected.get(0).getUsername(), usc.getUserManager().getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), usc.getUserManager().getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getSalary(), usc.getUserManager().getUm().get(0).getSalary());

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        usc.create("testEmployee", "imthebest", 100000, true, "0");
        String expected_string = "Successful!!";
        assertEquals(expected_string, output.toString().trim());
    }

    @Test
    public void testGetUserManager(){
    }

    @Test
    public void testGetUser(){
        UserSystemController usc = new UserSystemController();
        usc.create("testEmployee", "imtheworst", 10000, true, "111");
        String actual = usc.getUser("111");
        assertEquals("Employee {Username = testEmployee, Salary = 10000, Attendance = true, ID = 111}", actual);
    }

    @Test
    public void testGetUserNotExists(){
        UserSystemController usc = new UserSystemController();
        usc.create("testEmployee", "imtheworst", 10000, true, "1");
        String actual = usc.getUser("111");
        assertEquals( "The user id doesn't exist.", actual);
    }

    @Test
    public void verifyValidUser(){
        UserSystemController usc = new UserSystemController();
        usc.create("testEmployee", "imtheworst", 10000, true, "111");
        boolean actual = usc.verify("111");
        assertEquals(true, actual);
    }

    @Test
    public void verifyInvalidUser(){
        UserSystemController usc = new UserSystemController();
        usc.create("testEmployee", "imtheworst", 10000, true, "111");
        boolean actual = usc.verify("0");
        assertEquals(false, actual);
    }
}
