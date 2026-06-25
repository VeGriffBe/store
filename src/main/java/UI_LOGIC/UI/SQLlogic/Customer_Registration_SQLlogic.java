package UI_LOGIC.UI.SQLlogic;
import UI_LOGIC.UI.stuff.customer;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

public class Customer_Registration_SQLlogic {
    Connection connection;

    public Customer_Registration_SQLlogic(Connection connection) {
        if (connection == null) {
            System.out.println("Ну *банный рот");
        }
        this.connection = connection;
    }

    //Register customer to a system
    public void Register_logic(customer customer) {
            if(checking_login_unique(customer.login)) {
                System.out.printf("\nPlease try another login to create!\n");
                return;
            } else {
                String final_password = hash_password(customer.password);
                String sql = "INSERT INTO users (login, password)"
                        + " VALUES (?,?)";
                try(PreparedStatement statement = connection.prepareStatement(sql)){

                    statement.setString(1, customer.login);
                    statement.setString(2,final_password);

                    statement.executeUpdate();
                    System.out.printf("\n Welcome to PINGUIN STORE %s\nPlease change your information in personnal sittings as you will be free\nEnjoy!\n", customer.login);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }
    //checks if login already exists in database
    public boolean checking_login_unique(String login) {
        boolean result = false;
        String sql = "SELECT login FROM users WHERE login = ?";
        try(PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,login);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    //makes password hashed
    public String hash_password(String password) {
        String salt = BCrypt.gensalt();
        String hashed_password = BCrypt.hashpw(password, salt);
        return hashed_password;
    }

}
