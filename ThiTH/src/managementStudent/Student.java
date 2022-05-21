package managementStudent;

/* 
    @author: chu tien dat

    Project Name: ThiTH
*/

import java.util.Objects;

public class Student {
    private String studentId;
    private String name;
    private String Address;
    private String phone;

    public Student(String studentId, String name, String address, String phone) {
        this.studentId = studentId;
        this.name = name;
        Address = address;
        this.phone = phone;
    }

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Student other = (Student) obj;
        return Objects.equals(studentId, other.studentId);
    }
}
