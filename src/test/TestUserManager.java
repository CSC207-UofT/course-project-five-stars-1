import UseCase.UserManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import Entity.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        um.createEmployee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        boolean expected = um.verifyUser("123@gmail.com", "imtheworst");
        assertEquals(expected, false);
        boolean expected2 = um.verifyUser("gb@gmail.com", "imtheworst");
        assertEquals(expected2, true);
        String expected_string = "User list saved!\n" +
                "[Employee {Username = testEmployee, Salary = 0, Attendance = false, ID = 111, Email = gb@gmail.com, " +
                "Major = computer science}]\n" +
                "User file read successfully!";
        assertEquals(expected_string.trim(), output.toString().trim());
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

    @Test
    public void testFire(){
        ArrayList userList = new ArrayList<User>();
        um = new UserManager(userList);
        um.createEmployee("testEmployee",
                "imtheworst", "111", "gb@gmail.com", "computer science");
        boolean actual = um.fire("111");
        assertEquals(true, actual);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        um.createEmployee("testEmployee",
                "imtheworst", "121", "gb@gmail.com", "computer science");
        um.fire("121");
        String expected_string = "User list saved!\n" +
                "[Employee {Username = testEmployee, Salary = 0, Attendance = false, ID = 121, Email = gb@gmail.com, " +
                "Major = computer science}]\n" +
                "User file read successfully!\n" +
                "Successful! This employee has been removed";
        assertEquals(expected_string.trim(), output.toString().trim());

    }


}