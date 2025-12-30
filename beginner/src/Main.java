import basics.MyFirstThread;
import basics.MyRunnableThread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to the main thread!");

        MyFirstThread myFirstThread = new MyFirstThread();
        myFirstThread.start();

        new Thread(new MyRunnableThread()).start();

        for (int i = 1; i <= 10000; i++) {
            System.out.println("On " + Thread.currentThread().getName() + " i = " + i);
        }
    }
}