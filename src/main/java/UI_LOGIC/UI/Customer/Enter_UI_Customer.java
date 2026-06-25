package UI_LOGIC.UI.Customer;

import UI_LOGIC.UI.SQLlogic.Entrance_Logic;

import java.sql.Connection;
import java.util.Scanner;

public class Enter_UI_Customer {

    private Entrance_Logic entranceLogic;
    Scanner scanner = new Scanner(System.in);

    Connection connection;

    public Enter_UI_Customer(Connection connection) {
        this.connection = connection;
    }

    public static void after_enterUI() {
        while (true) {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.printf("\nWelcome into PINGUIN STORE. \nPlease enter what kind of products you are interested in:");
                System.out.printf("\n1)Games\n2)Meal\n3)Subscriptions");
                int choice = scanner1.nextInt();

            } catch (Exception e) {
                System.out.printf("\nPlease pick up a normal number");
            }
        }
    }
}
