package UI;
import javax.swing.*;

public class UserSurface extends JFrame{

    final int FRAME_WIDTH = 1000;
    final int FRAME_HEIGHT = 1000;

    public UserSurface(){
        /*
         * @code {panel}
         * Use the panel to create buttons for the UserSurface
         * creating buttons: salary, JobPositions, Schedule, Intern, Exist
         */
        JPanel panel = new JPanel();

        JButton salaryButton = new JButton("Salary");
        panel.add(salaryButton);

        JButton jpButton = new JButton("JobPositions");
        panel.add(jpButton);

        JButton sdButton = new JButton("Schedule");
        panel.add(sdButton);

        JButton internButton = new JButton("Intern");
        panel.add(internButton);

        JButton existButton = new JButton("Exist");
        panel.add(existButton);

        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click Salary button
         * And you can go to SalarySurface
         */
        salaryButton.addActionListener(e -> {
            UserSurface.this.setVisible(false);
            JFrame salaryinterface = new SalarySurface();
            salaryinterface.setVisible(true);
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click JobPositions button
         * And you can go back to Jobsurface
         */
        jpButton.addActionListener(e -> {
            UserSurface.this.setVisible(false);
            JFrame jobpinterface = new JobSurface();
            jobpinterface.setVisible(true);
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click Schedule button
         * And you can go back to ScheduleSurface
         */
        sdButton.addActionListener(e -> {
            UserSurface.this.setVisible(false);
            JFrame scheduleinterface = new ScheduleSurface();
            scheduleinterface.setVisible(true);
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click intern button
         * And you can go back to InternSurface
         */
        internButton.addActionListener(e -> {
            UserSurface.this.setVisible(false);
            JFrame internsurface = new InternSurface();
            internsurface.setVisible(true);
        });
        /*
         * A helper function for {@code addActionListener}.
         * It is activated when you click exit button
         * And you can exit the window
         */
        existButton.addActionListener(e -> UserSurface.this.setVisible(false));


        /*
         * A helper method for the constructor.
         * Set up the title, size, layout, infoPanel, buttonPanel and visibility of LoginFrame.
         *
         * @see #UserSurface(main)
         */
        this.setLayout (null);
        panel.setSize(250,250);
        panel.setLocation((FRAME_WIDTH-250) / 2, (FRAME_HEIGHT - 250) / 2);
        this.add (panel);
        this.setSize (FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle ("User interface");

    }

}
