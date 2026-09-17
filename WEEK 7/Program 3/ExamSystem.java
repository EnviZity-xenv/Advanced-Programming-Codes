class TimeDisplayTask implements Runnable {
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println(Thread.currentThread().getName() + ": Displaying remaining time - " + i + " minutes");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class AutoSaveTask implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": Auto-saving student's answers...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class NetworkCheckTask implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": Checking network connection...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class ExamSystem {
    public static void main(String[] args) {
        Thread timeThread = new Thread(new TimeDisplayTask());
        timeThread.setName("TimerThread");

        Thread saveThread = new Thread(new AutoSaveTask());
        saveThread.setName("AutoSaveThread");

        Thread networkThread = new Thread(new NetworkCheckTask());
        networkThread.setName("NetworkMonitorThread");

        timeThread.start();
        saveThread.start();
        networkThread.start();
    }
}