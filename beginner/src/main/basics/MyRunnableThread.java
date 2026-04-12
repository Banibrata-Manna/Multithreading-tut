package basics;

public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            System.out.println("On " + Thread.currentThread().getName() + " i = " + i);
        }
    }
}
