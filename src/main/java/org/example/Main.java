package org.example;

import UI_LOGIC.UI.Openning_UI;
import UI_LOGIC.UI.SQLlogic.Entrance_Logic;

import java.sql.Connection;
import java.sql.DriverManager;


public class Main {

    public static void main(String[] args) {

        String url = "jdbc:sqlite:database.db";
            try(Connection connection = DriverManager.getConnection(url)) {
                Entrance_Logic entranceLogic = new Entrance_Logic(connection);

                entranceLogic.entrance();

        }
            catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}