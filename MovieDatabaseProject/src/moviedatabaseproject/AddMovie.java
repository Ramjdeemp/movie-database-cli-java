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

    public class AddMovie{
    static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
    static final String USER = "root";
    static final String PASS = "";
    static Scanner sc = new Scanner(System.in);
    public static void addMovie() {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO movies(name, genre, release_year, imdb_rating) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            System.out.print("Movie Name: ");
            String name = sc.nextLine();
            System.out.print("Genre: ");
            String genre = sc.nextLine();
            System.out.print("Year: ");
            int year = sc.nextInt();
            System.out.print("IMDB Rating: ");
            double rating = sc.nextDouble();
            ps.setString(1, name);
            ps.setString(2, genre);
            ps.setInt(3, year);
            ps.setDouble(4, rating);
            ps.executeUpdate();
            System.out.println("Movie added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}