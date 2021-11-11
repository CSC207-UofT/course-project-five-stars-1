package UI;
import Controller.SalarySystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Loginsurface extends JFrame {
    private JLabel userLabel;
    private JTextField useridInput;
    private JLabel passwordLabel;
    private JPasswordField passwordInput;
    private JButton rButton;
    private JButton lButton;
    private JPanel panel;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;
    SalarySystemController SalaryManagement;

    public Loginsurface(SalarySystemController SalaryMangement){
        this.SalaryManagement = SalaryManagement;
        panel = new JPanel();
        userLabel = new JLabel("Username:");
        panel.add(userLabel);

        useridInput = new JTextField(30);
        panel.add(useridInput);

        passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(30);
        panel.add(passwordInput);

        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = useridInput.getText();
                String password = passwordInput.getText();
                SalaryMangement.addSalary(id, )
            }
        });

    }
}
