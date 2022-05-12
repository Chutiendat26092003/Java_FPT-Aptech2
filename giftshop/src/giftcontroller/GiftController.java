package giftcontroller;

/* 
    @author: chu tien dat

    Project Name: giftshop
*/

import giftmodel.Gift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiftController {
    private String url = "jdbc:mysql://localhost:3306/egiftshop";
    private String user = "root";
    private String password = "";

    List<Gift> giftList ;

    public GiftController() {
        this.giftList = new ArrayList<>();
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Gift> findAll()  throws SQLException {
//        List<Gift> giftList = new ArrayList<>();
        String strSelect = "select * from gifts";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(strSelect);
            while (rs.next()){
                Gift gift = new Gift(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"), rs.getInt("qty"));
                giftList.add(gift);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giftList;
    }

    public void insert(Gift gift) {
        String strInsert = "insert into gifts (id, name, price, qty) values (?, ?, ? ,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(strInsert);
            pstmt.setInt(1, gift.getId());
            pstmt.setString(2, gift.getName());
            pstmt.setFloat(3, gift.getPrice());
            pstmt.setInt(4, gift.getQty());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Gift gift) {
        String strDelete = "delete from gifts where id = " + gift.getId();
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(strDelete);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(Gift gift) {
        String strUpdate = "update gifts set id=?, name=?, price=?, qty=? where id=" + gift.getId();
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(strUpdate);
            pstmt.setInt(1, gift.getId());
            pstmt.setString(2, gift.getName());
            pstmt.setFloat(3, gift.getPrice());
            pstmt.setInt(4, gift.getQty());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
