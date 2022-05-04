package task05ConnectDatabase;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;

public class Ex1 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "Select * from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title + ", " + author + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);


            System.out.println("\n");

            //2
            String strSelect2 = "Select title, price from books where author = 'CodeLean VN'";
            System.out.println("The SQL statement is: " + strSelect2 + "\n");

            ResultSet rset2 = stmt.executeQuery(strSelect2);

            System.out.println("The records selected are:");
            int rowCount2 = 0;
            while (rset2.next()) {
                String title2 = rset2.getString("title");
                double price2 = rset2.getDouble("price");
                System.out.println(title2 + ", "  + price2 + ", ");
                ++rowCount2;
            }
            System.out.println("Total number of records = " + rowCount2);


            System.out.println("\n");

            //3
            String strSelect3 = "Select title, author, price, qty from books where author = 'CodeLean VN' OR price >= 30 order by price DESC , id ASC ";
            System.out.println("The SQL statement is: " + strSelect3 + "\n");

            ResultSet rset3 = stmt.executeQuery(strSelect3);

            System.out.println("The records selected are:");
            int rowCount3 = 0;
            while (rset3.next()) {
                String title3 = rset3.getString("title");
                String author3 = rset3.getString("author");
                double price3 = rset3.getDouble("price");
                int qty3 = rset3.getInt("qty");
                System.out.println(title3 + ", " + author3 + ", " + price3 + ", " + qty3);
                ++rowCount3;
            }
            System.out.println("Total number of records = " + rowCount3);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
