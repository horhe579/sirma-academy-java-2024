import java.util.Scanner;

public class CollatzConjecture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(n + " ");
        while(n != 1)
        {
            if(n%2 == 0)
            {
                n /= 2;
                System.out.println(n);
            }
            else
            {
                n = n*3 + 1;
                System.out.println(n);
            }
        }
    }
}
