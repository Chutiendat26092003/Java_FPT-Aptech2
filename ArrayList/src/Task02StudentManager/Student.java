package Task02StudentManager;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import java.util.Date;

public class Student {
    private int rollNo;
    private String fullName;
    private Date DBO;
    private String  address;
    private char status;

    public Student(int rollNo, String fullName, Date DBO, String address, char status) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.DBO = DBO;
        this.address = address;
        this.status = status;
    }


    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDBO() {
        return DBO;
    }

    public void setDBO(Date DBO) {
        this.DBO = DBO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", fullName='" + fullName + '\'' +
                ", DBO=" + DBO +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
