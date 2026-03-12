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

public class MovieCUIApp {

    static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
    static final String USER = "root";
    static final String PASS = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMovie Database");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Search Movie");
            System.out.println("4. Update Movie");
            System.out.println("5. Delete Movie");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    AddMovie.addMovie();
                    break;
                case 2:
                    ViewMovies.viewMovies();
                    break;
                case 3:
                    SearchMovies.searchMovie();
                    break;
                case 4:
                    UpdateMovies.updateMovie();
                    break;
                case 5:
                    DeleteMovies.deleteMovie();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}

