class TransactionTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Activity: Processing Transaction... - Execution Count: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class BalanceUpdateTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Activity: Updating Account Balance... - Execution Count: " + i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SmsNotificationTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Activity: Sending SMS Notification... - Execution Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Runnable transactionTask = new TransactionTask();
        Runnable balanceTask = new BalanceUpdateTask();
        Runnable smsTask = new SmsNotificationTask();

        Thread transactionThread = new Thread(transactionTask);
        Thread balanceThread = new Thread(balanceTask);
        Thread smsThread = new Thread(smsTask);
        
        transactionThread.setName("TransactionThread");
        balanceThread.setName("BalanceUpdateThread");
        smsThread.setName("SmsNotificationThread");

        System.out.println("--- Starting Banking Operations ---");
        transactionThread.start();
        balanceThread.start();
        smsThread.start();
    }
}