package ListStudentsManagerDetail;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListStudent {
    private ArrayList<Student> listStu;

    public ListStudent() {
        this.listStu = new ArrayList<Student>();
    }

    public ListStudent(ArrayList<Student> listStu) {
        this.listStu = listStu;
    }

    //1. Thêm sinh viên vào danh sách.
    public void addStudent(Student stu) {
        this.listStu.add(stu);
    }

    //2. In danh sách sinh viên ra màn hình.
    public void printListStudent() {
        for (Student stu: listStu) {
            System.out.println(stu);
        }
    }

    //3. Kiểm tra danh sách có trống hay không.
    public boolean checkListStudent() {
        return this.listStu.isEmpty();
    }

    //4. Lấy ra số lượng sinh viên trong danh sách.
    public int printNumbersStudent() {
        return this.listStu.size();
    }

    //5. Làm rỗng danh sách sinh viên.
    public void removeAllList() {
        this.listStu.removeAll(listStu);
    }

    //6. Kiểm tra sinh viên có trong danh sách hay không, dựa trên mã sinh viên.
    public boolean checkStudentExistence(Student stu) {
        return this.listStu.contains(stu);
    }

    //7. Xóa khỏi sinh viên ra khỏi danh sách dựa trên mã sinh viên.
    public boolean removeStudent(Student stu) {
        return this.listStu.remove(stu);
    }

    //8. Tìm kiến tất cả sinh viên dựa  trên Tên được nhập từ bàn phím.
    public void searchStudent(String name) {
        for (Student stu: listStu) {
            if (stu.getFullName().indexOf(name) >= 0) {
                System.out.println(stu);
            }
        }
    }

    //9. Xuất ra sinh viên có điểm từ cao đến thấp.
    public void studentPointArrangement() {
        Collections.sort(this.listStu, new Comparator<Student>() {
            @Override
            public int compare(Student stu1, Student stu2) {
                if (stu1.getPoint() < stu2.getPoint()) {
                    return 1;
                } else if (stu1.getPoint() > stu2.getPoint()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public void studentNameArrangement() {
        listStu.sort((listStu1, listStu2) -> listStu1.getFullName().compareTo(listStu2.getFullName()));
    }

}
