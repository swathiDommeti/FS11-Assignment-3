class Counter {
    private int count = 0;

    // Synchronized method to increment count
    public synchronized void increment() {
        count++;
    }

    // Synchronized method to decrement count
    public synchronized void decrement() {
        count--;
    }

    // Method to get the current count value
    public synchronized int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        IncrementThread incrementThread = new IncrementThread(counter);
        DecrementThread decrementThread = new DecrementThread(counter);

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        // Output the final count
        System.out.println("Final count: " + counter.getCount());
    }
}