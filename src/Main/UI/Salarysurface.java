package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import Controller.SalarySystemController;
public class Salarysurface extends JFrame{
    public void actionPerformed(ActionEvent e){
        SalarySystemController ssc = new SalarySystemController();
        JOptionPane.showMessageDialog(null, "Your salary is " + ssc.showSalary(id));
    }
}
