package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Userinterface extends JFrame{
    private JPanel panel;
    private JButton salaryButton;
    private JButton jpButton;
    private JButton sdButton;
    private JButton internButton;
    private JButton ExistButton;

    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;

    public Userinterface(){
        panel = new JPanel();

        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Userinterface.this.setVisible(false);
                JFrame salaryinterface = new Salarysurface();
                salaryinterface.setVisible(true);
            }
        });

        jpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Userinterface.this.setVisible(false);
            }
        });
        sdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Userinterface.this.setVisible(false);
            }
        });
        internButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Userinterface.this.setVisible(false);
            }
        });
        ExistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Userinterface.this.setVisible(false);
            }
        });



        this.setLayout (null);
        panel.setSize(500,500);
        panel.setLocation((FRAME_WIDTH-500) / 2, (FRAME_HEIGHT - 500) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }

}
