import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Scanner;


public class Members {
    int id;
    String name;
    String email;

    public Members(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Members{" + "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    static Scanner input = new Scanner(System.in);
    static Connection connection;

    static {
        try {
            connection = jdbcConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void memberId(){
        String query = "Select id FROM Members Where name = ? AND email = ?";
        PreparedStatement preparedStatement ;
        try {
            preparedStatement = connection.prepareStatement(query);
            System.out.println("Enter the Name of the Member");
            String name = input.nextLine();
            System.out.println("Enter the email of the Member");
            String email = input.nextLine();
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                System.out.println("Your Member id is :"+rs.getInt("id"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void searchBook(){
        System.out.println("Enter the name of the Book Do you want to check if available");
        String name = input.nextLine();
        System.out.println("Author of the Book");
        String author = input.nextLine();
        String query = "SELECT available FROM Books WHERE title = ? AND author = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,author);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()&& rs.getBoolean("available")){
                System.out.println("Book is Available to rent");
                System.out.println();
            }else {
                System.out.println("Apologized Book is already Borrowed...");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rentBook(int memberID){
        System.out.println("Enter the Title of the Book do you want to rent");
        String title = input.nextLine();
        System.out.println("Enter the Author of the Book");
        String author = input.nextLine();
        System.out.println("Checking if your Book is available.......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("sleep exception");
        }
        String query = "Select Available,id From Books Where title =? AND author =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,author);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()&& rs.getBoolean("available")){
                System.out.println("Book is Available");
                String query2 = "INSERT INTO transactions (book_id,member_id) VALUES (?,?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query2);
                preparedStatement1.setInt(1,rs.getInt("id"));
                preparedStatement1.setInt(2,memberID);
                int row = preparedStatement1.executeUpdate();
                if (row>0){

                    String query3 = "UPDATE Books SET available = ? Where id=? ";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(query3);
                    preparedStatement2.setBoolean(1,false);
                    preparedStatement2.setInt(2,rs.getInt("id"));
                    preparedStatement2.executeUpdate();
                    System.out.println("Enjoy your book");
                    System.out.println();
                }else {
                    System.out.println("problem talk to the librarian...");
                    System.out.println();
                }
            }else {
                System.out.println("Sorry Book is not available right now");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("prepared exception");
        }
    }

    public static void returnBook() {
        System.out.println("Enter the Book Id of the Book Do you want to return");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Enter the Title of the Book");
        String title = input.nextLine();
        String query = "UPDATE Books SET available =? Where id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1,true);
            preparedStatement.setInt(2,id);
            int row = preparedStatement.executeUpdate();
            if (row>0){
                String query1 = "UPDATE transactions SET Return_date = ? WHERE book_id =?";
                LocalDate currentDate = LocalDate.now();
                Date sqlDate = Date.valueOf(currentDate);
              PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
              preparedStatement1.setDate(1,sqlDate);
              preparedStatement1.setInt(2,id);
              preparedStatement1.executeUpdate();
                System.out.println("Thank You for the return");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("prepared exception");
        }

    }
    public static void viewRentals(){
        System.out.println("Enter your member id ");
        int id = input.nextInt();
        input.nextLine();
        String query = "Select * FROM transactions WHERE member_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                System.out.printf("Book_id:- %d borrowed date:- %tF returned date:- %tF ",rs.getInt("book_id"),
                        rs.getDate("Borrowed_date"),rs.getDate("Return_date"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("sql prepared exception");
        }
    }


}
