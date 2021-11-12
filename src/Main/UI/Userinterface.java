package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Userinterface extends JFrame{
    private JLabel selectionLabel;
    private JTextField selectionInput;
    private JPanel panel;
    private JButton salaryButton;
    private JButton jpButton;
    private JButton sdButton;
    private JButton internButton;

    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;

    public Userinterface(){
        panel = new JPanel();
        selectionLabel = new JLabel("Userid:");
        panel.add(selectionLabel);

        selectionInput = new JTextField(30);
        panel.add(selectionInput);


        salaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = selectionInput.getText();
                if (Objects.equals(input, "1")){
                    Userinterface.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter an exist selection or come to ");
                }

            }
        });

        jpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = selectionInput.getText();
                if (Objects.equals(input, "2")){
                    Userinterface.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter an exist selection or come to ");
                }

            }
        });
        sdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = selectionInput.getText();
                if (Objects.equals(input, "3")){
                    Userinterface.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter an exist selection or come to ");
                }

            }
        });
        internButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = selectionInput.getText();
                if (Objects.equals(input, "4")){
                    Userinterface.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter an exist selection or come to ");
                }

            }
        });


        this.setLayout (null);
        panel.setSize(500,500);
        panel.setLocation((FRAME_WIDTH-500) / 2, (FRAME_HEIGHT - 500) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }

}
