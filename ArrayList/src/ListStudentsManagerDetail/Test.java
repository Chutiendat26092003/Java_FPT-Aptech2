package ListStudentsManagerDetail;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListStudent listStudent = new ListStudent();
        int selection = 0;
        do {
            System.out.println("\n\t  Vui long lua chon!");
            System.out.println("------------- Menu -----------");
            System.out.println(
                      "1. Them sinh vien vao danh sach.\n"
                    + "2. In danh sach sinh vien ra man hinh.\n"
                    + "3. Kiem tra danh sach co trong hay khong.\n"
                    + "4. Lay ra so luong sinh vien trong danh sach.\n"
                    + "5. Lam rong danh sach sinh vien.\n"
                    + "6. Kiem tra sinh vien co trong danh sach hay khong, dua tren ma sinh vien.\n"
                    + "7. Xoa khoi sinh vien ra khoi danh sach dua tren ma sinh vien.\n"
                    + "8. Tim kien tat ca sinh vien dua  tren Ten đuoc nhap tu ban phim.\n"
                    + "9. Xuat ra sinh vien co điem tu cao đen thap.\n"
                    + "10. Sap xep theo Ten"
                    + "0. Thoat khoi chuong trinh"
            );
            selection = sc.nextInt();
            sc.nextLine();

            switch (selection) {
                case 1: //1. Thêm sinh viên vào danh sách.
                    System.out.println("Nhap ma sinh vien: "); String rollNo = sc.nextLine();
                    System.out.println("Nhap ho va ten: "); String fullName = sc.nextLine();
                    System.out.println("Nhap nam sinh: "); int DBO = sc.nextInt();
                    System.out.println("Nhap điem: "); float point = sc.nextFloat();
                    Student stu = new Student(rollNo, fullName,DBO, point);
                    listStudent.addStudent(stu);
                    break;

                case 2: //2. In danh sách sinh viên ra màn hình.
                    listStudent.printListStudent();
                    break;

                case 3: //3. Kiểm tra danh sách có trống hay không.
                    System.out.println("Danh sach rong: " + listStudent.checkListStudent());
                    break;

                case 4: //4. Lấy ra số lượng sinh viên trong danh sách.
                    System.out.println("Số luong hien tai: " + listStudent.printNumbersStudent());
                    break;

                case 5: //5. Làm rỗng danh sách sinh viên.
                    listStudent.removeAllList();
                    System.out.println("Đa xoa het!!");
                    break;

                case 6: //6. Kiểm tra sinh viên có trong danh sách hay không, dựa trên mã sinh viên.
                    System.out.println("Nhap ma sinh vien: "); String rollNo2 = sc.nextLine();
                    Student stu2 = new Student(rollNo2);
                    System.out.println("Kiem tra sinh vien có trong danh sach: " + listStudent.checkStudentExistence(stu2));
                    break;

                case 7: //7. Xóa khỏi sinh viên ra khỏi danh sách dựa trên mã sinh viên.
                    System.out.println("Nhap ma sinh vien: "); String rollNo3 = sc.nextLine();
                    Student stu3 = new Student(rollNo3);
                    System.out.println("Xóa sinh viên trong danh sach: " + listStudent.removeStudent(stu3));
                    break;

                case 8: //8. Tìm kiến tất cả sinh viên dựa  trên Tên được nhập từ bàn phím.
                    System.out.println("Nhap ho va ten: "); String fullName1= sc.nextLine();
                    System.out.println("Ket qua tim kiem: ");
                    listStudent.searchStudent(fullName1);
                    break;

                case 9: //9. Xuất ra sinh viên có điểm từ cao đến thấp.
                    listStudent.studentPointArrangement();
                    listStudent.printListStudent();
                    break;

                case 10: //10. Sắp xếp theo tên.
                    listStudent.studentNameArrangement();
                    listStudent.printListStudent();
            }
        } while (selection !=0 );{
            System.out.println("Xin Cam On!");
        }
    }
}
