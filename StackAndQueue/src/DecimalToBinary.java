import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimalNumber = 0;
        try {
            decimalNumber = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Integers only");
            return;
        }
        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();
        while(decimalNumber != 0)
        {
            binaryRepresentation.push(decimalNumber%2);
            decimalNumber /= 2;
        }
        System.out.println(binaryRepresentation);
        binaryRepresentation.stream().forEach(System.out::print);
    }
}
