import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] arr = sc.nextLine().split("[, ]+");
        String [] clone = Arrays.copyOf(arr, arr.length);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= arr.length-1; j++) {
                clone[j] = arr[j-1];
            }
            clone[0] = arr[arr.length-1];
            arr = Arrays.copyOf(clone, clone.length);
        }
        System.out.println(Arrays.toString(clone));
    }
}
