package task04Coffee2;

/* 
    @author: chu tien dat

    Project Name: Main.java
*/

import Task04Coffee.Coffee;

import java.util.ArrayList;
import java.util.Scanner;

public class TestCafe {
    public static void main(String[] args) {
        Menu menu1 = new Menu("M1", "Cafe da", 20000);
        Menu menu2 = new Menu("M2", "Cafe sua", 35000);
        Menu menu3 = new Menu("M3", "Capuchino", 40000);
        Menu menu4 = new Menu("M4", "Matcha", 30000);
        Menu menu5 = new Menu("M5", "Cafe nau", 30000);

        Cafe cafeList = new Cafe();

        cafeList.addNewMenu(menu1);
        cafeList.addNewMenu(menu2);
        cafeList.addNewMenu(menu3);
        cafeList.addNewMenu(menu4);
        cafeList.addNewMenu(menu5);

//        User user1 = new User("U1", "Dat");
//        User user2 = new User("U2", "Dat");
//
//
//        cafeList.addNewUser(user1);
//        cafeList.addNewUser(user2);
//
//
//        cafeList.printMenuList();
//        cafeList.printUserList();
//        User user4 = new User("U2");
//        cafeList.removeUserList(user4);
//        cafeList.printUserList();

        Scanner sc = new Scanner(System.in);
        int select;
        do {
            System.out.println("\n----Moi ban lua chon----");
            System.out.println("0.  Thoat.");
            System.out.println("1.  Admin");
            System.out.println("2.  Khach hang.");
            System.out.println("Moi ban lua chon!!!");
            select = sc.nextInt(); sc.nextLine();
            switch (select){
                case 1:
                    int selectAdmin;
                    do {
                        System.out.println("\n----Moi Admin lua chon----");
                        System.out.println("0.  Thoat.");
                        System.out.println("1.  Them do uong.");
                        System.out.println("2.  Sua do uong.");
                        System.out.println("3.  Xoa do uong.");
                        System.out.println("4.  Tim kiem do uong.");
                        System.out.println("5.  Hien thi do uong.");
                        System.out.println("----------------------------");
                        System.out.println("6.  Sua khach hang.");
                        System.out.println("7.  Xoa khach hang.");
                        System.out.println("8.  Tim kiem khach hang.");
                        System.out.println("9.  Hien thi khach hang.");
                        System.out.println("Moi ban lua chon!!!");
                        System.out.println("----------------------------");
                        System.out.println("10. Hien thi tat ca");
                        selectAdmin = sc.nextInt(); sc.nextLine();

                        switch (selectAdmin) {
                            case 1:
                                System.out.println("Nhap id do uong: ");String idProduct11 = sc.nextLine();
                                System.out.println("Nhap ten do uong: ");String nameProduct11 = sc.nextLine();
                                System.out.println("Nhap gia do uong: ");float priceProduct11 = sc.nextFloat();
                                Menu menu11 = new Menu(idProduct11, nameProduct11, priceProduct11);
                                cafeList.addNewMenu(menu11);
                                break;

                            case 2:
                                System.out.println("Nhap id do uong ban muon sua: ");String idProduct12 = sc.nextLine();

                                System.out.println("Nhap id do uong moi: ");String idProduct122 = sc.nextLine();
                                System.out.println("Nhap ten do uong moi: ");String nameProduct122 = sc.nextLine();
                                System.out.println("Nhap gia do uong moi: ");float priceProduct122 = sc.nextFloat();
                                Menu menu12 = new Menu(idProduct12);
                                Menu menu122 = new Menu(idProduct122, nameProduct122, priceProduct122);
                                cafeList.updateMenuList(menu12,menu122);
                                break;

                            case 3:
                                System.out.println("Nhap id do uong ban muon xoa: ");String idProduct13 = sc.nextLine();
                                Menu menu13 = new Menu(idProduct13);
                                cafeList.removeMenuList(menu13);
                                break;

                            case 4:
                                int selectSearch14;
                                do {
                                    System.out.println("\n0.  Thoat.");
                                    System.out.println("1.  Tim kiem theo id do uong.");
                                    System.out.println("2.  Tim kiem theo ten do uong.");
                                    System.out.println("Moi ban lua chon!!!");
                                    selectSearch14 = sc.nextInt(); sc.nextLine();
                                    if (selectSearch14==1) {
                                        System.out.println("Nhap id do uong ban muon tim: ");String idProduct22 = sc.nextLine();
                                        Menu menu22 = new Menu(idProduct22);
                                        cafeList.searchIdMenuList(menu22);
                                    } else if (selectSearch14==2){
                                        System.out.println("Nhap ten do uong ban muon tim: ");String nameProduct22 = sc.nextLine();
                                        cafeList.searchNameMenuList(nameProduct22);
                                    }
                                } while (selectSearch14 != 0);
                                break;
                            case 5:
                                cafeList.printMenuList();
                                break;
                            case 6:
                                System.out.println("Nhap id khach hang muon sua: ");String idUser16 = sc.nextLine();

                                System.out.println("Nhap id khach hang moi: ");String idUser162 = sc.nextLine();
                                System.out.println("Nhap ten khach hang moi: ");String nameUser162 = sc.nextLine();
                                User user16 = new User(idUser16);
                                User user162 = new User(idUser162, nameUser162);
                                cafeList.updateUserList(user16,user162);
                                break;
                            case 7:
                                System.out.println("Nhap id khach hang ban muon xoa: ");String idUser17 = sc.nextLine();
                                User user17 = new User(idUser17);
                                cafeList.removeUserList(user17);
                                break;

                            case 8:
                                System.out.println("Nhap id khach hang ban muon tim: ");String idUser18 = sc.nextLine();
                                User user18 = new User(idUser18);
                                cafeList.searchIdUserList(user18);
                                break;
                            case 9:
                                cafeList.printUserList();
                                break;
                            case 10:
                                cafeList.printMenuList();
                                cafeList.printUserList();
                                cafeList.printOrderList();
                                break;
                        }
                    } while (selectAdmin != 0); {
                    System.out.println("Xin Cam On!!!");
                    System.out.println("-------------------");
                }
                    break;
                case 2:
                    int selectUser;
                    System.out.println("Nhap id khach hang: ");String idUser2 = sc.nextLine();
                    System.out.println("Nhap ten khach hang: ");String nameUser2 = sc.nextLine();
                    User user2= new User(idUser2, nameUser2);
                    cafeList.addNewUser(user2);
                    do {
                        System.out.println("\n----Moi khach hang lua chon----");
                        System.out.println("0.  Thoat.");
                        System.out.println("1.  Hien thi Menu.");
                        System.out.println("2.  Tim kiem do uong trong menu.");
                        System.out.println("3.  Chon do uong.");
                        System.out.println("4.  Xoa do uong trong hoa don cua ban.");
                        System.out.println("5.  In hoa don.");
                        System.out.println("-------------------");
                        System.out.println("Moi ban lua chon!!!");
                        selectUser = sc.nextInt(); sc.nextLine();

                        switch (selectUser) {
                            case 1:
                                cafeList.printMenuList();
                                break;
                            case 2:
                                int selectSearch2;
                                do {
                                    System.out.println("\n0.  Thoat.");
                                    System.out.println("1.  Tim kiem theo id do uong.");
                                    System.out.println("2.  Tim kiem theo ten do uong.");
                                    System.out.println("Moi ban lua chon!!!");
                                    selectSearch2 = sc.nextInt(); sc.nextLine();
                                    if (selectSearch2==1) {
                                        System.out.println("Nhap id do uong ban muon tim: ");String idProduct22 = sc.nextLine();
                                        Menu menu22 = new Menu(idProduct22);
                                        cafeList.searchIdMenuList(menu22);
                                    } else if (selectSearch2==2){
                                        System.out.println("Nhap ten do uong ban muon tim: ");String nameProduct22 = sc.nextLine();
                                        cafeList.searchNameMenuList(nameProduct22);
                                    }
                                } while (selectSearch2 != 0);
                                break;
                            case 3:
                                System.out.println("Nhap id do uong: ");String idProduct23 = sc.nextLine();
                                System.out.println("Nhap so luong: ");int qty23 = sc.nextInt();sc.nextLine();
                                Menu menu23 = new Menu(idProduct23);
                                cafeList.addOrder(menu23, qty23);
                                break;
                            case 4:
                                System.out.println("Nhap id do uong ban muon xoa: ");String idProduct24 = sc.nextLine();
                                Order order24 = new Order(idProduct24);
                                cafeList.removeOrderList(order24);
                                break;
                            case 5:
                                cafeList.printOrderList();
                                break;
                        }
                    } while (selectUser != 0); {
                         System.out.println("Xin Cam On!!!");
                         System.out.println("-------------------");
                    }
                    break;
            }
        } while (select != 0); {
            System.out.println("Xin Cam On!!!");
            System.out.println("-------------------");

        }
    }
}
