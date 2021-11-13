package UI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.InternSystemController;
import java.util.Random;

import javax.swing.*;

public class Internsurface extends JFrame{
    private JLabel userId;
    private JTextField useridInput;
    private JLabel passwordLabel;
    private JPasswordField passwordInput;
    private JLabel nameLabel;
    private JTextField nameInput;
    private JLabel emailLabel;
    private JTextField emailInput;
    private JLabel majorLabel;
    private JTextField majorInput;
    private JLabel gradeLabel;
    private JTextField gradeInput;
    private JLabel standardLabel;
    private JTextField standardInput;
    private JButton InternButton;
    private JPanel panel;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;
    public Internsurface(){
        panel = new JPanel();
        userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JPasswordField(20);
        panel.add(useridInput);
        passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(20);
        panel.add(passwordInput);

        nameLabel = new JLabel("Username:");
        panel.add(nameLabel);
        nameInput = new JPasswordField(20);
        panel.add(nameInput);

        emailLabel = new JLabel("Email:");
        panel.add(emailLabel);
        emailInput = new JPasswordField(20);
        panel.add(emailInput);

        majorLabel = new JLabel("Major:");
        panel.add(majorLabel);
        majorInput = new JPasswordField(20);
        panel.add(majorInput);

        gradeLabel = new JLabel("Grade:");
        panel.add(gradeLabel);
        gradeInput = new JPasswordField(20);
        panel.add(gradeInput);

        standardLabel = new JLabel("Standard:");
        panel.add(standardLabel);
        standardInput = new JPasswordField(20);
        panel.add(standardInput);

        InternButton = new JButton("Intern");
        panel.add(InternButton);

        InternButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InternSystemController isc = new InternSystemController();
                String id1 = useridInput.getText();
                String username = nameInput.getText();
                String password = passwordInput.getText();
                String email = emailInput.getText();
                String major = majorInput.getText();
                String grade = gradeInput.getText();
                String standard = standardInput.getText();
                Random id = new Random();
                int id2 = id.nextInt(10) + 10;
                String randomId = String.valueOf(id2);
                JOptionPane.showMessageDialog(null, isc.registerInformation(id1, randomId, username,
                        password, email, major, Integer.parseInt(grade)));
                JOptionPane.showMessageDialog(null, isc.updateInformation(id1, Integer.parseInt(standard)));
            }
        });
        this.setLayout (null);
        panel.setSize(635,500);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");
    }
}
