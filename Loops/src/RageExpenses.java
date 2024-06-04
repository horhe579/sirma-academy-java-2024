import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lostGames = Integer.parseInt(sc.nextLine());
        double headsetPrice = Double.parseDouble(sc.nextLine());
        double mousePrice = Double.parseDouble(sc.nextLine());
        double keyboardPrice = Double.parseDouble(sc.nextLine());
        double displayPrice = Double.parseDouble(sc.nextLine());
        sc.close();
        double expenses = 0;

        expenses = headsetPrice * (lostGames / 2) + mousePrice * (lostGames / 3) + keyboardPrice * (lostGames / 6) + displayPrice * (lostGames / 12);

        System.out.println(expenses);
    }


}
