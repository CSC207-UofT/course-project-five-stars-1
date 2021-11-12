package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import Controller.SalarySystemController;
public class Salarysurface extends JFrame{
    private JLabel userId;
    private JTextField useridInput;
    private JPanel panel;
    private JButton SalaryButton;
    public Salarysurface(){
        panel = new JPanel();
        userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JPasswordField();
        panel.add(useridInput);
        SalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalarySystemController ssc = new SalarySystemController();
                String id = useridInput.getText();
                JOptionPane.showMessageDialog(null,  ssc.showSalary(id));
            }
        });
    }
}
