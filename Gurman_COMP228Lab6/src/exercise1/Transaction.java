package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction extends Thread implements Runnable {

    private Person person;

    public Transaction(Person p) {
        this.person = p;
    }

    public static void main(String[] args) {

        Transaction ts1 = new Transaction(new Person("John"));
        ts1.start();
        Transaction ts2 = new Transaction(new Person("Rose"));
        ts2.start();
        Transaction ts3 = new Transaction(new Person("Harper"));
        ts3.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Account acc = Account.getAccount(person);
                acc.withdraw(100);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (acc.getBal() < 0) {
                    System.out.println("account is overdrawn!");
                }
                acc.deposit(200);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Final Acc balance of " + person.getName() + " is Rs." + Account.getBal());
    }
}
