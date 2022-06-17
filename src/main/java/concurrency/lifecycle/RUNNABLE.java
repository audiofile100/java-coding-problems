package concurrency.lifecycle;

public class RUNNABLE {

    public void runnableThread() {

        Thread t = new Thread(() -> { });
        t.start();

        System.out.println(t.getState());
    }

    public static void main(String[] args) {

        RUNNABLE state = new RUNNABLE();
        state.runnableThread();
    }
}
