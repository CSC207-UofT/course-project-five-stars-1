package UI;

import Controller.SalarySystemController;
import Controller.ScheduleSystemController;
import Controller.UserSystemController;
import Entity.Employee;
import Entity.User;
import UseCase.UserManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main (String [] args) {

        // test database for UserManager
        ArrayList<User> x = new ArrayList<>();
        Employee bob = new Employee("hello", "123", "0", "test@gmail.com", "CS");
        Employee bobby = new Employee("hi", "456", "1", "test2@gmail.com", "MATH");
        x.add(bob);
        x.add(bobby);
        UserSystemController userManager = new UserSystemController(x);
        userManager.create("pig", "hi", "a", "test2@gmail.com", "MATH");

        //test database for SalaryManagement
        HashMap<String, Integer> y = new HashMap<>();
        y.put("0", 100000);
        y.put("1", 200);
        SalarySystemController salaryManager = new SalarySystemController(y);


        //test database
        HashMap<String, Integer> z = new HashMap<>();
        z.put("0", 40);
        z.put("1", 30);
        ScheduleSystemController Schedule = new ScheduleSystemController(z);

        Loginsurface frame = new Loginsurface(userManager);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.setVisible (true);
    }
}
