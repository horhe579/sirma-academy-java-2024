import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class SumOfFirstAndLastElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(arr[0] + arr[arr.length-1]);
    }
}
