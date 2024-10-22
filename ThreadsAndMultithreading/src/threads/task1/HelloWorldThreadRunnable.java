package threads.task1;

public class HelloWorldThreadRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello, World!");
    }
}
