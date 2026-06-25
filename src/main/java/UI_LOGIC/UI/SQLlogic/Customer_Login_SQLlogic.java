package UI_LOGIC.UI.SQLlogic;
import UI_LOGIC.UI.stuff.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer_Login_SQLlogic {
    Connection connection;

    Customer_Registration_SQLlogic customerRegistrationSqLlogic;

    public Customer_Login_SQLlogic(Connection connection) {
        this.connection = connection;
        this.customerRegistrationSqLlogic = new Customer_Registration_SQLlogic(connection);
    }



    String sql = "SELECT login, password FROM users WHERE login = ? AND password = ?";

        public String login_logic(customer customer) {
            boolean result = false;
            String password = customerRegistrationSqLlogic.hash_password(customer.password);
            String login = customer.login;
            String role = null;

            try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(2, password);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                role = rs.getString("role");
            }

            }catch (Exception e) {
                e.printStackTrace();
            }
            return role;
        }

}

