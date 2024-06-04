import java.util.Scanner;

public class UpTo1000EndingInN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for (int i = n; i <= 1000; i += 10) {
            System.out.println(i);
        }
    }
}
