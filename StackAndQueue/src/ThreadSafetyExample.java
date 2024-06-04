import Classes.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSafetyExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Create multiple threads to deposit money
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    account.deposit(1);
                }
            });
        }

        // Create multiple threads to withdraw money
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    account.withdraw(1);
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        // Print the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}
