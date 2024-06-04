import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String [] expression = sc.nextLine().split("[ ]+");
        String operation = "+";
        for(String s : expression)
        {
            if(s.equals("-"))
            {
                operation = "-";
            }
            else if(s.equals("+")) {
                operation = "+";
            }
            else
            {
                try
                {
                    int num = Integer.parseInt(s);
                    numbers.push( (operation.equals("-")) ? -num : num );
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Integers only");
                    return;
                }
            }
        }

        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
