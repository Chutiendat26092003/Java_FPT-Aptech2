package managementStudent;

/* 
    @author: chu tien dat

    Project Name: ThiTH
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentList {
    private String url = "jdbc:mysql://localhost:3306/managementStudent";
    private String user = "root";
    private String password = "";

    List<Student> studentList;

    public StudentList() {
        this.studentList = new ArrayList<>();
    }

    public Connection getConnection() throws  SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Student> arrayListStudent() throws  SQLException {
        String strSelect = "select * from students";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();;
            ResultSet rs = statement.executeQuery(strSelect);
            while (rs.next()) {
                Student student = new Student(rs.getString("studentId"),rs.getString("name"),rs.getString("address"),rs.getString("phone"));
                if (!this.studentList.contains(student)) {
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public void insert(Student student) throws  SQLException {
        String strInsert = "insert into students values (?, ?, ? ,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(strInsert);
            pstmt.setString(1, student.getStudentId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getAddress());
            pstmt.setString(4, student.getPhone());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void display() throws  SQLException {
//        Connection connection = getConnection();
//        Statement statement = connection.createStatement();
//        ResultSet rset = statement.executeQuery("select * from students");
//        ResultSetMetaData rsetMD = rset.getMetaData();
//        int numColumns = rsetMD.getColumnCount();
//
//        for (int i = 1; i <= numColumns; ++i) {
//            System.out.printf("%-30s", rsetMD.getColumnName(i));
//        }
//        System.out.println();
//
//        while (rset.next()) {
//            for (int i = 1; i <= numColumns ; i++) {
//                System.out.printf("%-30s", rset.getString(i));
//            }
//            System.out.println();
//        }
//    }

    public void display() throws  SQLException {
        arrayListStudent();
        int num = studentList.size();

        System.out.printf("%-25s", "StudentID");
        System.out.printf("%-25s", "Student Name");
        System.out.printf("%-25s", "Address");
        System.out.printf("%-25s", "Phone");
        System.out.println();

        for (int i = 0; i < num ; i++) {
            System.out.printf("%-25s", studentList.get(i).getStudentId());
            System.out.printf("%-25s", studentList.get(i).getName());
            System.out.printf("%-25s", studentList.get(i).getAddress());
            System.out.printf("%-25s", studentList.get(i).getPhone());
            System.out.println();
        }
    }


    public void delete(Student student) {
        String strDelete = "delete from students where studentId = " + student.getStudentId();
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(strDelete);
            pstmt.executeUpdate();
            if (this.studentList.contains(student)) {
                studentList.remove(student);
                System.out.println("Xoa thanh cong!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
