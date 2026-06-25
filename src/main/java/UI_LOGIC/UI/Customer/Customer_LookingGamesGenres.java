package UI_LOGIC.UI.Customer;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer_LookingGamesGenres {
    
    Connection connection;
    ArrayList<String> genre_list = new ArrayList<>();

    public Customer_LookingGamesGenres(Connection connection) {
        this.connection = connection;
    }
    // shows ho much games u have in genres
        public void Amount_Of_Games_In_Genre() {
            genre_list.clear();
            while(true) {

                ArrayList<Float> amountGames_INgenre = new ArrayList<>();
                String create_list = "SELECT name, COUNT(*) AS total FROM game_genre"
                                      + " INNER JOIN genres ON genres.id = game_genre.genres_id"
                                      + " GROUP BY name";
                try(Statement statement = connection.createStatement()) {

                    ResultSet rs = statement.executeQuery(create_list);

                    while(rs.next()){
                        genre_list.add(rs.getString("name"));
                        amountGames_INgenre.add(rs.getFloat("total"));
                    }

                    for (int i = 0; i < genre_list.size(); i++) {
                     String current_game = genre_list.get(i);
                     Float current_price = amountGames_INgenre.get(i);

                        System.out.printf("%d)%s: $.0f\n", (i + 1), current_game, current_price);
                    }


                    break;

                } catch (SQLException e) {
                    System.out.printf("\nPlease try later");
                    e.printStackTrace();
                    return;
                }

            }
        }

        public int UI_For_Chosing_Genre() {
            System.out.printf("\nPlease choose number of genre to search games recording to it: ");
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();
            index = index - 1;
            return index;
        }


        public String Choice_Genre(int index) {
        String genre = genre_list.get(index);
        return genre;
        }

        public void ShowChosenGenreGames(String genre) {

            ArrayList<String> games = new ArrayList<>();
            ArrayList<String> genres = new ArrayList<>();
            ArrayList<Float> price = new ArrayList<>();


                    String game = "SELECT title, name, price  FROM game_genre"
                                  + " INNER JOIN genres ON genres.id = game_genre.genres_id"
                                  + " INNER JOIN games ON games.id = game_genre.games_id"
                                  + " WHERE genres.name LIKE ?";

                    try (PreparedStatement statement = connection.prepareStatement(game)) {
                        statement.setString(1, "%" + genre + "%");
                    ResultSet rs = statement.executeQuery();

                    while (rs.next()) {
                        games.add(rs.getString("title"));
                        genres.add(rs.getString("name"));
                        price.add(rs.getFloat("price"));
                    }
                    for (int i = 0; i < games.size(); i++) {
                        System.out.printf("%d)%s (%s): %.0f$\n", (i + 1), games.get(i), genres.get(i), price.get(i));
                    }

                } catch (Exception e) {
                    System.out.printf("\nSomething went wrong\n");
                    e.printStackTrace();
                }
        }
    }

