package UI_LOGIC.UI.Customer;

import UI_LOGIC.UI.stuff.customer;

import java.sql.Connection;
import java.util.Scanner;

public class Customer_Login_UI {

    Scanner scanner = new Scanner(System.in);
    customer customer = new customer();

    public customer login() {
        System.out.printf("\n------------------PINGUIN_STORE------------------");
        System.out.printf("\nPlease enter your login and password to enter into your account: ");

        while(true) {
            String login = scanner.nextLine();
            String password = scanner.nextLine();

            customer.login = login;
            customer.password = password;

            // put these checks to SQLlogic
            if(customer.login.length() < 5) {
                System.out.printf("\nPlease write login longer than 5 symbols\n");
                continue;
            }
            if(customer.password.matches(".*[^a-zA-Z0-9].*")) {
                System.out.printf("\nPlease write a password without special symbols\n");
                continue;
            }
            return (customer);
        }
    }
}
