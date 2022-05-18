package ss7;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

public class ThreadDemo extends  Thread{
    public static void main(String[] args) {
        ThreadDemo Obj = new ThreadDemo();
        Thread t = new Thread(Obj);
        System.out.println("The thread is alive: " + t.isAlive());
    }
}
