package UI;

import Controller.UserSystemController;
import Controller.SalarySystemController;


import java.util.Scanner;

public class ui {

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
                System.out.println("Welcome, enter your option");
                int pp = sc.nextInt();
                if (pp == 1){
                    System.out.println("Enter your username");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("Enter your password");
                    sc.nextLine();
                    String password = sc.nextLine();
                    System.out.println("Enter your salary");
                    int salary = sc.nextInt();
                    System.out.println("Enter your attandance");
                    boolean attandance = sc.nextBoolean();
                    System.out.println("Enter your id");
                    sc.nextLine();
                    String id = sc.nextLine();
                    usc.create(username, password, salary, attandance, id);
                } else if (pp == 2){
                    System.out.println("Enter your id");
                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("This is the result");
                    usc.getUser(id);
                } else if (pp == 3){
                    System.out.println("Enter your username");
                    sc.nextLine();
                    String username = sc.nextLine();
                    System.out.println("This is your result");
                    usc.verify(username);
                }

            } else if (option == 0){
                System.out.println("closed");
                break;
            }
        }
    }
}
