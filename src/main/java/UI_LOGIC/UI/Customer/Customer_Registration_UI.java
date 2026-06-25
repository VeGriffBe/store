package UI_LOGIC.UI.Customer;
import java.sql.*;
import java.util.Scanner;
import UI_LOGIC.UI.stuff.customer;


public class Customer_Registration_UI {

    public customer reg_UI_1STEP() {
        Scanner scanner = new Scanner(System.in);
        customer customer = new customer();
        while (true){
            System.out.printf("\n------------------PINGUIN_STORE------------------");
            System.out.printf("\nPlease enter your login and password to sign up: ");

            String login = scanner.nextLine();
            String password = scanner.nextLine();

            customer.login = login;
            customer.password = password;

            if(customer.login.length() < 5) {
                System.out.printf("\nPlease create login longer than 5 symbols\n");
                continue;
            }
            if(customer.password.matches(".*[^a-zA-Z0-9].*")) {
                System.out.printf("\nPlease create a password without special symbols\n");
                continue;
            }
            return (customer);
        }
    }
}
