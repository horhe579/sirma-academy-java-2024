import java.util.Scanner;

public class PseudoFibonacciSequenceSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
        int next = 1;
        int current = 1;
        int prev = 0;
        int sum = 1;

        for(int i = 1; i < n ; i++)
        {
            prev = current;
            current = next;
            next = prev + current;
            sum = sum +  current;
        }

        System.out.println(sum);
    }
}
