package managementStudent;

/* 
    @author: chu tien dat

    Project Name: ThiTH
*/

import java.sql.SQLException;
import java.util.Scanner;

public class testStudent {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        StudentList studentList = new StudentList();

        int luaChon;
        do {
            System.out.println("\n----------Moi ban lua chon----------");
            System.out.println("1.  Them ban ghi.");
            System.out.println("2.  Hien thi danh sach.");
            System.out.println("3.  Xoa ban ghi.");
            System.out.println("4.  Thoat");

            luaChon = sc.nextInt();sc.nextLine();
            switch (luaChon) {
                case 1:
                    System.out.println("Nhap id sinh vien: ");String id = sc.nextLine();
                    System.out.println("Nhap ten sinh vien: ");String name = sc.nextLine();
                    System.out.println("Nhap dia chi sinh vien: ");String address = sc.nextLine();
                    System.out.println("Nhap so dien thoai sinh vien: ");String phone = sc.nextLine();
                    Student student1 = new Student(id, name, address, phone);
                    studentList.insert(student1);
                    break;

                case 2:
                    studentList.display();
                    break;

                case 3:
                    System.out.println("Nhap id sinh vien ban muon xoa: ");String id2 = sc.nextLine();
                    Student student2 = new Student(id2);
                    studentList.delete(student2);
                    break;
            }

        } while (luaChon !=4 );{
            System.out.println("Xin cam on !!!");
        }
    }
}
