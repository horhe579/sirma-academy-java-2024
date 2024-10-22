package threads.task2;

public class EvenNumbersThreadRunnable implements Runnable{
    @Override
    public void run() {
        int evenNumberCount = 1;
        for (int i = 1; i <= 20; i++) {
            if(i%2 == 0)
            {
                System.out.println((0+1)/2);
                System.out.println("Even number " + evenNumberCount + ": " + i);
                evenNumberCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
