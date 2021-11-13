package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.JobpSystemController;
import Controller.ScheduleSystemController;
public class schedulesurface extends JFrame{
    private JLabel userId;
    private JTextField useridInput;
    private JLabel Chour;
    private JTextField ChourInput;
    private JPanel panel;
    private JButton scheduleButton;

    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    public schedulesurface(){
        panel = new JPanel();

        userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JPasswordField(20);
        panel.add(useridInput);

        Chour = new JLabel("Changehour:");
        panel.add(Chour);
        ChourInput = new JPasswordField(20);
        panel.add(ChourInput);


        scheduleButton = new JButton("Schedule");
        panel.add(scheduleButton);
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScheduleSystemController ssc = new ScheduleSystemController();
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
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }
}
