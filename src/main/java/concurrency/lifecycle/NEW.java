package concurrency.lifecycle;

public class NEW {

    public void newThread() {
        Thread t = new Thread(() -> { });
        System.out.println(t.getState());
    }

    public static void main(String[] args) {

        NEW state = new NEW();
        state.newThread();
    }
}
