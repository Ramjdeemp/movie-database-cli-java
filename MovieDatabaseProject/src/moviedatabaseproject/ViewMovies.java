/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedatabaseproject;

/**
 *
 * @author Rajdeep
 */
import java.sql.*;
import java.util.Scanner;
public class ViewMovies {

        static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
        static final String USER = "root";
        static final String PASS = "";
        public static void viewMovies() {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getInt("release_year") + " | " +
                        rs.getDouble("imdb_rating")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
