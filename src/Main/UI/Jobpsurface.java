package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.JobpSystemController;


public class Jobpsurface extends JFrame{
    private JLabel userId;
    private JTextField useridInput;
    private JLabel userMajor;
    private JTextField userMajorInput;
    private JPanel panel;
    private JButton JobpButton;
    private JButton btn1;
    final int FRAME_WIDTH = 500;
    final int FRAME_HEIGHT = 500;
    public Jobpsurface(){
        panel = new JPanel();

        userId = new JLabel("Userid:");
        panel.add(userId);
        useridInput = new JTextField(20);
        panel.add(useridInput);

        userMajor = new JLabel("UserMajor:");
        panel.add(userMajor);
        userMajorInput = new JTextField(20);
        panel.add(userMajorInput);

        JobpButton = new JButton("Jobposition");
        panel.add(JobpButton);
        JobpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JobpSystemController jsc = new JobpSystemController();
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
