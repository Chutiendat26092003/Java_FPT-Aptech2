package Java2OnTap;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/


import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emusicstore", "root", "");
        ) {
            Scanner sc = new Scanner(System.in);
            MusicList musicList = new MusicList();


            int luaChon;
            do {
                System.out.println("\n----------Moi ban lua chon----------");
                System.out.println("1.  Them ban ghi.");
                System.out.println("2.  Xoa ban ghi.");
                System.out.println("3.  Hien thi danh sach.");
                System.out.println("4.  Tim kien ban ghi.");
                System.out.println("5.  Sua ban ghi.");
                System.out.println("6.  Luu len database");
                System.out.println("7.  Hien thi du lieu tu database.");
                System.out.println("8.  Thoat.");

                luaChon = sc.nextInt();sc.nextLine();
                switch (luaChon) {
                    case 1:
                        musicList.addMusic();
                        break;

                    case 2:
                        musicList.deleteArrayList();
                        break;

                    case 3:
                        musicList.displayArrayList();
                        break;

                    case 4:
                        int selectSearch;
                        do {
                            System.out.println("\n0.  Thoat.");
                            System.out.println("1.  Tim kiem theo id bai hat.");
                            System.out.println("2.  Tim kiem theo ten bai hat.");
                            System.out.println("Moi ban lua chon!!!");
                            selectSearch = sc.nextInt(); sc.nextLine();
                            if (selectSearch==1) {
                                musicList.searchIdArrayList();
                            } else if (selectSearch==2){
                                musicList.searchNameArrayList();
                            }
                        } while (selectSearch != 0);
                        break;

                    case 5:
                        musicList.updateArrayList();
                        break;

                    case 6:
                        musicList.saveArrayList();
                        break;

                    case 7:
                        System.out.println("Hien thi du lieu tu database");
                        String displayStm = "Select * from musics";
                        PreparedStatement prpStmSelect = conn.prepareStatement(displayStm);
                        ResultSet rset = prpStmSelect.executeQuery();
                        ResultSetMetaData rsetMD = rset.getMetaData();
                        int numColumns = rsetMD.getColumnCount();
                        for (int i = 1; i <= numColumns; ++i) {
                            System.out.printf("%-30s", rsetMD.getColumnName(i));
                        }
                        System.out.println();
                        for (int i = 1; i <= numColumns; ++i) {
                            System.out.printf("%-30s",
                                    "(" + rsetMD.getColumnClassName(i) + ")");
                        }
                        System.out.println();
                        while (rset.next()) {
                            for (int i = 1; i <= numColumns; ++i) {
                                System.out.printf("%-30s", rset.getString(i));
                            }
                            System.out.println();
                        }
                        break;

                    default:
                        System.out.println("Chon sai !!.Moi ban chon lai !!");
                }

            } while (luaChon !=8 );{
                System.out.println("Xin cam on !!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
