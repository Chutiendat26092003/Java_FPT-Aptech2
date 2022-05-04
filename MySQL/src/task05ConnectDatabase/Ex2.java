package task05ConnectDatabase;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;

public class Ex2 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");

                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "Select * from customers";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                String CustomerID = rset.getString("CustomerID");
                String CompanyName = rset.getString("CompanyName");
                double ContactName = rset.getDouble("ContactName");
                int ContactTitle = rset.getInt("ContactTitle");
                System.out.println(CustomerID + ", " + CompanyName + ", " + ContactName + ", " + ContactTitle);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);


            System.out.println("\n");

            //2
//            String strSelect2 = "Select title, ContactName from books where CompanyName = 'CodeLean VN'";
//            System.out.println("The SQL statement is: " + strSelect2 + "\n");
//
//            ResultSet rset2 = stmt.executeQuery(strSelect2);
//
//            System.out.println("The records selected are:");
//            int rowCount2 = 0;
//            while (rset2.next()) {
//                String CustomerID2 = rset2.getString("CustomerID");
//                double ContactName2 = rset2.getDouble("ContactName");
//                System.out.println(CustomerID2 + ", "  + ContactName2 + ", ");
//                ++rowCount2;
//            }
//            System.out.println("Total number of records = " + rowCount2);
//
//
//            System.out.println("\n");

            //3
//            String strSelect3 = "Select title, CompanyName, ContactName, ContactTitle from books where CompanyName = 'CodeLean VN' OR ContactName >= 30 order by ContactName DESC , id ASC ";
//            System.out.println("The SQL statement is: " + strSelect3 + "\n");
//
//            ResultSet rset3 = stmt.executeQuery(strSelect3);
//
//            System.out.println("The records selected are:");
//            int rowCount3 = 0;
//            while (rset3.next()) {
//                String CustomerID3 = rset3.getString("CustomerID");
//                String CompanyName3 = rset3.getString("CompanyName");
//                double ContactName3 = rset3.getDouble("ContactName");
//                int ContactTitle3 = rset3.getInt("ContactTitle");
//                System.out.println(CustomerID3 + ", " + CompanyName3 + ", " + ContactName3 + ", " + ContactTitle3);
//                ++rowCount3;
//            }
//            System.out.println("Total number of records = " + rowCount3);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
