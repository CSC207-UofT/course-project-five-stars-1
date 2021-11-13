package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usersurface extends JFrame{
    private JPanel panel;
    private JButton salaryButton;
    private JButton jpButton;
    private JButton sdButton;
    private JButton internButton;
    private JButton ExistButton;

    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;

    public Usersurface(){
        panel = new JPanel();

        salaryButton = new JButton("Salary");
        panel.add(salaryButton);

        jpButton = new JButton("Jobposition");
        panel.add(jpButton);

        sdButton = new JButton("Schedule");
        panel.add(sdButton);

        internButton = new JButton("Intern");
        panel.add(internButton);

        ExistButton = new JButton("Exist");
        panel.add(ExistButton);

        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame salaryinterface = new Salarysurface();
                salaryinterface.setVisible(true);
            }
        });

        jpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame jobpinterface = new Jobpsurface();
                jobpinterface.setVisible(true);
            }
        });
        sdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame scheduleinterface = new schedulesurface();
                scheduleinterface.setVisible(true);
            }
        });
        internButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame internsurface = new Internsurface();
                internsurface.setVisible(true);
            }
        });
        ExistButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
            }
        });



        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }

}
