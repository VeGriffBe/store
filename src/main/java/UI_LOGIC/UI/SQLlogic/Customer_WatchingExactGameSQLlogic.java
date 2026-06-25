package UI_LOGIC.UI.SQLlogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer_WatchingExactGameSQLlogic {
    Connection connection;

    public Customer_WatchingExactGameSQLlogic(Connection connection) {
        this.connection = connection;
    }
    String sql;



        public void Logic_Watching_Exact_Game(String id_name) {

            if(id_name == null ) {
                return;
            }

            if (id_name.matches("\\d+")) {
                search_By_Name(id_name);
        } else {
                search_By_Name(id_name);
            }
        leave();
    }





        public void Search_By_ID(String id) {
            ArrayList<String> genres = new ArrayList<>();
            genres.clear();
            String description = "";
            String title = "";
            float price = 0;



                sql = "SELECT title, name, description, price FROM game_genre"
                        + " INNER JOIN games ON games.id = game_genre.games_id"
                        + " INNER JOIN genres ON genres.id = game_genre.genres_id"
                        + " WHERE game_genre.games_id = ?";
                try(PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1,Integer.parseInt(id));
                    ResultSet rs = statement.executeQuery();

                    while (rs.next()){
                        title = rs.getString("title");
                        genres.add(rs.getString("name"));
                        description = rs.getString("description");
                        price = rs.getFloat("price");
                    }
                    if (!title.isEmpty()) {
                        System.out.printf("Name: %s" + "\nGenres: ", title);
                        for (int b = 0; b < genres.size(); b++) {
                            System.out.printf(genres.get(b) + ",");
                        }
                        System.out.printf("\nDescription: %s" + "\nPrice: %.0f$", description, price);
                    } else {
                        System.out.printf("\nGame is not found!\n");
                    }
                    genres.clear();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }



        public void search_By_Name(String name) {
            ArrayList<String> genres = new ArrayList<>();
            String description = "";
            String title = "";
            float price = 0;
                sql = "SELECT title, name, description, price FROM game_genre"
                        + " INNER JOIN games ON games.id = game_genre.games_id"
                        + " INNER JOIN genres ON genres.id = game_genre.genres_id"
                        + " WHERE games.title = ?";
                try(PreparedStatement statement = connection.prepareStatement(sql)){

                    statement.setString(1, name);
                    ResultSet rs = statement.executeQuery();

                    while(rs.next()) {
                        title = rs.getString("title");
                        genres.add(rs.getString("name"));
                        description = rs.getString("description");
                        price = rs.getFloat("price");
                    }

                    if(!title.isEmpty()) {
                        System.out.printf("Name: %s" + "\nGenres: ", title);
                        for (int b = 0; b < genres.size(); b++) {
                            System.out.printf(genres.get(b) + ",");
                        }
                        System.out.printf("\nDescription: %s" + "\nPrice: %.0f$", description, price);
                    } else {
                        System.out.printf("\nGame is not found!\n");
                    }
                    genres.clear();

                }catch (Exception e) {
                    e.printStackTrace();

            }
        }

        public void leave() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.printf("\nPlease enter 0 to leave: ");
                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice == 0) {
                        return;
                    } else {
                        System.out.printf("\nPlease pick up 0 to leave");
                    }
                } catch (Exception e) {
                    System.out.printf("\nPlease pick up a number to leave");
                    scanner.nextLine();
                }
            }
        }
}
