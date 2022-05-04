package task04Coffee2;

/* 
    @author: chu tien dat

    Project Name: ArrayList
*/


import java.util.ArrayList;

public class Cafe {
    private ArrayList<Menu> menuArrayList;
    private ArrayList<User> userArrayList;
    private ArrayList<Order> orderArrayList;

    public Cafe(ArrayList<Menu> menuArrayList, ArrayList<User> userArrayList, ArrayList<Order> orderArrayList) {
        this.menuArrayList = menuArrayList;
        this.userArrayList = userArrayList;
        this.orderArrayList = orderArrayList;
    }

    public Cafe(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public Cafe(ArrayList<Menu> menuArrayList, ArrayList<User> userArrayList) {
        this.menuArrayList = menuArrayList;
        this.userArrayList = userArrayList;
    }
    public Cafe() {
        this.menuArrayList = new ArrayList<Menu>();
        this.userArrayList = new ArrayList<User>();
        this.orderArrayList = new ArrayList<Order>();
    }

    public ArrayList<Menu> getMenuArrayList() {
        return menuArrayList;
    }
    public void setMenuArrayList(ArrayList<Menu> menuArrayList) {
        this.menuArrayList = menuArrayList;
    }
    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }
    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }
    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }
    public void setOrderArrayList(ArrayList<Order> orderArrayList) {
        this.orderArrayList = orderArrayList;
    }

    public double getTotal() {
        double result=0;
        for (Order order: orderArrayList) {
            result+=order.getTotalOrder();
        }
        return result;
    }

    //add
    public void addNewMenu(Menu menu) {
        this.menuArrayList.add(menu);
    }
    public void addNewUser(User user) {
        this.userArrayList.add(user);
    }
    public void addOrder(Menu menu, int qtyProductOrder) {
        for (Menu m: menuArrayList) {
            if (m.getIdProduct().indexOf(menu.getIdProduct()) >= 0) {
                String idProductOrder = m.getIdProduct();
                String nameProductOrder = m.getNameProduct();
                double priceProductOrder = m.getPriceProduct();
                Order order = new Order(idProductOrder,nameProductOrder,priceProductOrder,qtyProductOrder);
                this.orderArrayList.add(order);
                System.out.println("Thanh cong");
            } else {
                System.out.println("Khong ton tai!!! 1");
            }
        }
    }


    //remove
    public void removeMenuList(Menu menu) {
        if (this.menuArrayList.contains(menu)) {
            this.menuArrayList.remove(menu);
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Khong ton tai!!!");
        }
    }
    public void removeUserList(User user) {
        if (this.userArrayList.contains(user)) {
            this.userArrayList.remove(user);
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Khong ton tai!!!");
        }
    }
    public void removeOrderList(Order order) {
        if (this.orderArrayList.contains(order)) {
            this.orderArrayList.remove(order);
            System.out.println("Xoa thanh cong!!!");
        } else {
            System.out.println("Khong ton tai!!!");
        }
    }

    //update
    public void updateMenuList(Menu oldMenu, Menu newMenu){
        for (Menu menu: menuArrayList) {
            if (menu.getIdProduct().indexOf(oldMenu.getIdProduct()) >= 0) {
                System.out.println(menu);
                menu.setIdProduct(newMenu.getIdProduct());
                menu.setNameProduct(newMenu.getNameProduct());
                menu.setPriceProduct(newMenu.getPriceProduct());
                System.out.println(" --> ");
                System.out.println(menu);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }
    public void updateUserList(User oldUser, User newUser){
        for (User user: userArrayList) {
            if (user.getIdUser().indexOf(oldUser.getIdUser()) >= 0) {
                System.out.println(user);
                user.setIdUser(newUser.getIdUser());
                user.setNameUser(newUser.getNameUser());
                System.out.println(" --> ");
                System.out.println(user);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }

    //search
    public void searchIdMenuList(Menu menu){
        for (Menu m: menuArrayList) {
            if (m.getIdProduct().indexOf(menu.getIdProduct()) >= 0) {
                System.out.println(m);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }
    public void searchIdUserList(User user){
        for (User u: userArrayList) {
            if (u.getIdUser().indexOf(user.getIdUser()) >= 0) {
                System.out.println(u);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }

    public void searchNameMenuList(String nameProductMenu){
        for (Menu m: menuArrayList) {
            if (m.getIdProduct().indexOf(nameProductMenu) >= 0) {
                System.out.println(m);
            } else {
                System.out.println("Khong ton tai!!!");
            }
        }
    }

    //print
    public void printMenuList() {
        for (Menu menu: menuArrayList) {
            System.out.println(menu);
        }
    }
    public void printUserList() {
        for (User user: userArrayList) {
            System.out.println(user);
        }
    }
    public void printOrderList() {
        for (Order order: orderArrayList) {
            System.out.println(order);
        }
        System.out.println("Tong hoa don:" + getTotal() + "VND");
    }

}
