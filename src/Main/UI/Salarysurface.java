package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Controller.SalarySystemController;
import Entity.User;

public class Salarysurface extends JFrame{
    private JLabel userId1;
    private JTextField useridInput1;
    private JLabel userId2;
    private JTextField useridInput2;
    private JLabel Salary;
    private JTextField SalaryInput;
    private JPanel panel;
    private JButton SalaryButton;
    private  JButton btn1;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;


    public Salarysurface(){
        panel = new JPanel();


        userId1 = new JLabel("Userid1:");
        panel.add(userId1);
        useridInput1 = new JTextField(20);
        panel.add(useridInput1);

        userId2 = new JLabel("Userid2:");
        panel.add(userId2);
        useridInput2 = new JTextField(20);
        panel.add(useridInput2);

        Salary = new JLabel("Salary:");
        panel.add(Salary);
        SalaryInput = new JTextField(20);
        panel.add(SalaryInput);

        SalaryButton = new JButton("Salary");
        panel.add(SalaryButton);

        SalaryButton.addActionListener(new ActionListener() {
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


        btn1 = new JButton("Back");
        panel.add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                new Usersurface().setVisible(true);
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
