class TrafficJunction extends Thread {
    String trafficStatus;
    int sleepDuration;

    TrafficJunction(String trafficStatus, int sleepDuration) {
        this.trafficStatus = trafficStatus;
        this.sleepDuration = sleepDuration;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " - Traffic Status: " + trafficStatus + " (Report " + i + ")");
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class TrafficManagement {
    public static void main(String[] args) {
        TrafficJunction junction1 = new TrafficJunction("Heavy congestion", 1000);
        TrafficJunction junction2 = new TrafficJunction("Moderate flow", 1500);
        TrafficJunction junction3 = new TrafficJunction("Clear roads", 2000);

        junction1.setName("North Junction");
        junction2.setName("East Junction");
        junction3.setName("South Junction");

        junction1.start();
        junction2.start();
        junction3.start();
    }
}