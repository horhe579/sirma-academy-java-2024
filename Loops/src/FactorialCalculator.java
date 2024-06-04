import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();
        int factorial = 1;

        for(int i = n; i > 0; i--)
        {
            factorial *= i;
        }
        System.out.println(factorial);
    }
}
