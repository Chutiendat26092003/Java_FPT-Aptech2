import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double soDuTaiKhoan;
        int luaChon;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien ban muon nap: "); soDuTaiKhoan = sc.nextDouble();

//        Locale lc = new Locale("vi", "VN");
        Locale lc = new Locale("en", "USA");
        NumberFormat numf = NumberFormat.getCurrencyInstance(lc);

        do {
            System.out.println("\n----------Moi ban lua chon----------");
            System.out.println("0.  Thoat");
            System.out.println("1.  Xem so du tai khoan.");
            System.out.println("2.  Tiep tuc choi.");

            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("So du tai khoan cua ban hien co: " + numf.format(soDuTaiKhoan));
                    break;

                case 2:
                    System.out.println("\n****** Bat dau choi ******");
                    System.out.println("Tai khoan cua ban co: " + numf.format(soDuTaiKhoan));

                    double datCuoc;
                    do {
                        System.out.println("Ban muon dat bao nhieu (0 < so tien dat cuoc < "+ numf.format(soDuTaiKhoan) +"): ");
                        datCuoc = sc.nextDouble();
                    } while (datCuoc<=0 || datCuoc>soDuTaiKhoan);


                    int luaChonTaiXiu;
                    do {
                        System.out.println("1.   Tai.\n2.   Xiu.");
                        luaChonTaiXiu = sc.nextInt();
                    } while (luaChonTaiXiu!=1 && luaChonTaiXiu!=2);


                    Random xx1 = new Random();
                    Random xx2 = new Random();
                    Random xx3 = new Random();

                    int giaTri1 = xx1.nextInt(5) + 1;
                    int giaTri2 = xx1.nextInt(5) + 1;
                    int giaTri3 = xx1.nextInt(5) + 1;
                    int tong = giaTri1 + giaTri2 + giaTri3;

                    System.out.println("Ket qua:[" + giaTri1 + ", " + giaTri2 + ", " + giaTri3 + "]");
                    if (tong==3 || tong==18) {
                        soDuTaiKhoan-=datCuoc;
                        System.out.println("***Tong la: " + tong + ". Em den lam!!! ***");
                        System.out.println("--- So du tai khoan: " + numf.format(soDuTaiKhoan) + " ---");
                    } else if (tong>=4 && tong<=10) {
                        System.out.println("*** Tong la: " + tong + ". => Xiu ***");
                        if (luaChonTaiXiu == 2) {
                            soDuTaiKhoan += datCuoc;
                            System.out.println("Thang cuoc.");
                            System.out.println("Hen thoi e nhe!!!");
                            System.out.println("--- So du tai khoan: " + numf.format(soDuTaiKhoan) + " ---");
                        } else {
                            soDuTaiKhoan -= datCuoc;
                            System.out.println("Thua cuoc.");
                            System.out.println("Hoi non!!!");
                            System.out.println("--- So du tai khoan: " + numf.format(soDuTaiKhoan) + " ---");
                        }
                    } else{
                        System.out.println("*** Tong la: " + tong + ". => Tai ***");
                        if (luaChonTaiXiu == 1) {
                            soDuTaiKhoan += datCuoc;
                            System.out.println("Thang cuoc.");
                            System.out.println("Hen thoi e nhe!!!");
                            System.out.println("--- So du tai khoan: " + numf.format(soDuTaiKhoan) + " ---");
                        } else {
                            soDuTaiKhoan -= datCuoc;
                            System.out.println("Thua cuoc.");
                            System.out.println("Hoi non!!!");
                            System.out.println("--- So du tai khoan: " + numf.format(soDuTaiKhoan) + " ---");
                        }
                    }
                    break;
            }

        } while (luaChon !=0 );{
            System.out.println("Dung lai la THAT BAI !!!");
        }
    }
}
