package UI;

import Controller.UserSystemController;
import Controller.SalarySystemController;
import UseCase.SalaryManagement;

import java.util.Scanner;

public class ui {

    public static void main(String[] args){
        SalarySystemController ssc = new SalarySystemController();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Choose your option");
            int option = sc.nextInt();
            if (option == 1){
                System.out.println("ABCDEFG");
                sc.nextLine();
                String id = sc.nextLine();
                System.out.println("This is your salary");
                ssc.showSalary(id);
            } else {
                System.out.println("closed");
            }
        }
    }
}
