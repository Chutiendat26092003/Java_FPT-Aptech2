package task04Coffee2;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/

import Task04Coffee.Coffee;

import java.util.Objects;

public class Order {
    private String idProductOrder;
    private String nameProductOrder;
    private double priceProductOrder;
    int qtyProductOrder=1;
    double totalOrder=0;

    public Order(String idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    public Order(String idProductOrder, String nameProductOrder, double priceProductOrder, int qtyProductOrder) {
        this.idProductOrder = idProductOrder;
        this.nameProductOrder = nameProductOrder;
        this.priceProductOrder = priceProductOrder;
        this.qtyProductOrder = qtyProductOrder;
    }

    public String getIdProductOrder() {
        return idProductOrder;
    }

    public void setIdProductOrder(String idProductOrder) {
        this.idProductOrder = idProductOrder;
    }

    public String getNameProductOrder() {
        return nameProductOrder;
    }

    public void setNameProductOrder(String nameProductOrder) {
        this.nameProductOrder = nameProductOrder;
    }

    public double getPriceProductOrder() {
        return priceProductOrder;
    }

    public void setPriceProductOrder(double priceProductOrder) {
        this.priceProductOrder = priceProductOrder;
    }

    public int getQtyProductOrder() {
        return qtyProductOrder;
    }

    public void setQtyProductOrder(int qtyProductOrder) {
        this.qtyProductOrder = qtyProductOrder;
    }

    public double getTotalOrder() {
        totalOrder = priceProductOrder * qtyProductOrder;
        return totalOrder;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idProductOrder='" + idProductOrder + '\'' +
                ", nameProductOrder='" + nameProductOrder + '\'' +
                ", priceProductOrder=" + priceProductOrder +
                ", qtyProductOrder=" + qtyProductOrder +
                ", totalOrder=" + getTotalOrder() + "VND" +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Order other = (Order) obj;
        return Objects.equals(idProductOrder, other.idProductOrder);
    }
}
