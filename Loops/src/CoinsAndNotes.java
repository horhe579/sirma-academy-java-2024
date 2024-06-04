import java.util.Scanner;

public class CoinsAndNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oneCount = Integer.parseInt(sc.nextLine());
        int twoCount = Integer.parseInt(sc.nextLine());
        int fiveCount = Integer.parseInt(sc.nextLine());
        int sum = Integer.parseInt(sc.nextLine());
        sc.close();

        for (int i = 0; i <= oneCount; i++) {
            for (int j = 0; j <= twoCount; j++) {
                for (int k = 0; k <= fiveCount; k++) {
                    if (i + 2 * j + 5 * k == sum) {
                        System.out.printf("%d*1 lv. + %d*2 lv. + %d*5 lv. = %d lv.%n", i, j, k, sum);
                    }
                }
            }
        }
    }
}
