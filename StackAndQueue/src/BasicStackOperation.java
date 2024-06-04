import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n s x
        int [] constants = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < constants[0]; i++) {
            stack.push(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < constants[1]; i++) {
            stack.pop();
        }
        System.out.println( (stack.contains(constants[2])) ? "true" : STR."\{getSmallestStackElement(stack)}" );
    }

    public static int getSmallestStackElement(ArrayDeque<Integer> stack)
    {
        if(stack.size() == 0)
        {
            return 0;
        }
        int min = stack.getFirst();
        for(Integer num : stack)
        {
            if(num < min)
            {
                min = num;
            }

        }
        return min;
    }
}
