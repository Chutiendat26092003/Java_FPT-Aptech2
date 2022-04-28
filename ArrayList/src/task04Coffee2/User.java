package task04Coffee2;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import Task04Coffee.Coffee;

import java.util.Objects;

public class User {
    private String idUser;
    private String nameUser;

    public User(String idUser) {
        this.idUser = idUser;
    }

    public User(String idUser, String nameUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        User other = (User) obj;
        return Objects.equals(idUser, other.idUser);
    }
}
