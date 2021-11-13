package UI;
import javax.swing.*;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Controller.SalarySystemController;
public class Salarysurface extends JFrame{
    private final JTextField useridInput1;
    private final JTextField useridInput2;
    private final JTextField SalaryInput;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    public Salarysurface(){
        JPanel panel = new JPanel();

        JLabel userId1 = new JLabel("Userid1:");
        panel.add(userId1);
        useridInput1 = new JTextField(20);
        panel.add(useridInput1);

        JLabel userId2 = new JLabel("Userid2:");
        panel.add(userId2);
        useridInput2 = new JTextField(20);
        panel.add(useridInput2);

        JLabel salary = new JLabel("Salary:");
        panel.add(salary);
        SalaryInput = new JTextField(20);
        panel.add(SalaryInput);

        JButton salaryButton = new JButton("Salary");
        panel.add(salaryButton);


        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalarySystemController ssc = new SalarySystemController();
                String id1 = useridInput1.getText();
                String id2 = useridInput2.getText();
                String salary = SalaryInput.getText();
                String addSalary = ssc.addSalary(id1, id2, Integer.parseInt(salary));
                JOptionPane.showMessageDialog(null,  addSalary);
                JOptionPane.showMessageDialog(null,  ssc.showSalary(id2));
            }
        });
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");
    }
}
