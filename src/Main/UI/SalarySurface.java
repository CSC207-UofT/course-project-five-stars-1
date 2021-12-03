package UI;
import javax.swing.*;
import java.util.HashMap;

import Controller.SalarySystemController;
public class SalarySurface extends JFrame{
    private final JTextField useridInput1;
    private final JTextField useridInput2;
    private final JTextField SalaryInput;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;

    public SalarySurface(){
        /*
         * @code {panel}
         * Use the panel to create enter fields for the Salary
         * including userid1, userid2
         * creating buttons: salary and back
         */
        JPanel panel = new JPanel();

        JLabel userId1 = new JLabel("UserID1:");
        panel.add(userId1);
        useridInput1 = new JTextField(20);
        panel.add(useridInput1);

        JLabel userId2 = new JLabel("UserID2:");
        panel.add(userId2);
        useridInput2 = new JTextField(20);
        panel.add(useridInput2);

        JLabel salary = new JLabel("Salary:");
        panel.add(salary);
        SalaryInput = new JTextField(20);
        panel.add(SalaryInput);

        JButton salaryButton = new JButton("Set Salary");
        panel.add(salaryButton);

        /*
         * A helper function for {@code addActionListener}.
         * It searches if userid1 (is the employer) has the authority to add salary to userid2 and
         * then if userid1 has the authority to add the salary of userid2, then add it to userid2.
         * It can store the salary we entered.
         */
        salaryButton.addActionListener(e -> {
            HashMap<String, Integer> salaries = new HashMap<>();
            SalarySystemController ssc = new SalarySystemController(salaries);
            String id1 = useridInput1.getText();
            String id2 = useridInput2.getText();
            String salary1 = SalaryInput.getText();
            String addSalary = ssc.addSalary(id1, id2, Integer.parseInt(salary1));
            JOptionPane.showMessageDialog(null,  addSalary);
            JOptionPane.showMessageDialog(null,  ssc.showSalary(id2));
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
         * @see #SalarySurface(main)
         */
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");
    }
}
