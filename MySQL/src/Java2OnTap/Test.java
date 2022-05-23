package Java2OnTap;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/


import java.sql.SQLException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        MusicList musicList = new MusicList();

//        musicList.display();
//        musicList.searchName("Ngay");
//        Music music = new Music(102);
//        musicList.searchId(music);

        int luaChon;
        do {
            System.out.println("\n----------Moi ban lua chon----------");
            System.out.println("1.  Them ban ghi.");
            System.out.println("2.  Xoa ban ghi.");
            System.out.println("3.  Hien thi danh sach.");
            System.out.println("4.  Tim kien ban ghi");
            System.out.println("5.  Sua ban ghi");
            System.out.println("6.  Thoat");

            luaChon = sc.nextInt();sc.nextLine();
            switch (luaChon) {
                case 1:
                    break;

                case 2:

                    break;

                case 3:
                    musicList.display();
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
                            System.out.println("Nhap id bai hat ban muon tim: ");Integer id4 = sc.nextInt();
                            musicList.searchId(id4);
                        } else if (selectSearch==2){
                            System.out.println("Nhap ten bai hat ban muon tim: ");String name4 = sc.nextLine();
                            musicList.searchName(name4);
                        }
                    } while (selectSearch != 0);
                    break;

                case 5:
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Chon sai !!.Moi ban chon lai !!");
            }

        } while (luaChon !=6 );{
            System.out.println("Xin cam on !!!");
        }
    }
}
