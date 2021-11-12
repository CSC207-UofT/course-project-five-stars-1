package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.JobpSystemController;


public class Jobpsurface extends JFrame{
    private JLabel userId;
    private JTextField useridInput;
    private JPanel panel;
    private JButton JobpButton;
    public Jobpsurface(){
        panel = new JPanel();
        userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JPasswordField(30);
        panel.add(useridInput);
        JobpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JobpSystemController jsc = new JobpSystemController();
                String id = useridInput.getText();
                String major = jsc.getMajor(id);
                JOptionPane.showMessageDialog(null, "Here is the reference job: " + major );
            }
        });
    }
}
