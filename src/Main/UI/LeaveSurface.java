package UI;

import javax.swing.*;

public class LeaveSurface extends JFrame {
    private final JTextField leavedaysInput;
    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;
    private final JButton btn1;

    public LeaveSurface() {
        /*
         * @code {panel}
         * Use the panel to create enter fields for the LeaveSurface
         * including number_days
         * creating buttons: calculate_leave
         */
        JPanel panel = new JPanel();
        JLabel number_days = new JLabel("Number of days requested:");
        panel.add(number_days);
        leavedaysInput = new JTextField(20);
        panel.add(leavedaysInput);

        JButton calculate_leaveButton = new JButton("Compute leave days available");
        panel.add(calculate_leaveButton);

        btn1 = new JButton("Back");
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