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
        ArrayList userList = new ArrayList<User>();
        um = new UserManager(userList);
    }

    @Test
    public void testCreateEmployer(){
        ArrayList userList = new ArrayList<User>();
        um = new UserManager(userList);
        ArrayList<User> expected = new ArrayList<>();
        Employer employer = new Employer("testEmployer",
                "imthebest", "0", "kt@gmail.com", "computer science");
        expected.add(employer);
        um.createEmployer("testEmployer",
                "imthebest","0", "kt@gmail.com", "computer science");

        assertEquals(expected.get(0).getUsername(), um.getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), um.getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), um.getUm().get(0).getPassword());
        assertEquals(expected.get(0).getMajor(), um.getUm().get(0).getMajor());
        assertEquals(expected.get(0).getEmail(), um.getUm().get(0).getEmail());
    }

    @Test
    public void testCreateEmployee(){
        ArrayList<User> expected = new ArrayList<>();
        Employee employee = new Employee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        expected.add(employee);
        um.createEmployee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        assertEquals(expected.get(0).getUsername(), um.getUm().get(0).getUsername());
        assertEquals(expected.get(0).getID(), um.getUm().get(0).getID());
        assertEquals(expected.get(0).getPassword(), um.getUm().get(0).getPassword());
        assertEquals(expected.get(0).getMajor(), um.getUm().get(0).getMajor());
        assertEquals(expected.get(0).getEmail(), um.getUm().get(0).getEmail());
    }

    @Test
    public void testVerifyUser(){
        um.createEmployee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        boolean expected = um.verifyUser("123@gmail.com", "imtheworst");
        assertEquals(expected, false);
        boolean expected2 = um.verifyUser("gb@gmail.com", "imtheworst");
        assertEquals(expected2, true);
    }

    @Test
    public void testGetUserFromID(){
        um.createEmployee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        String expected = um.getUserFromId("111");
        String actual = "Employee {Username = testEmployee, Salary = 0, Attendance = false, " +
                "ID = 111, Email = gb@gmail.com, Major = computer science}";
        assertEquals(expected, actual);
    }


}