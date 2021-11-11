package UI;
import Controller.UserSystemController;

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
    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel emailLabel;
    private JTextField emailInput;
    private JLabel majorLabel;
    private JTextField majorInput;
    private JPanel panel;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;
    UserSystemController userManager;

    public Loginsurface(UserSystemController userManager){
        this.userManager = userManager;
        panel = new JPanel();
        userLabel = new JLabel("Userid:");
        panel.add(userLabel);

        useridInput = new JTextField(30);
        panel.add(useridInput);

        passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(30);
        panel.add(passwordInput);

        nameLabel = new JLabel("Username:");
        panel.add(nameLabel);

        emailLabel = new JLabel("Email:");
        panel.add(emailLabel);

        majorLabel = new JLabel("Major:");
        panel.add(majorLabel);

        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = useridInput.getText();
                String password = passwordInput.getText();
                String username = nameInput.getText();
                String email = emailInput.getText();
                String major = majorInput.getText();
                userManager.create(id, password, username, email, major);
                JOptionPane.showMessageDialog(null, "Your registration is successful");
            }
        });

        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = useridInput.getText();
                String password = passwordInput.getText();
                String username = nameInput.getText();
                String email = emailInput.getText();
                String major = majorInput.getText();

            }
        });

    }
}
