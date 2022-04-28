package Task04Coffee;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/


import java.util.Objects;

public class Coffee {
    private String idCoffee;
    private String nameCoffee;
    private char sizeCoffee;
    private float priceCoffee;


    public Coffee(String idCoffee) {
        this.idCoffee = idCoffee;
    }


    public Coffee(String idCoffee, String nameCoffee, char sizeCoffee, float priceCoffee) {
        this.idCoffee = idCoffee;
        this.nameCoffee = nameCoffee;
        this.sizeCoffee = sizeCoffee;
        this.priceCoffee = priceCoffee;
    }

    public String getIdCoffee() {
        return idCoffee;
    }

    public void setIdCoffee(String idCoffee) {
        this.idCoffee = idCoffee;
    }

    public String getNameCoffee() {
        return nameCoffee;
    }

    public void setNameCoffee(String nameCoffee) {
        this.nameCoffee = nameCoffee;
    }

    public char getSizeCoffee() {
        return sizeCoffee;
    }

    public void setSizeCoffee(char sizeCoffee) {
        this.sizeCoffee = sizeCoffee;
    }

    public float getPriceCoffee() {
        return priceCoffee;
    }

    public void setPriceCoffee(float priceCoffee) {
        this.priceCoffee = priceCoffee;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "idCoffee='" + idCoffee + '\'' +
                ", nameCoffee='" + nameCoffee + '\'' +
                ", sizeCoffee=" + sizeCoffee +
                ", priceCoffee=" + priceCoffee +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Coffee other = (Coffee) obj;
        return Objects.equals(idCoffee, other.idCoffee);
    }
}
