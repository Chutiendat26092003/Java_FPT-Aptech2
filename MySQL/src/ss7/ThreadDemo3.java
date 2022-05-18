package ss7;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

public class ThreadDemo3 extends Thread{
    public static void main(String[] args) {
        ThreadDemo3 objTh = new ThreadDemo3();
        Thread t = new Thread(objTh);
        try {
            t.start();
            System.out.println("Number of threads running: "+ Thread.activeCount());
            System.out.println("I am in the main and waiting for the thread to finish");
            objTh.join();
        }catch (InterruptedException e ) {
            System.out.println("Main thread is interrupted");
        }
    }
}
