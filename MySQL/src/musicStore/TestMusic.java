package musicStore;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.Scanner;

public class TestMusic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emusicstore", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            // select
//            String sqlSelect = "Select * from musics";
//            System.out.println("The SQL Statement is: " + sqlSelect + "\n");
//            ResultSet rset = stmt.executeQuery(sqlSelect);
//            ResultSetMetaData rsetMD = rset.getMetaData();
//            displayTable(rset, rsetMD);

            select(stmt);

            // insert
            System.out.println("\n\nInsert a record");
            System.out.println("Enter ID: "); Integer insertID = sc.nextInt(); sc.nextLine();
            System.out.println("Enter name: "); String insertName = sc.nextLine();
            System.out.println("Enter author: "); String insertAuthor = sc.nextLine();
            System.out.println("Enter year: "); String insertYear = sc.nextLine();
            String sqlInsert = "insert into musics values (" + insertID + ", '" + insertName + "', '" + insertAuthor + "', " + insertYear + ")";
            System.out.println("The SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.");

//            // update
//            System.out.println("\n\nUpdate a record");
//            System.out.println("Enter ID: "); Integer updateID = sc.nextInt(); sc.nextLine();
//            System.out.println("Enter name new: "); String insertNewName = sc.nextLine();
//            System.out.println("Enter author new: "); String insertNewAuthor = sc.nextLine();
//            System.out.println("Enter year new: "); String insertNewYear = sc.nextLine();
//            String sqlUpdate = "update musics set name ='" + insertNewName + "', author ='" + insertNewAuthor + "', year ='" + insertNewYear + "' where  id = " + updateID;
//            System.out.println("The SQL statement is: " + sqlUpdate + "\n");
//            int countUpdate = stmt.executeUpdate(sqlUpdate);
//            System.out.println(countUpdate + " records inserted.");
//
//
//            // delete
//            System.out.println("\n\nDelete a record");
//            System.out.println("Enter ID: "); Integer enterDeleteId = sc.nextInt();
//            String sqlDelete = "delete from musics where id = " + enterDeleteId;
//            System.out.println("The SQL statement is: " + sqlDelete + "\n");
//            int countDeleted = stmt.executeUpdate(sqlDelete);
//            System.out.println(countDeleted + " records deleted.");
//
//            // search id
//            System.out.println("\n\nSearch a record");
//            System.out.println("Enter ID: "); Integer enterSearchId = sc.nextInt(); sc.nextLine();
//            String strSearch  = "select * from musics  where id = " + enterSearchId;
//            System.out.println("The SQL Statement is: " + strSearch + "\n");
//            ResultSet rsetS = stmt.executeQuery(strSearch);
//            ResultSetMetaData rsetMDS = rsetS.getMetaData();
//            displayTable(rsetS, rsetMDS);
//
//            // search id
//            System.out.println("\n\nSearch a record");
//            System.out.println("Enter name: "); String enterSearchName = sc.nextLine();
//            String strSearch2  = "select * from musics  where name like '%" + enterSearchName + "%'";
//            System.out.println("The SQL Statement is: " + strSearch2 + "\n");
//            ResultSet rsetS2 = stmt.executeQuery(strSearch2);
//            ResultSetMetaData rsetMDS2 = rsetS2.getMetaData();
//            displayTable(rsetS2, rsetMDS2);
//

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void select(Statement stmt) throws SQLException {
        String sqlSelect = "Select * from musics";
        System.out.println("The SQL Statement is: " + sqlSelect + "\n");
        ResultSet rset = stmt.executeQuery(sqlSelect);
        ResultSetMetaData rsetMD = rset.getMetaData();
        displayTable(rset, rsetMD);
    }

    public static void displayTable(ResultSet rset, ResultSetMetaData rsetMD) throws SQLException {
        int numColumns = rsetMD.getColumnCount();

        for (int i = 1; i <= numColumns; i++) {
            System.out.printf("%-30s", rsetMD.getColumnName(i));
        }
        System.out.println();

        for (int i = 1; i <= numColumns; i++) {
            System.out.printf("%-30s", "(" + rsetMD.getColumnClassName(i) + ")" );
        }
        System.out.println();

        while (rset.next()) {
            for (int i = 1; i <= numColumns; i++) {
                System.out.printf("%-30s", rset.getString(i));
            }
            System.out.println();
        }
    }
}
