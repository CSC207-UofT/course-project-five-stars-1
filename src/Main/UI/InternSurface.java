package UI;
import Controller.InternSystemController;
import Entity.Intern;
import java.util.HashMap;
import java.util.Random;
import javax.swing.*;

public class InternSurface extends JFrame{
    private final JTextField useridInput;
    private final JPasswordField passwordInput;
    private final JTextField nameInput;
    private final JTextField emailInput;
    private final JTextField majorInput;
    private final JTextField gradeInput;
    private final JTextField standardInput;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;
    public InternSurface(){
        /*
         * @code {panel}
         * Use the panel to create enter fields for the InternSurface
         * including userid, password, username, email, major. grade. standard
         * creating buttons: intern and back
         */
        JPanel panel = new JPanel();
        JLabel userId = new JLabel("UserID:");
        panel.add(userId);
        useridInput = new JTextField(20);
        panel.add(useridInput);
        JLabel passwordLabel = new JLabel("Password: ");
        panel.add(passwordLabel);

        passwordInput = new JPasswordField(20);
        panel.add(passwordInput);

        JLabel nameLabel = new JLabel("Username:");
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

        JLabel gradeLabel = new JLabel("Grade:");
        panel.add(gradeLabel);
        gradeInput = new JTextField(20);
        panel.add(gradeInput);

        JLabel standardLabel = new JLabel("Standard:");
        panel.add(standardLabel);
        standardInput = new JTextField(20);
        panel.add(standardInput);

        JButton internButton = new JButton("Intern");
        panel.add(internButton);


        /*
         * A helper function for {@code addActionListener}.
         * It searches and checks the {@code Intern} exist or not
         * If the Intern does not exist, it gives the intern a new id.
         */
        internButton.addActionListener(e -> {
            HashMap<Intern, Integer> intern = new HashMap<>();
            InternSystemController isc = new InternSystemController(intern);
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
        });

        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click back button
         * And you can go back to the last page you viewed
         */
        JButton btn1 = new JButton("Back");
        panel.add(btn1);

        btn1.addActionListener(e -> {
            dispose();

            new UserSurface().setVisible(true);
        });
        /*
         * A helper method for the constructor.
         * Set up the title, size, layout, infoPanel, buttonPanel and visibility of LoginFrame.
         *
         * @see #Intersurface(main)
         */
        this.setLayout (null);
        panel.setSize(635,500);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");
    }
}
