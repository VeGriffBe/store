package UI_LOGIC.UI.SQLlogic;
import UI_LOGIC.UI.Customer.Customer_Login_UI;
import UI_LOGIC.UI.Customer.Customer_Registration_UI;
import UI_LOGIC.UI.Customer.Enter_UI_Customer;
import UI_LOGIC.UI.Openning_UI;
import UI_LOGIC.UI.stuff.customer;

import java.sql.*;
import java.util.Scanner;

public class Entrance_Logic {
    String url = "jdbc:sqlite:database.db";

    Connection connection;

    Customer_Login_SQLlogic customerLoginSqLlogic;
    Customer_Login_UI customerLoginUi;
    Openning_UI openningUi;
    Customer_Registration_SQLlogic customerRegistrationSqLlogic;
    Customer_Registration_UI customerRegistrationUi;

    public Entrance_Logic(Connection connection) {
        this.connection = connection;
        this.customerLoginUi = new Customer_Login_UI();
        this.customerLoginSqLlogic = new Customer_Login_SQLlogic(connection);
        this.openningUi = new Openning_UI();
        this.customerRegistrationSqLlogic = new Customer_Registration_SQLlogic(connection);
        this.customerRegistrationUi = new Customer_Registration_UI();
    }

    Scanner scanner = new Scanner(System.in);

    //whole logic of entrance goes here
    public void entrance() {
        String choice = openningUi.login();

       if(choice.toLowerCase().equals("enter")) {

           String cor_incor = customerLoginSqLlogic.login_logic(customerLoginUi.login());



           if (cor_incor.equals("Customer")) {
               Enter_UI_Customer.after_enterUI();
           } else if (cor_incor == "Seller") {

           } else if (cor_incor == "Admin") {

           }

       }
       else if (choice.toLowerCase().equals("register")) {
           customer customer = new customer();
            customer = customerRegistrationUi.reg_UI_1STEP();
           customerRegistrationSqLlogic.Register_logic(customer);
           System.out.printf("\nThank you for registration here. You will be directed into login system!\nPlease open app again and login inside!\n");
       }
       else if (choice.toLowerCase().equals("leave")) {
           return;
       }
       else {
           System.out.printf("\nPlease write down correct answer!\n");
           choice = openningUi.login();
       }


    }
}
