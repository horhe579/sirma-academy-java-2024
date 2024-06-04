import java.util.Scanner;

public class NToZeroReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for (int i = n; i > 0; i--)
        {
            System.out.println(i);
        }
    }
}
