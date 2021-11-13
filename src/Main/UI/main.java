package UI;

import Controller.UserSystemController;
import Entity.User;

import javax.swing.*;
import java.util.ArrayList;

public class main {
    public static void main (String [] args) {
        ArrayList<User> x = new ArrayList<>();
        UserSystemController userManager = new UserSystemController(x);
        userManager.create("hello", "123", "0", "test@gmail.com", "CS");
        userManager.create("hi", "456", "1", "test2@gmail.com", "MATH");
        Loginsurface frame = new Loginsurface(userManager);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.setVisible (true);
    }
}
