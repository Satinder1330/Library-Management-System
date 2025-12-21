import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Librarian {
    int id;
    String name;
    static Scanner input = new Scanner(System.in);
    static Connection connection;

    static {
        try {
            connection = jdbcConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addBook() {

        String query = "Insert into Books (title,author) Values (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Enter the Book title ");
            String name = input.nextLine();
            System.out.println("Enter the Book's Author name  ");
            String authorName = input.nextLine();
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,authorName);
            int row = preparedStatement.executeUpdate();
            if (row>0){
                System.out.println("Book is added");
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void deleteBook(){
        try {
            String query = "DELETE FROM Books WHERE title = ? AND author = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Enter the Book title Do you want to Delete");
            String title = input.nextLine();
            System.out.println("Enter the Author of the Book");
            String author = input.nextLine();
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            preparedStatement.executeUpdate();
            System.out.println();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void viewBooks(){
        try {
            String query = "SELECT * FROM Books";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
             while(resultSet.next()){
                 System.out.printf("Id: %d Book: %S  Author: %S Available: %B",resultSet.getInt("id"),resultSet.getString("title"),
                         resultSet.getString("author"),resultSet.getBoolean("available"));
                 System.out.println();
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void viewMembers(){
        try {
            String query = "SELECT * FROM Members";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.printf("Id: %d name: %S  email: %S",resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getString("email"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addMember(){
        String query="INSERT INTO Members (name,email) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Enter the Name of the Member");
            String name = input.nextLine();
            System.out.println("Enter the email of the Member");
            String email = input.nextLine();
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            int row = preparedStatement.executeUpdate();
            if(row>0){
                System.out.println("Member is Added");
                System.out.println();
            }else{
                System.out.println("problem in adding");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteMember(){
        String query="DELETE FROM Members WHERE name= ? AND email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Enter the Name of the Member");
            String name = input.nextLine();
            System.out.println("Enter the email of the Member");
            String email = input.nextLine();
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
             preparedStatement.executeUpdate();
            System.out.println();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
