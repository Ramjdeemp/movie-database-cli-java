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
public class DeleteMovies {
        static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
        static final String USER = "root";
        static final String PASS = "";
        static Scanner sc = new Scanner(System.in);
        public static void deleteMovie() {

        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {

            System.out.print("Enter Movie ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM movies WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Movie deleted!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

