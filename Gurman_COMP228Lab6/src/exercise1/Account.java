package exercise1;

public class Account {
    public static Account account;
    private static int balance = 1000;
    private static Person person;

    private Account() {
    }

    public static Account getAccount(Person p) {
        if (account == null) {
            account = new Account();
        }
        Account.person = p;
        return account;
    }

    public static int getBal() {
        return balance;
    }

    public synchronized void withdraw(int bal) {
        try {

            if (balance >= bal) {
                System.out.println(person.getName() + " " + "is trying to withdraw");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance - bal;
                System.out.println(person.getName() + " " + "completed the withdraw");
            } else {
                System.out.println(person.getName() + " " + "doesn't have enough money to withdraw ");
            }
            System.out.println(person.getName() + " " + " withdrew Rs" + bal + " Current balance: Rs"+ balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void deposit(int bal) {
        try {
            if (bal > 0) {
                System.out.println(person.getName() + " " + " is tryig to deposit");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance = balance + bal;
                System.out.println(person.getName() + " " + " completed the deposit");
            } else {
                System.out.println(person.getName() + " " + "doesn't have enough money to deposit");
            }
            System.out.println(person.getName() + " " + " deposited Rs" + bal + " Current balance: Rs" + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}