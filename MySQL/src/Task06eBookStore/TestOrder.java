package Task06eBookStore;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.Scanner;

public class TestOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
                Statement statement = connection.createStatement();
        ) {
            //hiển thị đơn hàng theo status = 1
            String strSelect = "select * from orders where status = 1";
            System.out.println("The SQL Statement is: " + strSelect + "\n");

            ResultSet resultSet = statement.executeQuery(strSelect);

            System.out.println("The records selected are: ");
            int rowCount = 0;
            while (resultSet.next()) {
                Integer orderID = resultSet.getInt("orderID");
                Integer customerID = resultSet.getInt("customerID");
                String orderDate = resultSet.getString("orderDate");
                String status = resultSet.getString("status");
                System.out.println(orderID + ", " + customerID + ", " + orderDate + ", " + status );
                rowCount++;
            }
            System.out.println("Total number of records = " + rowCount);

            System.out.println('\n');


            //hiển thị đơn hàng theo mã khách hàng
            String strSelect2 = "select * from orders";
            System.out.println("The SQL Statement is: " + strSelect2 + "\n");

            ResultSet resultSet2 = statement.executeQuery(strSelect2);

            System.out.println("The records selected are: ");
            int rowCount2 = 0;
            while (resultSet2.next()) {
                Integer orderID = resultSet2.getInt("orderID");
                String status = resultSet2.getString("status");
                System.out.println(orderID + ", " + status );
                rowCount2++;
            }
            System.out.println("Total number of records = " + rowCount2);

            System.out.println('\n');


            //hiển thị thông tin chi tiết đơn hàng theo mã được nhập vào
            System.out.println("Enter order ID: "); Integer enterOrderID = sc.nextInt();
            String strSelect3 = "select * from orderDetails where orderID  = " + enterOrderID;
            System.out.println("The SQL Statement is: " + strSelect3 + "\n");

            ResultSet resultSet3 = statement.executeQuery(strSelect3);

            System.out.println("The records selected are: ");
            int rowCount3 = 0;
            while (resultSet3.next()) {
                Integer orderID = resultSet3.getInt("orderID");
                Integer bookID = resultSet3.getInt("bookID");
                Integer qty = resultSet3.getInt("qty");
                Double price = resultSet3.getDouble("price");
                System.out.println(orderID + ", " + bookID + ", " + qty + ", " + price);
                rowCount3++;
            }
            System.out.println("Total number of records = " + rowCount3);

            System.out.println('\n');


            //hiển thị đơn hàng theo status được nhập vào
            Integer enterStatus;
            do {
                System.out.println("\n\nMenu status");
                System.out.println("0. Don hang bi khach hang huy");
                System.out.println("1. Don hang moi tiep nhan");
                System.out.println("2. Don hang dang cho xu ly");
                System.out.println("3. Don hang da dong goi");
                System.out.println("4. Don hang da gui van chuyen");
                System.out.println("5. Don hang da giao hang thanh cong");
                System.out.println("6. Thoat");
                System.out.println("Enter status: "); enterStatus = sc.nextInt();

                String strSelect4 = "select * from orders where status = " + enterStatus;
                System.out.println("The SQL Statement is: " + strSelect4 + "\n");

                ResultSet resultSet4 = statement.executeQuery(strSelect4);

                System.out.println("The records selected are: ");
                int rowCount4 = 0;
                while (resultSet4.next()) {
                    Integer orderID = resultSet4.getInt("orderID");
                    Integer customerID = resultSet4.getInt("customerID");
                    String orderDate = resultSet4.getString("orderDate");
                    String status = resultSet4.getString("status");
                    System.out.println(orderID + ", " + customerID + ", " + orderDate + ", " + status );
                    rowCount4++;
                }
                System.out.println("Total number of records = " + rowCount4);
            } while (enterStatus != 6);{
                System.out.println("End");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
