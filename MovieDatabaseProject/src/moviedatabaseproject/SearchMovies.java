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
public class SearchMovies {
    static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
    static final String USER = "root";
    static final String PASS = "";
    static Scanner sc = new Scanner(System.in);
        public static void searchMovie() {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {

            System.out.print("Enter movie name: ");
            String name = sc.nextLine();

            String sql = "SELECT * FROM movies WHERE name LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
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
