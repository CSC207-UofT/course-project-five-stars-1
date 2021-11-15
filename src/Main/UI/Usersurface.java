package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usersurface extends JFrame{

    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;

    public Usersurface(){
        /*
         * @code {panel}
         * Use the panel to create buttons for the Usersurface
         * creating buttons: salary, Jobposition, Schedule, Intern, Exist
         */
        JPanel panel = new JPanel();

        JButton salaryButton = new JButton("Salary");
        panel.add(salaryButton);

        JButton jpButton = new JButton("Jobposition");
        panel.add(jpButton);

        JButton sdButton = new JButton("Schedule");
        panel.add(sdButton);

        JButton internButton = new JButton("Intern");
        panel.add(internButton);

        JButton existButton = new JButton("Exist");
        panel.add(existButton);

        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click Salary button
         * And you can go to Salarysurface
         */
        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame salaryinterface = new Salarysurface();
                salaryinterface.setVisible(true);
            }
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click Jobposition button
         * And you can go back to Jobsurface
         */
        jpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame jobpinterface = new Jobpsurface();
                jobpinterface.setVisible(true);
            }
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click Schedule button
         * And you can go back to schedulesurface
         */
        sdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame scheduleinterface = new schedulesurface();
                scheduleinterface.setVisible(true);
            }
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click intern button
         * And you can go back to Internsurface
         */
        internButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
                JFrame internsurface = new Internsurface();
                internsurface.setVisible(true);
            }
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click exit button
         * And you can exit the window
         */
        existButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usersurface.this.setVisible(false);
            }
        });


        /*
         * A helper method for the constructor.
         * Set up the title, size, layout, infoPanel, buttonPanel and visibility of LoginFrame.
         *
         * @see #Usersurface(main)
         */
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }

}
