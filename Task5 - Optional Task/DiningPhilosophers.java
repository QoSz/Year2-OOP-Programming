
public class DiningPhilosophers {

    // Main methos changes for optional task.
    // A lock object is used to synchronize access to the forks.
    // Once a philosopher has acquired the left fork it means that is has also
    // locked the right fork automatically
    // therefore, the philosopher can eat.
    // Once the philosopher has finished eating, it releases the forks and goes back
    // to thinking.
    // The philosophers will never starve.
    // As each philsopher will get a chance to eat.
    public static void main(String[] args) {
        Object lock = new Object(); // The lock to use for synchronization
        final int problemSize = 5;
        Fork leftFork;
        Fork rightFork;

        Philosopher[] philosophers = new Philosopher[problemSize];
        Fork[] forks = new Fork[problemSize];

        for (int i = 0; i < problemSize; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < problemSize; i++) {
            leftFork = forks[i];
            rightFork = forks[(i + 1) % problemSize];
            philosophers[i] = new Philosopher(leftFork, rightFork, i + 1, lock);
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }

    // public static void main(String[] args) throws Exception {
    //
    // final int problemSize = 5;
    // Fork leftFork;
    // Fork rightFork;
    //
    // Philosopher[] philosophers = new Philosopher[problemSize];
    // Fork[] forks = new Fork[problemSize];
    //
    // for (int i = 0; i < problemSize; i++) {
    // forks[i] = new Fork();
    // }
    //
    // for (int i = 0; i < problemSize; i++) {
    // leftFork = forks[i];
    // rightFork = forks[(i + 1) % problemSize];
    //
    // if (i == philosophers.length - 1) {
    // philosophers[i] = new Philosopher(rightFork, leftFork, i + 1);
    // } else {
    // philosophers[i] = new Philosopher(leftFork, rightFork, i + 1);
    // }
    //
    // // philosophers[i] = new Philosopher(leftFork, rightFork, i + 1);
    //
    // Thread t = new Thread(philosophers[i]);
    // t.start();
    // }
    // }
}
