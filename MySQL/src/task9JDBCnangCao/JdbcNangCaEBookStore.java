package task9JDBCnangCao;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.Scanner;

public class JdbcNangCaEBookStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            // tìm sách theo tên thể loại
            System.out.println("Enter category: "); String enterCategory = sc.nextLine();
            String strSelect  = "select * from books as a join categories as b on a.`categoryID` = b.`categoryID` where categoryName = '" + enterCategory + "'";
            System.out.println("The SQL Statement is: " + strSelect + "\n");

            ResultSet resultSet = stmt.executeQuery(strSelect);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            System.out.println("The records selected are: ");
//            int rowCount = 0;
//            while (resultSet.next()) {
//                Integer bookID = resultSet.getInt("bookID");
//                String bookName = resultSet.getString("bookName");
//                Double price = resultSet.getDouble("price");
//                String author = resultSet.getString("author");
//                Integer qty = resultSet.getInt("qty");
//                Integer categoryID = resultSet.getInt("categoryID");
//                System.out.println(bookID + ", " + bookName + ", $" + price + ", " + author + ", " + qty + ", " + categoryID);
//                rowCount++;
//            }
//            System.out.println("Total number of records = " + rowCount);

            getResultSetMetaData(resultSet,resultSetMetaData);


            System.out.println('\n');


            // tìm sách theo tên tác giả
            System.out.println("Enter author: "); String enterAuthor = sc.nextLine();
            String strSelect2  = "select * from books  where author = '" + enterAuthor + "'";
            System.out.println("The SQL Statement is: " + strSelect2 + "\n");

            ResultSet resultSet2 = stmt.executeQuery(strSelect2);
            ResultSetMetaData resultSetMetaData2 = resultSet2.getMetaData();

//            System.out.println("The records selected are: ");
//            int rowCount2 = 0;
//            while (resultSet2.next()) {
//                Integer bookID2 = resultSet2.getInt("bookID");
//                String bookName2 = resultSet2.getString("bookName");
//                Double price2 = resultSet2.getDouble("price");
//                String author2 = resultSet2.getString("author");
//                Integer qty2 = resultSet2.getInt("qty");
//                Integer categoryID2 = resultSet2.getInt("categoryID");
//                System.out.println(bookID2 + ", " + bookName2 + ", $" + price2 + ", " + author2 + ", " + qty2 + ", " + categoryID2);
//                rowCount2++;
//            }
//            System.out.println("Total number of records = " + rowCount2);

            getResultSetMetaData(resultSet2,resultSetMetaData2);


            System.out.println('\n');


            // tìm sách theo ID
            System.out.println("Enter ID: "); Integer enterID = sc.nextInt();
            String strSelect3  = "select * from books  where bookID = '" + enterID + "'";
            System.out.println("The SQL Statement is: " + strSelect3 + "\n");

            ResultSet resultSet3 = stmt.executeQuery(strSelect3);
            ResultSetMetaData resultSetMetaData3 = resultSet3.getMetaData();

//            System.out.println("The records selected are: ");
//            while (resultSet3.next()) {
//                Integer bookID3 = resultSet3.getInt("bookID");
//                String bookName3 = resultSet3.getString("bookName");
//                Double price3 = resultSet3.getDouble("price");
//                String author3 = resultSet3.getString("author");
//                Integer qty3 = resultSet3.getInt("qty");
//                Integer categoryID3 = resultSet3.getInt("categoryID");
//                System.out.println(bookID3 + ", " + bookName3 + ", $" + price3 + ", " + author3 + ", " + qty3 + ", " + categoryID3);
//            }

            getResultSetMetaData(resultSet3, resultSetMetaData3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getResultSetMetaData(ResultSet rset, ResultSetMetaData rsetMD) throws SQLException {
        int numColumns = rsetMD.getColumnCount();

        for (int i = 1; i <= numColumns; ++i) {
            System.out.printf("%-30s", rsetMD.getColumnName(i));
        }
        System.out.println();

        for (int i = 1; i <= numColumns; ++i) {
            System.out.printf("%-30s", "(" + rsetMD.getColumnClassName(i) + ")");
        }
        System.out.println();

        while (rset.next()) {
            for (int i = 1; i <= numColumns ; i++) {
                System.out.printf("%-30s", rset.getString(i));
            }
            System.out.println();
        }
    }
}
