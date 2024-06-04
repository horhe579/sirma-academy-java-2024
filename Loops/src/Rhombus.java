import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for (int i = 1; i <= n ; i++) {

            for (int k = 0; k < n-i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {

                System.out.print(" *");
            }
            System.out.println();
        }
        for (int i = n-1; i > 0 ; i--) {
            for (int k = 0; k < n-i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {

                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
