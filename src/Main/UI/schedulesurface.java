package UI;

import javax.swing.*;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

// import Controller.JobpSystemController;
import Controller.ScheduleSystemController;
public class schedulesurface extends JFrame{
    private final JTextField useridInput;
    private final JTextField ChourInput;
    // set window size
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    public schedulesurface(){
        /*
         * @code {panel}
         * Use the panel to create enter fields for the schedulesurface
         * including Userid, changehour
         * creating buttons: schedule and back
         */
        JPanel panel = new JPanel();
        JLabel userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JTextField(20);
        panel.add(useridInput);

        JLabel chour = new JLabel("Changehour:");
        panel.add(chour);
        ChourInput = new JTextField(20);
        panel.add(ChourInput);
        JButton scheduleButton = new JButton("Schedule");
        panel.add(scheduleButton);
        scheduleButton.addActionListener(new ActionListener() {
        /**
         * A helper function for {@code addActionListener}.
         * It searches and checks the {@code User} by userid
         * get inputs of text fields behind "id:", and "changehour:".
         */

            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, Integer> schedules = new HashMap<>();
                ScheduleSystemController ssc = new ScheduleSystemController(schedules);
                String id = useridInput.getText();
                String changeh = ChourInput.getText();
                String add = ssc.addSchedule(id);
                String change = ssc.changeSchedule(id, Integer.parseInt(changeh));
                int schedule = ssc.checkSchedule(id);
                JOptionPane.showMessageDialog(null, add);
                JOptionPane.showMessageDialog(null, change);
                JOptionPane.showMessageDialog(null, "Here is your weekly schedule: " + schedule);
            }
        });

        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click back button
         * And you can go back to the last page you viewed
         */
        JButton btn1 = new JButton("Back");
        panel.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                new Usersurface().setVisible(true);
            }
        });

        /*
         * A helper method for the constructor.
         * Set up the title, size, layout, infoPanel, buttonPanel and visibility of LoginFrame.
         *
         * @see #schedulesurface(main)
         */
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }
}
