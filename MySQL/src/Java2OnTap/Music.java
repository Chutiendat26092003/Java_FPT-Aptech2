package Java2OnTap;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

import java.util.Objects;

public class Music {
    private String id;
    private String name;
    private String author;
    private String year;

    public Music(String id, String name, String author, String year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Music(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Music other = (Music) obj;
        return Objects.equals(id, other.id);
    }
}
