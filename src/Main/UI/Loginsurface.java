package UI;
import Controller.UserSystemController;

import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Loginsurface extends JFrame {
    private JLabel userLabel;

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

    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    UserSystemController userManager;

    public Loginsurface(UserSystemController userManager){
        this.userManager = userManager;
        panel = new JPanel();
        userLabel = new JLabel("Userid:");
        panel.add(userLabel);

        passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(20);
        panel.add(passwordInput);

        nameLabel = new JLabel("Username: ");
        panel.add(nameLabel);
        nameInput = new JTextField(20);
        panel.add(nameInput);

        emailLabel = new JLabel("Email:");
        panel.add(emailLabel);
        emailInput = new JTextField(20);
        panel.add(emailInput);

        majorLabel = new JLabel("Major:");
        panel.add(majorLabel);
        majorInput = new JTextField(20);
        panel.add(majorInput);

        rButton = new JButton("register");
        panel.add(rButton);

        lButton = new JButton("login");
        panel.add(lButton);

        Random id = new Random();
        int i = id.nextInt(10);
        String randomId = String.valueOf(i);

        rButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordInput.getText();
                String username = nameInput.getText();
                String email = emailInput.getText();
                String major = majorInput.getText();
                userManager.create(randomId, password, username, email, major);
                JOptionPane.showMessageDialog(null, "Your registration is successful and your id is :" + randomId);
            }
        });

        lButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordInput.getText();
                String email = emailInput.getText();
                if(userManager.verify(email, password) == false)
                    JOptionPane.showMessageDialog(null,"Wrong password or email.");
                else{
                    Loginsurface.this.setVisible(false);
                    JFrame userinterface = new Usersurface();
                    userinterface.setVisible(true);
                }

            }
        });



        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User Login interface");

    }
}
