package giftmodel;

/* 
    @author: chu tien dat

    Project Name: giftshop
*/

public class Gift {
    private int id;
    private String name;
    private float price;
    private int qty;

    public Gift(int id) {
        this.id = id;
    }

    public Gift(int id, String name, float price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
