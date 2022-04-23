package ListStudentsManagerDetail;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import java.util.Objects;

public class Student {
    private String rollNo;
    private String fullName;
    private int DBO;
    private float point;

    public Student(String rollNo, String fullName, int DBO, float point) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.DBO = DBO;
        this.point = point;
    }

    public Student(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDBO() {
        return DBO;
    }

    public void setDBO(int DBO) {
        this.DBO = DBO;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo='" + rollNo + '\'' +
                ", fullName='" + fullName + '\'' +
                ", DBO=" + DBO +
                ", point=" + point +
                '}';
    }

//    @Override
//    public int compareTo(Student other) {
//        return this.rollNo.compareTo(other.rollNo);
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Student other = (Student) obj;
        return Objects.equals(rollNo, other.rollNo);
    }
}
