package Java2OnTap;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicList {
    Scanner sc = new Scanner(System.in);
    List<Music> musicList;

    public MusicList() {
        this.musicList = new ArrayList<>();
    }

    public void displayArrayList() {
        System.out.printf("%-30s%-30s%-30s%-30s","ID","Name","Author","Year");
        System.out.println();
        for (Music music: musicList) {
            System.out.printf("%-30s%-30s%-30s%-30s",music.getId(),music.getName(),music.getAuthor(),music.getYear());
            System.out.println();
        }
    }

    public void addMusic(){
        String id;
        String name, author, year;
        System.out.println("Nhap ID:");
        id = sc.nextLine();
        if (musicList.stream().allMatch(music -> music.getId() != (id))){
            System.out.println("Nhap ten bai hat: ");
            name = sc.nextLine();
            System.out.println("Nhap ten tac gia: ");
            author = sc.nextLine();
            System.out.println("Nhap nam sang tac: ");
            year = sc.nextLine();
            Music mus = new Music(id, name, author, year);
            musicList.add(mus);
            System.out.println("Mot bai hat duoc them thanh cong!!!");
        }
        else {
            System.out.println("Trung Id , them that bai");
        }
    }

    // search
    public void searchIdArrayList(){
        System.out.println("Nhap ID bai hat ban tim:");
        String id = sc.nextLine();
        Music mus = new Music(id);
        for (Music music: musicList) {
            if (music.getId().indexOf(mus.getId()) >= 0) {
                System.out.printf("%-30s%-30s%-30s%-30s","ID","Name","Author","Year");
                System.out.println();
                System.out.printf("%-30s%-30s%-30s%-30s",music.getId(),music.getName(),music.getAuthor(),music.getYear());
            }
        }
    }

    public void searchNameArrayList(){
        System.out.println("Nhap Ten bai hat ban tim:");
        String name = sc.nextLine();
        for (Music music: musicList) {
            if (music.getName().indexOf(name) >= 0) {
                System.out.printf("%-30s%-30s%-30s%-30s","ID","Name","Author","Year");
                System.out.println();
                System.out.printf("%-30s%-30s%-30s%-30s",music.getId(),music.getName(),music.getAuthor(),music.getYear());
            }
        }
    }

    public void deleteArrayList() {
        System.out.println("Nhap ID bai hat ban muon xoa:");
        String id = sc.nextLine();
        Music mus = new Music(id);

        if (this.musicList.contains(mus)) {
            this.musicList.remove(mus);
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Khong ton tai!!!");
        }
    }

    //Update
    public  void updateArrayList() {
        System.out.println("Nhap ID bai hat can chinh sua ");
        String id = sc.nextLine();
        if (musicList.stream().anyMatch(music -> music.getId().equals(id)) ){
            for (Music stu  : musicList) {
                if (stu.getId().equals(id)){
                    System.out.println("Moi ban nhap lua chon");
                    System.out.println("1.  De sua name");
                    System.out.println("2.  De sua author");
                    int sl = sc.nextInt();
                    switch (sl){
                        case 1:
                            System.out.println("Moi ban nhap ten bai hat moi");
                            sc.nextLine();
                            String name = sc.nextLine();
                            stu.setName(name);
                            System.out.println("Sua Thanh cong");
                            break;

                        case 2:
                            System.out.println("Moi ban nhap tac gia moi");
                            sc.nextLine();
                            String author = sc.nextLine();
                            stu.setAuthor(author);
                            System.out.println("Sua Thanh cong");
                            break;
                        default:
                            System.out.println("Nhap sai lua chon");
                            break;

                    }
                }
            }

        }else {
            System.out.println("Ten bai hat ko ton tai trong bo suu tap");
        }
    }

    public void saveArrayList() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emusicstore", "root", "");
            connection.setAutoCommit(false);
            String insert = "insert into musics value(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            for (Music stu : musicList) {
                System.out.println(stu.getId());
                ps.setString(1, stu.getId());
                ps.setString(2, stu.getName());
                ps.setString(3, stu.getAuthor());
                ps.setString(4, stu.getYear());
                ps.addBatch();
            }
            int[] count = ps.executeBatch();
            int sum = 0;
            for (int i : count) {
                sum += i;
            }
            connection.commit();
            System.out.println("So ban ghi dc them thanh cong: " + sum);

        } catch (SQLException e) {
            System.out.println("Them du lieu that bai");
            e.printStackTrace();

        }

    }
}

