package threads.task2;

public class OddNumbersThreadRunnable implements Runnable{
    @Override
    public void run() {
        int oddNumberCount = 1;
        for (int i = 1; i <= 20; i++) {
            if(i%2 != 0)
            {
                System.out.println("Odd number " + oddNumberCount + ": " + i);
                oddNumberCount++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
