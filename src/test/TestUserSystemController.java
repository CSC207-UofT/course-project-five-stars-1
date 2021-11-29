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
    public static void setUpUserSystemController() {usc = new UserSystemController(new ArrayList<User>());}

    @Test
    public void testCreateEmployer(){
        usc = new UserSystemController(new ArrayList<User>());
        ArrayList<User> expected = new ArrayList<>();
        Employer employer = new Employer("testEmployer",
                "imthebest", "0", "kt@gmail.com", "computer science");
        expected.add(employer);
        usc.getUserManager().createEmployer("testEmployer",
                "imthebest", "0", "kt@gmail.com", "computer science");
        usc.create("testEmployer",
                "imthebest", "0", "kt@gmail.com", "computer science");
        assertEquals(expected.get(0).getUsername(), usc.getUserManager().getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), usc.getUserManager().getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getSalary(), usc.getUserManager().getUm().get(0).getSalary());
        assertEquals(expected.get(0).getEmail(), usc.getUserManager().getUm().get(0).getEmail());
    }

    @Test
    public void testCreateEmployee(){
        usc = new UserSystemController(new ArrayList<User>());
        ArrayList<User> expected = new ArrayList<>();
        Employee employee = new Employee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        expected.add(employee);
        usc.getUserManager().createEmployee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        assertEquals(expected.get(0).getUsername(), usc.getUserManager().getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), usc.getUserManager().getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getPassword(), usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.get(0).getSalary(), usc.getUserManager().getUm().get(0).getSalary());
    }

    @Test
    public void testGetUser(){
        UserSystemController usc = new UserSystemController(new ArrayList<User>());
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        String actual = usc.getUser("111");
        assertEquals("Employee {Username = testEmployee, Salary = 0, Attendance = false, " +
                "ID = 111, Email = gb@gmail.com, Major = computer science}", actual);
    }

    @Test
    public void testGetUserNotExists(){
        UserSystemController usc = new UserSystemController(new ArrayList<User>());
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        String actual = usc.getUser("11");
        assertEquals( "The user id doesn't exist.", actual);
    }

    @Test
    public void verifyValidUser(){
        UserSystemController usc = new UserSystemController(new ArrayList<User>());
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        boolean actual = usc.verify("gb@gmail.com", "imtheworst");
        assertEquals(true, actual);
    }

    @Test
    public void verifyInvalidUser(){
        UserSystemController usc = new UserSystemController(new ArrayList<User>());
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        boolean actual = usc.verify("hoo@gmail.com", "imtheworst");
        assertEquals(false, actual);
    }

    @Test
    public void testFireUExist(){
        usc = new UserSystemController(new ArrayList<User>());
        UserSystemController expected = new UserSystemController(new ArrayList<User>());
        expected.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        expected.create("testEmployee",
                "imtheworst", "121", "gb@gmail.com", "computer science");
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        usc.create("testEmployee",
                "imtheworst", "121", "gb@gmail.com", "computer science");
        assertEquals(expected.getUserManager().getUm().get(0).getUsername(),
                usc.getUserManager().getUm().get(0).getUsername());
        assertEquals(expected.getUserManager().getUm().get(0).getID(),
                usc.getUserManager().getUm().get(0).getID());
        assertEquals(expected.getUserManager().getUm().get(0).getPassword(),
                usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.getUserManager().getUm().get(0).getPassword(),
                usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.getUserManager().getUm().get(0).getSalary(),
                usc.getUserManager().getUm().get(0).getSalary());
    }

    @Test
    public void testFireNotExist(){

        usc = new UserSystemController(new ArrayList<User>());
        UserSystemController expected = new UserSystemController(new ArrayList<User>());
        expected.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        usc.create("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        String expected_string = "";
        assertEquals(expected_string, output.toString().trim());
        assertEquals(expected.getUserManager().getUm().get(0).getUsername(),
                usc.getUserManager().getUm().get(0).getUsername());
        assertEquals(expected.getUserManager().getUm().get(0).getID(),
                usc.getUserManager().getUm().get(0).getID());
        assertEquals(expected.getUserManager().getUm().get(0).getPassword(),
                usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.getUserManager().getUm().get(0).getPassword(),
                usc.getUserManager().getUm().get(0).getPassword());
        assertEquals(expected.getUserManager().getUm().get(0).getSalary(),
                usc.getUserManager().getUm().get(0).getSalary());


    }
}
