/*
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.Scanner;

public class buoi5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            // Issue a SELECT to check the changes
            String strSelect = "select * from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + ", "
                        + resultSet.getString("author") + ", "
                        + resultSet.getString("title") + ", "
                        + resultSet.getDouble("price") + ", "
                        + resultSet.getInt("qty")
                );
            }

            // SEARCH
            System.out.println("\n\nEnter the book  id you want to SEARCH: "); Integer enterID = sc.nextInt();
            String strSelect2  = "select * from books  where id = " + enterID;
            System.out.println("The SQL Statement is: " + strSelect2 + "\n");
            ResultSet resultSet2 = stmt.executeQuery(strSelect2);
            System.out.println("The records selected are: ");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getInt("id") + ", "
                        + resultSet2.getString("author") + ", "
                        + resultSet2.getString("title") + ", "
                        + resultSet2.getDouble("price") + ", "
                        + resultSet2.getInt("qty")
                );
            }

            // DELETE 1 book with user-entered id
            System.out.println("\n\nEnter the book  id you want to DELETE: "); Integer deleteID = sc.nextInt();
            String sqlDelete = "delete from books where id = " + deleteID;
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

            // INSERT user-entered book
            System.out.println("Insert a record");
            System.out.println("Enter ID: "); Integer insertID = sc.nextInt(); sc.nextLine();
            System.out.println("Enter title: "); String insertTitle = sc.nextLine();
            System.out.println("Enter author: "); String insertAuthor = sc.nextLine();
            System.out.println("Enter price: "); double insertPrice = sc.nextDouble();
            System.out.println("Enter qty: "); int insertQty = sc.nextInt();
            String sqlInsert = "insert into books values (" + insertID + ", '" + insertTitle + "', '" + insertAuthor + "', " + insertPrice + ", " + insertQty + ")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");


            //  Issue a SELECT to check the changes
            String strSelect3 = "select * from books";
            System.out.println("The SQL statement is: " + strSelect3 + "\n");
            ResultSet resultSet3 = stmt.executeQuery(strSelect3);
            while (resultSet3.next()) {
                System.out.println(resultSet3.getInt("id") + ", "
                        + resultSet3.getString("author") + ", "
                        + resultSet3.getString("title") + ", "
                        + resultSet3.getDouble("price") + ", "
                        + resultSet3.getInt("qty")
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
