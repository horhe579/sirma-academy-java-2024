import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class AsciiSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char firstChar = sc.nextLine().charAt(0);
        char secondChar = sc.nextLine().charAt(0);
        String randomString = sc.nextLine();

//        int sum = 0;
//
//        for (char c : randomString.toCharArray()) {
//            sum += (c > firstChar && c < secondChar) ? c : 0;
//        }
//        System.out.println(sum);

        System.out.println(randomString.chars().filter(c -> (c > firstChar && c < secondChar)).reduce(0, (a, b) -> a + b));

    }
}
