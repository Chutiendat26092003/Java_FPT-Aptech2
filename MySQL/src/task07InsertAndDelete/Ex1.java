package task07InsertAndDelete;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            // DELETE records with id>8000
            String sqlDelete = "delete from books where id > 8000";
            System.out.println("The SQL statement is: " + sqlDelete + "\n");
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");

            // INSERT a record
            String sqlInsert = "insert into books (id, title, author) values (2001, 'Java JDBC MySQL', 'ThiDK')";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // INSERT multiple records
            sqlInsert = "insert into books values " +
                    "(8001, 'Java Core', 'Dang Kim Thi', 15.55, 55)," +
                    "(8002, 'Java Advanced', 'James Gosling', 25.55, 55)";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

            // DELETE 1 book with user-entered id
            System.out.println("Enter ID: "); Integer deleteID = sc.nextInt();
            String sqlDelete2 = "delete from books where id = " + deleteID;
            System.out.println("The SQL statement is: " + sqlDelete2 + "\n");
            int countDeleted2 = stmt.executeUpdate(sqlDelete2);
            System.out.println(countDeleted2 + " records deleted.\n");

            // INSERT user-entered book
            System.out.println("Enter ID: "); Integer insertID = sc.nextInt(); sc.nextLine();
            System.out.println("Enter title: "); String insertTitle = sc.nextLine();
            System.out.println("Enter author: "); String insertAuthor = sc.nextLine();
            System.out.println("Enter price: "); double insertPrice = sc.nextDouble();
            System.out.println("Enter qty: "); int insertQty = sc.nextInt();
            sqlInsert = "insert into books values (" + insertID + ", '" + insertTitle + "', '" + insertAuthor + "', " + insertPrice + ", " + insertQty + ")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");

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
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
