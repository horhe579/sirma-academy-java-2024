import java.util.Scanner;

public class SquareOfAsterisks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        sc.close();

        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < x; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
