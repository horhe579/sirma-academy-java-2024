import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double change = Double.parseDouble(sc.nextLine());
        sc.close();
        int [] coins = {200, 100, 50, 20, 10, 5, 2, 1};

        int stotinki = (int)(change * 100);
        int totalCoins = 0;

        for (int i = 0; i < coins.length; i++) {
            totalCoins += stotinki / coins[i];
            stotinki %= coins[i];
            if (stotinki == 0)
                break;
        }
        System.out.println(totalCoins);
        System.out.println(IsPrime.isPrime(1));
    }
}
