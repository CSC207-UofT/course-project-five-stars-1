package UI;

import Controller.UserSystemController;

import javax.swing.*;

public class main {
    public static void main (String [] args) {

        UserSystemController userManager = new UserSystemController();
        Loginsurface frame = new Loginsurface(userManager);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);



        frame.setVisible (true);
    }
}
