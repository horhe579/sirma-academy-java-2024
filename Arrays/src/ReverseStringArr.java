import java.util.Arrays;
import java.util.Scanner;

public class ReverseStringArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] arr = sc.nextLine().split("[, ]+");
        String [] copy = Arrays.copyOf(arr, arr.length);
        //a b c d e
        //0 1 2 3 4

        for (int i = 0; i < arr.length; i++) {
            arr[i] = copy[arr.length-i-1];
        }

        System.out.println(Arrays.toString(arr));

    }
}
