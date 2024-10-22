package threads.task2;

public class EvenAndOddNumbersOneToTwenty {
    public static void main(String[] args) {
        Thread oddNumThread = new Thread(new OddNumbersThreadRunnable(), "ODD_NUMBER_THREAD");
        Thread evenNumThread = new Thread(new EvenNumbersThreadRunnable(), "EVEN_NUMBER_THREAD");

        oddNumThread.start();
        evenNumThread.start();
    }
}
