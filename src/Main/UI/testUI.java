package View;

public class UI {
}
import Controller.UserSystemController;
import Controller.UserSystemFacde;
import UserCases.UserManager;

import java.util.Scanner;


public class textUI{
    public static viod main(String[] args){
        UserSystemFacde facade = new UserSystemFacde();

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("XXXXXXXXXX");
            int option = in.nextInt();
            if (option == 1){
                System.out.println("XXXXXXXXXX");
                in.nextLine();
                String username = in.nextLine();
                System.out.println("XXXXX");
                facade.register(user, pw);
            }
            else if (opton == 2){
                System.out.println("XXXXXXXXXX");
                in.nextLine();
                String username = in.nextLine();
                System.out.println("XXXXX");
                String pw = in.nexxtLine();
                if (facade.register(user, pw)){
                    System.out.println("XXX");
                }
                else
                    System.out.println("XXXX");
            }
            else if (option == 0){
                facade.exit();
                break;
            }
        }
    }
}