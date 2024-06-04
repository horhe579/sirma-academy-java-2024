import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(!(n >= 1 && n<= Math.pow(10, 5)))
        {
            n = Integer.parseInt(sc.nextLine());
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String [] command = sc.nextLine().split("[ ]+");
            switch (command[0].trim())
            {
                case "1":
                    try {
                        if(!(Integer.parseInt(command[1]) >= 1 && Integer.parseInt(command[1])<= Math.pow(10, 9)))
                        {
                            System.out.println("Numbers should be in range.");
                            return;
                        }
                        stack.push(Integer.parseInt(command[1]));
                        break;
                    }
                    catch ( Exception e)
                    {
                        System.out.println("An error has occurred.");
                        return;
                    }
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
