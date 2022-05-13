package task9JDBCnangCao;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;

public class JdbcCommit {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "Select title, price, qty from books";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

            conn.setAutoCommit(false);

            ResultSet rset1 = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
            System.out.println("-- Before UPDATE --");
            while (rset1.next()) {
                System.out.println(rset1.getInt("id") + ", " + rset1.getInt("qty"));
            }
            conn.commit();

            stmt.executeUpdate("update books set qty = qty + 1 where  id = 1001");
            stmt.executeUpdate("update books set qty = qty + 1 where  id = 1002");
            conn.commit();

            rset1 = stmt.executeQuery("select id, qty from books where  id in (1001, 1002)");
            System.out.println("-- After UPDATE and Commit --");
            while (rset1.next()) {
                System.out.println(rset1.getInt("id") + ", " + rset1.getInt("qty"));
            }
            conn.commit();

            stmt.executeUpdate("update books set qty = qty - 99 where  id = 1001");
            stmt.executeUpdate("update books set qty = qty - 99 where  id = 1001");
            conn.rollback();

            rset1 = stmt.executeQuery("select id, qty from books where  id in (1001, 1002)");
            System.out.println("-- After UPDATE and Rollback --");
            while (rset1.next()) {
                System.out.println(rset1.getInt("id") + ", " + rset1.getInt("qty"));
            }
            conn.commit();




        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
