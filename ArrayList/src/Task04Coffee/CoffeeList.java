package Task04Coffee;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/


import java.util.ArrayList;

public class CoffeeList {
    private ArrayList<Coffee> coffees;

    public CoffeeList(ArrayList<Coffee> coffees) {
        this.coffees = coffees;
    }

    public CoffeeList() {
        this.coffees = new ArrayList<Coffee>();
    }

    public void addCoffeeList(Coffee coffee) {
        this.coffees.add(coffee);
    }

    public void removeCoffeeList(Coffee coffee) {
        if (this.coffees.contains(coffee)) {
            this.coffees.remove(coffee);
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Khong ton tai!!!");
        }
    }

    public void updateCoffeeList(Coffee oldCoffee, Coffee newCoffee){
        for (Coffee c: coffees) {
            if (c.getIdCoffee().indexOf(oldCoffee.getIdCoffee()) >= 0) {
                System.out.println(c);
                c.setIdCoffee(newCoffee.getIdCoffee());
                c.setNameCoffee(newCoffee.getNameCoffee());
                c.setSizeCoffee(newCoffee.getSizeCoffee());
                c.setPriceCoffee(newCoffee.getPriceCoffee());
                System.out.println(" --> ");
                System.out.println(c);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }

    public void searchIdCoffeeList(Coffee coffee){
        for (Coffee c: coffees) {
            if (c.getIdCoffee().indexOf(coffee.getIdCoffee()) >= 0) {
                System.out.println(c);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }

    public void searchNameCoffeeList(String nameCoffee){
        for (Coffee c: coffees) {
            if (c.getNameCoffee().indexOf(nameCoffee) >= 0) {
                System.out.println(c);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }

    public void printCoffeeList() {
        for (Coffee c: coffees) {
            System.out.println(c);
        }
    }
}
