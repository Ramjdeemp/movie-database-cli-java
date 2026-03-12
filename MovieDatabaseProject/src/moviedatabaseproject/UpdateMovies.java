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
public class UpdateMovies {
        static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
        static final String USER = "root";
        static final String PASS = "";
        static Scanner sc = new Scanner(System.in);
        public static void updateMovie() {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {

            System.out.print("Enter Movie ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("New Name: ");
            String name = sc.nextLine();

            String sql = "UPDATE movies SET name=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Movie updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}



