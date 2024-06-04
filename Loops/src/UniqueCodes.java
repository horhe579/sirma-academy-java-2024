import java.util.Scanner;

public class UniqueCodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNumberLimit = Integer.parseInt(sc.nextLine());
        int secondNumberLimit = Integer.parseInt(sc.nextLine());
        int thirdNumberLimit = Integer.parseInt(sc.nextLine());
        sc.close();
        if(firstNumberLimit < 1 || firstNumberLimit > 9 || secondNumberLimit < 1 || secondNumberLimit > 9 || thirdNumberLimit < 1 || thirdNumberLimit > 9) {
            System.out.println("Limits of numbers are [1, 9]");
            return;
        }

        for(int i =1; i <= firstNumberLimit; i++)
        {
            if(i % 2 != 0) continue;
            for(int j = 1; j <= secondNumberLimit; j++)
            {
                if(!IsPrime.isPrime(j) || !(j >= 2 && j <= 7))
                {
                    continue;
                }
                for(int k = 1; k <= thirdNumberLimit; k++)
                {
                    if(k % 2 != 0) continue;
                    System.out.printf("%d %d %d%n", i, j, k);
                }
            }
        }
    }
}
