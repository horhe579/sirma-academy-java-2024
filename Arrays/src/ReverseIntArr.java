import java.util.Arrays;
import java.util.Scanner;

public class ReverseIntArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [] reversedArr = new int [n];
        for (int i = 0; i < n; i++) {
            reversedArr[i] = arr[n-i-1];
        }

        System.out.println(Arrays.toString(reversedArr));
    }
}
