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
    private String url = "jdbc:mysql://localhost:3306/emusicstore";
    private String user = "root";
    private String password = "";

    Scanner sc = new Scanner(System.in);
    List<Music> musicList;

    public MusicList() {
        this.musicList = new ArrayList<>();
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Music> arrayListMusic() throws  SQLException {
        String strSelect = "select * from musics";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();;
            ResultSet rs = statement.executeQuery(strSelect);
            while (rs.next()) {
                Music music = new Music(rs.getString("id"),rs.getString("name"),rs.getString("author"),rs.getString("year"));
                if (!this.musicList.contains(music)) {
                    musicList.add(music);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicList;
    }

    //select
    public void display() throws  SQLException {
        arrayListMusic();
        int num = musicList.size();

        System.out.printf("%-25s", "StudentID");
        System.out.printf("%-25s", "Student Name");
        System.out.printf("%-25s", "Address");
        System.out.printf("%-25s", "Phone");
        System.out.println();

        for (int i = 0; i < num ; i++) {
            System.out.printf("%-25s", musicList.get(i).getId());
            System.out.printf("%-25s", musicList.get(i).getName());
            System.out.printf("%-25s", musicList.get(i).getAuthor());
            System.out.printf("%-25s", musicList.get(i).getYear());
            System.out.println();
        }
    }

    // search
    public void searchId(int id) throws SQLException{
//        arrayListMusic();
        for (Music music: musicList) {
            if (music.equals(id)) {
                System.out.printf("%-25s", "StudentID");
                System.out.printf("%-25s", "Student Name");
                System.out.printf("%-25s", "Address");
                System.out.printf("%-25s", "Phone");
                System.out.println();

                System.out.printf("%-25s", music.getId());
                System.out.printf("%-25s", music.getName());
                System.out.printf("%-25s", music.getAuthor());
                System.out.printf("%-25s", music.getYear());
            }
        }
    }

    public void searchName(String name) throws SQLException{
        arrayListMusic();
        for (Music music: musicList) {
            if (music.getName().indexOf(name) >= 0) {
                System.out.printf("%-25s", "StudentID");
                System.out.printf("%-25s", "Student Name");
                System.out.printf("%-25s", "Address");
                System.out.printf("%-25s", "Phone");
                System.out.println();

                System.out.printf("%-25s", music.getId());
                System.out.printf("%-25s", music.getName());
                System.out.printf("%-25s", music.getAuthor());
                System.out.printf("%-25s", music.getYear());
            }
        }
    }


}

