package ss7;

/* 
    @author: chu tien dat

    Project Name: MySQL
*/

public class Account {
    double balance = 200.0;

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void displayBalance() {
        System.out.println("Balance is: " + balance);
    }
}
class Transaction implements Runnable {
    double amount;
    Account account;
    Thread t;

    public Transaction(double amount, Account account) {
        this.amount = amount;
        this.account = account;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (account) {
            account.deposit(amount);
            account.displayBalance();
        }
    }
}

class DepositAmount {
    public static void main(String[] args) {
        Account accObj = new Account();
        Transaction t1 = new Transaction(500.00, accObj);
        Transaction t2 = new Transaction(200.00, accObj);
    }
}
