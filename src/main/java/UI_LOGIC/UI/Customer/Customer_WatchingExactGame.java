package UI_LOGIC.UI.Customer;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer_WatchingExactGame {
    Scanner scanner = new Scanner(System.in);

    public String UI_Watching_Exact_Game() {
        System.out.printf("\nPlease Enter name or id of game you are searching or '0' to leave: ");
        String searching = "";
        try {
            searching = scanner.nextLine();
            if ("0".equals(searching)) {
                System.out.printf("\nGoing back...\n");
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return searching;
    }

}
