package threads.task1;

public class HelloWorldThread {
    public static void main(String[] args) {
        Thread myHelloWorldThread = new Thread(new HelloWorldThreadRunnable(), "HELLO_WORLD_THREAD");

        myHelloWorldThread.start();
    }
}
