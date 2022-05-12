package giftview;

/* 
    @author: chu tien dat

    Project Name: giftshop
*/

import giftcontroller.GiftController;
import giftmodel.Gift;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiftShop {
    public static void main(String[] args) throws SQLException {
//        List<Gift> giftList = new ArrayList<>();
        Gift gift1 = new Gift(7, "Bup be", 20, 20);
        Gift gift2 = new Gift(7);


        GiftController giftController = new GiftController();
        System.out.println(giftController.findAll());

//        giftController.insert(gift1);
        giftController.delete(gift2);

        System.out.println(giftController.findAll());
        System.out.println(giftController.findAll());
    }
}
