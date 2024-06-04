import java.util.Scanner;

public class EqualSumOfOddAndEvenPositions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        sc.close();
        equalSumOfOddAndEvenPositions(n, m);

    }

    public static void equalSumOfOddAndEvenPositions(int n, int m) {
        for (int i = n; i <= m ; i++) {
            int oddSum = 0;
            int evenSum = 0;
            String number = Integer.toString(i);
            for (int j = 0; j < number.length(); j++) {
                int digit = Character.getNumericValue(number.charAt(j));
                if(j % 2 == 0)
                {
                    evenSum += digit;
                }
                else
                {
                    oddSum += digit;
                }
            }
            if(oddSum == evenSum)
            {
                System.out.println(i);
            }
        }
    }
}
