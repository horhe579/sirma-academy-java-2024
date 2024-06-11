import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numbers = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();


    }
}
