import java.util.Scanner;

public class OneToNThroughTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for(int i = 1; i <= n; i += 2) {
            System.out.println(i);
        }
    }
}
