import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i == 0 && j == 0 || i == 0 && j == n - 1 || i == n - 1 && j == 0 || i == n - 1 && j == n - 1)
                {
                    System.out.print(" + ");
                }
                else if(i != 0 && (j == 0 || j == n - 1))
                {
                    System.out.print(" | ");
                }
                else
                {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
