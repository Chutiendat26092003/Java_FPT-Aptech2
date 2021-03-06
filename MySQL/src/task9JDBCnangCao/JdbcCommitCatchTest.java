package task9JDBCnangCao;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;

public class JdbcCommitCatchTest {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            //Disable auto-commit
            conn.setAutoCommit(false);

            // Issue two INSERT statements
            stmt.executeUpdate("insert into books values (4004, 'Paul Chan', 'Mahjong 101', 4.4, 4)");
            // Duplicate primary key, which triggers a SQLException
            stmt.executeUpdate("insert into books values (4004, 'Paul Chan', 'Mahjong 102', 4.4, 4)");
            conn.commit();

            System.out.println("-- Rolling back changes --");
            conn.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
