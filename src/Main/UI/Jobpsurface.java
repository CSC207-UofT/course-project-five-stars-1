package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import Controller.JobpSystemController;


public class Jobpsurface extends JFrame{
    private final JTextField useridInput;
    private final JTextField userMajorInput;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    private JButton btn1;
    public Jobpsurface(){
        /**
         * @code {panel}
         * Use the panel to create enter fields for the Jobposition
         * including userid, usermajor
         * creating buttons: jobposition and back
         */
        JPanel panel = new JPanel();

        JLabel userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JTextField(20);
        panel.add(useridInput);

        JLabel userMajor = new JLabel("UserMajor:");
        panel.add(userMajor);
        userMajorInput = new JTextField(20);
        panel.add(userMajorInput);

        JButton jobpButton = new JButton("Jobposition");
        panel.add(jobpButton);

        /**
         * A helper function for {@code addActionListener}.
         * It takes one user and major and match them together.
         * The system will suggest a position for this User or Intern you entered.
         */
        jobpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> jobs = new HashMap<>();
                JobpSystemController jsc = new JobpSystemController(jobs);
                String id = useridInput.getText();
                String inputMajor = userMajorInput.getText();
                String addMajor = jsc.addMajor(id, inputMajor);
                String getMajor = jsc.getMajor(id);
                String reference = jsc.getReference(getMajor);
                JOptionPane.showMessageDialog(null, "This is your added major," +
                        " remember to add the major that matches the previous one:" + addMajor );
                JOptionPane.showMessageDialog(null, "Here is the reference job: " + reference);
            }
        });
        /**
         * A helper function for {@code addActionListener}.
         * It is activated when you click back button
         * And you can go back to the last page you viewed
         */
        btn1 = new JButton("Back");
        panel.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                new Usersurface().setVisible(true);
            }
        });
        /**
         * A helper method for the constructor.
         * Set up the title, size, layout, infoPanel, buttonPanel and visibility of LoginFrame.
         *
         * @see #Jobsurface(main)
         */
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }
}
