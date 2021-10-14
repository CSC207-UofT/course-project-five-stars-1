package UI;

import Controller.UserSystemController;
import Controller.SalarySystemController;


import java.util.Scanner;

public class UI {

    public static void main(String[] args){
        SalarySystemController ssc = new SalarySystemController();
        UserSystemController usc = new UserSystemController();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Choose your option. 1 FOR SALARYSYSTEM, 2 FOR USERSYSTEM, 0 FOR EXIT");
            int option = sc.nextInt();
            if (option == 1){
                System.out.println("WELCOME, enter your id");
                sc.nextLine();
                String id = sc.nextLine();
                System.out.println("This is your salary");
                ssc.showSalary(id);
            } else if (option == 2){
                System.out.println("Welcome, enter your option: 1 for adding user, 2 for get user information, 3 for verify the user.");
                int pp = sc.nextInt();
                if (pp == 1){
                    System.out.println("Enter your username");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("Enter your password");
                    String password = sc.nextLine();
                    System.out.println("Enter your salary, it must be integer");
                    int salary = sc.nextInt();
                    System.out.println("Enter your attendance, it must be boolean");
                    boolean attendance = sc.nextBoolean();
                    System.out.println("Enter your id");
                    sc.nextLine();
                    String id = sc.nextLine();
                    usc.create(username, password, salary, attendance, id);
                } else if (pp == 2){
                    System.out.println("Enter your id");
                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("This is the result");
                    System.out.println(usc.getUser(id));
                } else if (pp == 3){
                    System.out.println("Enter your id");
                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("This is your result");
                    System.out.println(usc.verify(id));
                }

            } else if (option == 0){
                System.out.println("closed");
                break;
            }
        }
    }
}
