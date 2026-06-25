package UI_LOGIC.UI;

import UI_LOGIC.UI.Customer.Customer_Login_UI;
import UI_LOGIC.UI.Customer.Customer_Registration_UI;
import UI_LOGIC.UI.SQLlogic.Customer_Login_SQLlogic;
import UI_LOGIC.UI.SQLlogic.Customer_Registration_SQLlogic;

import java.sql.Connection;
import java.util.Scanner;


public class Openning_UI {
    Scanner scanner = new Scanner(System.in);

    //Prints
    public String login() {
        System.out.printf("\n------------------PINGUIN_STORE------------------");
        System.out.printf("\nPlease write 'enter' to enter to your account or\n 'register' to register!\nPlease enter 'leave' to leave\n");

        String choice = "";

        choice = scanner.nextLine();

        return choice;



        }
    }

