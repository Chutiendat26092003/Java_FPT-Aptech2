package task05ConnectDatabase;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.Scanner;

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
                String ContactName = rset.getString("ContactName");
                String ContactTitle = rset.getString("ContactTitle");
                System.out.println(CustomerID + ", " + CompanyName + ", " + ContactName + ", " + ContactTitle);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);


            System.out.println("\n");

            //2
            String strSelect2 = "Select CustomerID, CompanyName, ContactName from customers where CompanyName = 'Vaffeljernet'";
            System.out.println("The SQL statement is: " + strSelect2 + "\n");

            ResultSet rset2 = stmt.executeQuery(strSelect2);

            System.out.println("The records selected are:");
            int rowCount2 = 0;
            while (rset2.next()) {
                String CustomerID2 = rset2.getString("CustomerID");
                String ContactName2 = rset2.getString("ContactName");
                String CompanyName2 = rset2.getString("CompanyName");
                System.out.println(CustomerID2 + ", " + CompanyName2 + ", "  + ContactName2 + ", ");
                ++rowCount2;
            }
            System.out.println("Total number of records = " + rowCount2);


            System.out.println("\n");

            //3
            String strSelect3 = "Select ProductID, ProductName, SupplierID from products";
            System.out.println("The SQL statement is: " + strSelect3 + "\n");

            ResultSet rset3 = stmt.executeQuery(strSelect3);

            System.out.println("The records selected are:");
            int rowCount3 = 0;
            while (rset3.next()) {
                Integer ProductID = rset3.getInt("ProductID");
                String ProductName = rset3.getString("ProductName");
                Integer SupplierID = rset3.getInt("SupplierID");
                System.out.println(ProductID + ", " + ProductName + ", " + SupplierID);
                ++rowCount3;
            }
            System.out.println("Total number of records = " + rowCount3);


            System.out.println("\n");


            //4
            Scanner sc  = new Scanner(System.in);
            System.out.println("Enter price min:"); double priceMin = sc.nextDouble();
            System.out.println("Enter price max:"); double priceMax = sc.nextDouble();
            String strSelect4 = "select * from products where " + priceMin + " <= UnitPrice && UnitPrice <= " + priceMax;
            System.out.println("The SQL statement is: " + strSelect4 + "\n");

            ResultSet rset4 = stmt.executeQuery(strSelect4);

            System.out.println("The records selected are:");
            int rowCount4 = 0;
            while (rset4.next()) {
                Integer ProductID = rset4.getInt("ProductID");
                String ProductName = rset4.getString("ProductName");
                Integer SupplierID = rset4.getInt("SupplierID");
                Double UnitPrice = rset4.getDouble("UnitPrice");
                System.out.println(ProductID + ", " + ProductName + ", " + SupplierID + ", " + UnitPrice);
                ++rowCount4;
            }
            System.out.println("Total number of records = " + rowCount4);


            System.out.println("\n");


            //5
            String strSelect5 = "select * from order details";
            System.out.println("The SQL statement is: " + strSelect5 + "\n");

            ResultSet rset5 = stmt.executeQuery(strSelect5);

            System.out.println("The records selected are:");
            int rowCount5 = 0;
            while (rset5.next()) {
                Integer OrderID = rset5.getInt("OrderID");
                Integer ProductID = rset5.getInt("ProductID");
                Double UnitPrice = rset5.getDouble("UnitPrice");
                Integer Quantity = rset5.getInt("Quantity");
                Integer Discount  = rset5.getInt("Discount");
                System.out.println(OrderID + ", " + ProductID + ", " + UnitPrice + ", " + Quantity + ", " + Discount);
                ++rowCount5;
            }
            System.out.println("Total number of records = " + rowCount5);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
