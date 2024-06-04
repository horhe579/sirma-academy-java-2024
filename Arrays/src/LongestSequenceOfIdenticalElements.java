import java.util.Arrays;
import java.util.Scanner;

public class LongestSequenceOfIdenticalElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        int maxSequenceLength = 1;
        int currentSequenceLength = 1;
        int startIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currentSequenceLength++;
            } else {
                currentSequenceLength = 1;
            }
            if (currentSequenceLength >= maxSequenceLength) {
                maxSequenceLength = currentSequenceLength;
                startIndex = i + 1 - maxSequenceLength;
            }
        }

        for (int i = startIndex; i < startIndex + maxSequenceLength; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
