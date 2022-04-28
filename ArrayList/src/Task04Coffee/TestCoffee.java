package Task04Coffee;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import task04Coffee2.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCoffee {
    public static void main(String[] args) {

        CoffeeList coffeeList = new CoffeeList();

        Scanner sc = new Scanner(System.in);
        int luaChon;
        do {
            System.out.println("\n---- Bang dich vu ----");
            System.out.println("0.  Thoat.");
            System.out.println("1.  Them do uong.");
            System.out.println("2.  Sua do uong.");
            System.out.println("3.  Xoa do uong.");
            System.out.println("4.  Tim kiem do uong.");
            System.out.println("5.  Hien thi do uong.");
            System.out.println("Moi ban lua chon!!!");
            luaChon = sc.nextInt(); sc.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.println("Nhap id do uong: ");String id1 = sc.nextLine();
                    System.out.println("Nhap ten do uong: ");String name1 = sc.nextLine();
                    System.out.println("Nhap size do uong: ");char size1 = sc.next().charAt(0);
                    System.out.println("Nhap gia do uong: ");float price1 = sc.nextFloat();
                    Coffee coffee1 = new Coffee(id1, name1, size1, price1);
                    coffeeList.addCoffeeList(coffee1);
                    break;

                case 2:
                    System.out.println("Nhap id do uong ban muon sua: ");String id2 = sc.nextLine();

                    System.out.println("Nhap id do uong moi: ");String id22 = sc.nextLine();
                    System.out.println("Nhap ten do uong moi: ");String name22 = sc.nextLine();
                    System.out.println("Nhap size do uong moi: ");char size22 = sc.next().charAt(0);
                    System.out.println("Nhap gia do uong moi: ");float price22 = sc.nextFloat();

                    Coffee coffee2 = new Coffee(id2);
                    Coffee coffee22 = new Coffee(id22, name22, size22, price22);
                    coffeeList.updateCoffeeList(coffee2, coffee22);
                    break;

                case 3:
                    System.out.println("Nhap id do uong ban muon xoa: ");String id3 = sc.nextLine();
                    Coffee coffee3 = new Coffee(id3);
                    coffeeList.removeCoffeeList(coffee3);
                    break;

                case 4:
                    int luaChonTimKiem;
                    do {
                        System.out.println("\n0.  Thoat.");
                        System.out.println("1.  Tim kiem theo id do uong.");
                        System.out.println("2.  Tim kiem theo ten do uong.");
                        System.out.println("Moi ban lua chon!!!");
                        luaChonTimKiem = sc.nextInt(); sc.nextLine();
                        if (luaChonTimKiem==1) {
                            System.out.println("Nhap id do uong ban muon tim: ");String id4 = sc.nextLine();
                            Coffee coffee4 = new Coffee(id4);
                            coffeeList.searchIdCoffeeList(coffee4);
                        } else if (luaChonTimKiem==2){
                            System.out.println("Nhap ten do uong ban muon tim: ");String nameCoffee = sc.nextLine();
                            coffeeList.searchNameCoffeeList(nameCoffee);
                        }
                    } while (luaChonTimKiem != 0);
                    break;

                case 5:
                    coffeeList.printCoffeeList();
                    break;
            }
        } while (luaChon != 0); {
            System.out.println("Xin Cam On!!!");
        }
    }
}
