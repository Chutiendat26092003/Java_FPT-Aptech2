package task04Coffee2;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import Task04Coffee.Coffee;

import java.util.Objects;

public class Menu {
    private String idProduct;
    private String nameProduct;
    private double priceProduct;

    public Menu(String idProduct) {
        this.idProduct = idProduct;
    }

    public Menu(String idProduct, String nameProduct, double priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Menu other = (Menu) obj;
        return Objects.equals(idProduct, other.idProduct);
    }
}
