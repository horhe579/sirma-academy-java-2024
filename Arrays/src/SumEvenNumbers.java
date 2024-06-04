import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.stream(arr)
                .filter(d -> d%2==0)
                .sum());
    }
}
