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
    private JPanel panel;
    private JButton scheduleButton;
    public schedulesurface(){
        panel = new JPanel();
        userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JPasswordField(30);
        panel.add(useridInput);
        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScheduleSystemController ssc = new ScheduleSystemController();
                String id = useridInput.getText();
                int schedule = ssc.checkSchedule(id);
                JOptionPane.showMessageDialog(null, "Here is your weekly schedule: " + schedule );
            }
        });
    }
}
