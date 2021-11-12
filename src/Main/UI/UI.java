package UI;

import Controller.UserSystemController;
import Controller.SalarySystemController;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class UI implements ActionListener {
    private JButton b = new JButton("Click here to start the game");
    private JFrame frame;
    private JPanel panel;
    public UI(){
        frame = new JFrame();
        b.addActionListener(this);
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30 ,30 ,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(b);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args){
        new UI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SalarySystemController ssc = new SalarySystemController();
        UserSystemController usc = UserSystemController(); //这里需要找个方法把user system controller里的userList取过来

        Scanner sc = new Scanner(System.in);
        if(e.getSource() == b){
            frame.dispose();
        }

        while (true){
            System.out.println("Choose your option. 1 FOR SALARYSYSTEM, 2 FOR USERSYSTEM, 0 FOR EXIT");
            JOptionPane.showMessageDialog(null, "Choose your option. 1 FOR SALARYSYSTEM," +
                            " 2 FOR USERSYSTEM, 0 FOR EXIT" ,
                    "Option", JOptionPane.PLAIN_MESSAGE);
            int option = sc.nextInt();
            if (option == 1){
                System.out.println("WELCOME, enter your id");
                JOptionPane.showMessageDialog(null, "WELCOME, enter your id",
                        "Enter Input", JOptionPane.QUESTION_MESSAGE);
                sc.nextLine();
                String id = sc.nextLine();
                System.out.println("This is your salary: ");
                JOptionPane.showMessageDialog(null, "This is your salary: "  + ssc.showSalary(id),
                        "Salary", JOptionPane.PLAIN_MESSAGE);
            } else if (option == 2){
                System.out.println("Welcome, enter your option: 1 for adding user, 2 for get user information, 3 for verify the user.");
                JOptionPane.showMessageDialog(null, "Welcome, enter your option:" +
                                " 1 for adding user, 2 for get user information, 3 for verify the user.",
                        "Option", JOptionPane.PLAIN_MESSAGE);
                int pp = sc.nextInt();
                if (pp == 1){
                    System.out.println("Enter your username");
                    JOptionPane.showMessageDialog(null, "Enter your username",
                            "Username", JOptionPane.PLAIN_MESSAGE);
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("Enter your password");
                    JOptionPane.showMessageDialog(null, "Enter your password",
                            "Password", JOptionPane.PLAIN_MESSAGE);
                    String password = sc.nextLine();
                    System.out.println("Enter your salary, it must be integer");
                    JOptionPane.showMessageDialog(null, "Enter your salary, it must be integer",
                            "Salary", JOptionPane.WARNING_MESSAGE);
                    if (sc.hasNextInt()){
                        int salary = sc.nextInt();
                        System.out.println("Enter your attendance, it must be boolean");
                        JOptionPane.showMessageDialog(null, "Enter your attendance," +
                                " it must be boolean", "Attendance", JOptionPane.WARNING_MESSAGE);
                        if(sc.hasNextBoolean()){
                            boolean attendance = sc.nextBoolean();
                            System.out.println("Enter your id");
                            JOptionPane.showMessageDialog(null, "Enter your id"
                                    , "ID", JOptionPane.PLAIN_MESSAGE);
                            sc.nextLine();
                            String id = sc.nextLine();
                            sc.nextLine();
                            String email = sc.nextLine();
                            usc.create(username, password, salary, attendance, id, email);
                            JOptionPane.showMessageDialog(null, "You have added a new user" +
                                            " successfully"
                                    , "ID", JOptionPane.PLAIN_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Restart the UI and be sure to" +
                                            " enter an boolean here,enter a correct boolean",
                                    "warning", JOptionPane.WARNING_MESSAGE);
                            break;
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Restart the UI and be sure to" +
                                        " enter a int here,enter a correct int.",
                                "warning", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                } else if (pp == 2){
                    System.out.println("Enter your id");
                    JOptionPane.showMessageDialog(null, "Enter your id"
                            ,"ID", JOptionPane.PLAIN_MESSAGE);
                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("This is the result");
                    JOptionPane.showMessageDialog(null, "This is the result: " + usc.getUser(id)
                            ,"Result", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(usc.getUser(id));
                } else if (pp == 3){
                    System.out.println("Enter your id");
                    JOptionPane.showMessageDialog(null, "Enter your id"
                            ,"ID", JOptionPane.PLAIN_MESSAGE);
                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("This is your result");
                    JOptionPane.showMessageDialog(null, "This is the result: " + usc.verify(id)
                            ,"Result", JOptionPane.PLAIN_MESSAGE);
                    System.out.println(usc.verify(id));
                }

            } else if (option == 0){
                System.out.println("closed");
                break;
            }
        }
    }
}
