import java.util.Arrays;
import java.util.Scanner;

public class PrintEveryNthElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] arr = sc.nextLine().split("[, ]+");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < arr.length; i+=n) {
            System.out.print(arr[i] + " ");
        }
    }
}
