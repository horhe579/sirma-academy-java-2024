import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(true)
        {
            n = Integer.parseInt(sc.nextLine());
            if(n >= 1 && n <= 100)
            {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
