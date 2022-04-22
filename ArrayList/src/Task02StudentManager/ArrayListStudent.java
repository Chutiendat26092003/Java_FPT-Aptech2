package Task02StudentManager;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayListStudent {
    public static void main(String[] args) {
        Date d1 = new Date(2003, 10, 3);
        Date d2 = new Date(2000, 7, 2);
        Date d3 = new Date(2003, 5, 23);
        List<Student> students = new ArrayList<>();
        students.add(new Student(1001, "Nguyen Van A",d1, "Ha Noi", '0'));
        students.add(new Student(1002, "Nguyen Van C",d2, "Ha Noi", '1'));
        students.add(new Student(1003, "Nguyen Van B",d3, "Ha Noi", '0'));

        students.forEach(student -> {
            System.out.println(student);
        });

        System.out.println(students.get(0).getFullName());
    }
}
