import java.util.Scanner;

public class SumOfEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        int sum = 0;

        for(int i = 2; i <= 2*n; i += 2)
        {
            sum += i;
        }

        System.out.println(sum);
    }
}
