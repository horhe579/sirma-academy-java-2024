import java.util.Scanner;

public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int magicNum = Integer.parseInt(sc.nextLine());
        int flag = 0;
        int n = 0;
        sc.close();

        for (int i = first; i <= second; i++)
        {
            for (int j = first; j <= second; j++)
            {
                if(flag == 1)
                {
                    break;
                }
                n++;
                if(i + j == magicNum)
                {
                    flag = 1;
                    System.out.printf("Combination %d - (%d + %d = %d)",n, i, j, magicNum);
                }
            }
        }
        if(flag == 0)
        {
            System.out.printf("%d combinations - neither equals %d", n, magicNum);
        }
    }
}
