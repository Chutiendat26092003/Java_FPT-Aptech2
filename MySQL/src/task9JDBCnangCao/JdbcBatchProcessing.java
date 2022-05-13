package task9JDBCnangCao;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;

public class JdbcBatchProcessing {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");

                Statement stmt = conn.createStatement();
        ) {
//            conn.setAutoCommit(false);
//
//           stmt.addBatch("insert into books values (8001, 'Java ABC' ,'Kevin Jones', 1.1, 99)");
//           stmt.addBatch("insert into books values (8002, 'Java XYZ' ,'Kevin Jones', 1.1, 99)");
//           stmt.addBatch("update books set price = 11.11 where  id = 8001 or 8002");
//           int[] returnCodes = stmt.executeBatch();
//
//           System.out.println("Return codes are: ");
//           for (int code : returnCodes) {
//               System.out.printf(code + ", ");
//           }
//           System.out.println();
//
//           conn.commit();
//
//
//

           /*-------------
           -------------*/

            PreparedStatement pstmt = conn.prepareStatement("insert into books values (?, ?, ?, ?, ?)");
            conn.setAutoCommit(false);

            pstmt.setInt(1, 8003);
            pstmt.setString(2, "Java 123");
            pstmt.setString(3, "Kevin Jones");
            pstmt.setDouble(4, 12.34);
            pstmt.setInt(5,88);
            pstmt.addBatch();

            pstmt.setInt(1, 8004);
            pstmt.setString(2, "Java 456");
            pstmt.addBatch();

            int[] returnCodes2 = pstmt.executeBatch();

            System.out.println("Return codes are: ");
            for (int code : returnCodes2) {
                System.out.printf(code + ", ");
            }
            System.out.println();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
