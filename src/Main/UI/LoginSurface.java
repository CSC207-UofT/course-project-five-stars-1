package UI;
import Controller.UserSystemController;
import javax.swing.*;
import java.util.Random;
public class LoginSurface extends JFrame {

    private final JPasswordField passwordInput;
    private final JTextField nameInput;
    private final JTextField emailInput;
    private final JTextField majorInput;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    UserSystemController userManager;

    public LoginSurface(UserSystemController userManager){
        /**
         * @code {panel}
         * Use the panel to create enter fields for the LoginSurface
         * including userid, userid, password, username, email, major
         * creating buttons: register, login and back
         */
        this.userManager = userManager;
        JPanel panel = new JPanel();

        JLabel passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(20);
        panel.add(passwordInput);

        JLabel nameLabel = new JLabel("Username: ");
        panel.add(nameLabel);
        nameInput = new JTextField(20);
        panel.add(nameInput);

        JLabel emailLabel = new JLabel("Email:");
        panel.add(emailLabel);
        emailInput = new JTextField(20);
        panel.add(emailInput);

        JLabel majorLabel = new JLabel("Major:");
        panel.add(majorLabel);
        majorInput = new JTextField(20);
        panel.add(majorInput);

        JButton rButton = new JButton("register");
        panel.add(rButton);

        JButton lButton = new JButton("login");
        panel.add(lButton);

        Random id = new Random();
        int i = id.nextInt(10);
        int y = i + 1;
        String randomId = String.valueOf(y);

        /**
         * A helper function for {@code ActionListener} in LoginSurface
         * Check and return whether a user is registered successfully.
         * It restores the data we entered
         * Including password, name, email, major
         * @see actionPerformed(ActionEvent)
         */
        rButton.addActionListener(e -> {
            String password = passwordInput.getText();
            String username = nameInput.getText();
            String email = emailInput.getText();
            String major = majorInput.getText();
            if (userManager.isValidEmail(email) && password.length() > 5 && username.length() > 0){
                userManager.create(randomId, password, username, email, major);
                JOptionPane.showMessageDialog(null, "Your registration is successful and your id is :" + randomId);
            }else{
                JOptionPane.showMessageDialog(null, "Please enter a correct email format, a password of length at least 6, and a username of length at least 1.");
            }
        });

        /**
         * A helper function for {@code ActionListener} in LoginSurface
         * Check and return whether a user is registered successfully.
         *
         * @param email the {@code char[]} whose email is waiting to be checked
         * @param password the {@code char[]} that the password is waiting to be checked
         * @see addActionListener(ActionEvent)
         */
        lButton.addActionListener(e -> {
            String password = passwordInput.getText();
            String email = emailInput.getText();
            if(!userManager.verify(email, password))
                JOptionPane.showMessageDialog(null,"Please enter an exist user");
            else{
                LoginSurface.this.setVisible(false);
                JFrame userinterface = new UserSurface();
                userinterface.setVisible(true);
            }

        });

        /**
         * A helper method for the constructor.
         * Set up the title, size, layout, infoPanel, buttonPanel and visibility of LoginFrame.
         *
         * @see #LoginSurface(main)
         */
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User Login interface");

    }
}
