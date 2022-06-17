package concurrency.lifecycle;

public class BLOCKED {
    private static class SyncCode implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is in run() method");
            syncMethod();
        }

        public static synchronized void syncMethod() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is in syncMethod() method");

            while (true) {
                // t1 stays here forever, therefore t2 is blocked
            }
        }
    }

    public void blockedThread() throws InterruptedException {

        Thread t1 = new Thread(new SyncCode());
        Thread t2 = new Thread(new SyncCode());

        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);

        System.out.println("t1: " + t1.getState());
        System.out.println("t2: " + t2.getState());

        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {

        BLOCKED state = new BLOCKED();
        state.blockedThread();
    }
}
