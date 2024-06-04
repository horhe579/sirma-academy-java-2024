import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> bracketIndexes = new ArrayDeque<>();
        char [] expression = sc.nextLine().toCharArray();
        long var = IntStream.range(0, expression.length).
                mapToObj(i -> expression[i]).map(String::valueOf).
                filter(c -> (c.equals("(") || c.equals(")"))).count();

        if(var%2 != 0)
        {
            System.out.println("Uneven brackets!");
            return;
        }

        for (int i = 0; i < expression.length; i++) {
            if(expression[i] == '(')
            {
                bracketIndexes.push(i);
            }
            else if(expression[i] == ')')
            {
                try {
                    for (int j = bracketIndexes.pop(); j <= i; j++) {
                        System.out.print(expression[j]);
                    }
                } catch (Exception e) {
                    System.out.println("You missed a bracket.");
                    return;
                }
                System.out.println();
            }
        }

        if(!bracketIndexes.isEmpty())
        {
            System.out.println("You missed a bracket.");
        }
    }
}
