package UI;

import Controller.*;
import Entity.Employee;
import Entity.Intern;
import Entity.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Class {@code main} handles login, register ,
 * Also, system start at this point and create a new {@code Loginsurface}
 * @author group five-star of CSC207 fall 2021
 * @see Loginsurface
 */
public class main {
    public static void main (String [] args) {

        // This is a test database for UserManager
        ArrayList<User> x = new ArrayList<>();
        Employee bob = new Employee("hello", "123", "0", "test@gmail.com", "CS");
        Employee bobby = new Employee("hi", "456", "1", "test2@gmail.com", "MATH");
        x.add(bob);
        x.add(bobby);
        UserSystemController userManager = new UserSystemController(x);
        userManager.create("pig", "hi", "a", "test2@gmail.com", "MATH");

        //This is a test database for SalaryManagement
        HashMap<String, Integer> y = new HashMap<>();
        y.put("0", 100000);
        y.put("1", 200);
        SalarySystemController salaryManager = new SalarySystemController(y);


        //This is a test database for Schedule
        HashMap<String, Integer> z = new HashMap<>();
        z.put("0", 40);
        z.put("1", 30);
        ScheduleSystemController Schedule = new ScheduleSystemController(z);

        //This is a test database for Jobs
        HashMap<String, String> jobs = new HashMap<>();
        jobs.put("0", "CEO");
        jobs.put("1", "CS");
        JobpSystemController jobPositions = new JobpSystemController(jobs);

        //This is a test database for Intern
        HashMap<Intern, Integer> intern = new HashMap<>();
        Intern aaron = new Intern("hello", "123", "0", "test@gmail.com", "CS");
        Intern aaaaaron = new Intern("hi", "456", "1", "test2@gmail.com", "MATH");
        intern.put(aaron, 60);
        intern.put(aaaaaron, 80);
        InternSystemController internManagement = new InternSystemController(intern);

        /*
         * Make login frame visible
         *
         * @param frame the frame that is currently viewing
         */
        Loginsurface frame = new Loginsurface(userManager);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.setVisible (true);
    }
}
