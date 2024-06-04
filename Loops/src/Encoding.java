import java.util.Scanner;

public class Encoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        for (int j = String.valueOf(n).length()-1; j >= 0; j--) {
            for (int k = 0; k < Character.getNumericValue(String.valueOf(n).charAt(j)); k++) {
                System.out.print((char) (Character.getNumericValue(String.valueOf(n).charAt(j)) + 33));
            }
            System.out.println();
        }
    }
}
