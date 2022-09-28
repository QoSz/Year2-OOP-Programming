public class Philosopher implements Runnable {
    private Fork leftFork;
    private Fork rightFork;
    private int philosopherNumber;
    private Object lock; // The lock to use for synchronization

    // Passing the lock object to the constructor
    public Philosopher(Fork left, Fork right, int philNumber, Object lock) {
        leftFork = left;
        rightFork = right;
        philosopherNumber = philNumber;
        this.lock = lock;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println("Philosopher number " + philosopherNumber + " time: " + System.nanoTime() + ": " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void run() {
        try {
            while (true) {

                // thinking
                doAction("Thinking");
                // using the synchronized block with the lock object
                // to synchronize access to the forks
                // once a philosopher has acquired the left fork it means that is has also
                // locked the right fork automatically
                // therefore, the philosopher can eat.
                // Once the philosopher has finished eating, it releases the forks and goes back
                // to thinking.
                synchronized (lock) {
                    leftFork.inUse = true;
                    doAction("Picking up left fork");
                    synchronized (rightFork) {
                        // eating
                        rightFork.inUse = true;
                        doAction("Picking up right fork");
                        doAction("Eating");
                        doAction("Putting down right fork");
                        rightFork.inUse = false;
                    }
                    // Back to thinking
                    doAction("Putting down left fork");
                    leftFork.inUse = false;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
