import java.util.Scanner;

public class OneToNThroughM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        sc.close();

        for(int i = 1; i <= n; i += m) {
            System.out.println(i);
        }
    }
}
