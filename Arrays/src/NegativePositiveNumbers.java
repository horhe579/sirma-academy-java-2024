import java.util.Arrays;
import java.util.Scanner;

public class NegativePositiveNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();
        StringBuilder newSequence = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 0)
            {
                newSequence.append(arr[i] + " ");
            }
            else {
                newSequence.insert(0,arr[i] + " ");
            }
        }
        arr = Arrays.stream(newSequence.toString().split("[ ]+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(arr));
    }
}
