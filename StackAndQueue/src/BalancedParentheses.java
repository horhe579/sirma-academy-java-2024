import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] input = sc.nextLine().split("");
        ArrayDeque<String> parentheses = new ArrayDeque<>();
        // {[()]}

        for(String s : input)
        {
            switch (s)
            {
                case ")":
                    if(((int) parentheses.pop().charAt(0) + 1) != (int)s.charAt(0))
                    {
                        System.out.println("False");
                        return;
                    }
                    break;
                case "}":
                case "]":
                    if(((int) parentheses.pop().charAt(0) + 2) != (int)s.charAt(0))
                    {
                        System.out.println("False");
                        return;
                    }
                    break;
                case "{":
                case "[":
                case "(":
                    parentheses.push(s);
                    break;
                default:
                    System.out.println("invalid input");
                    return;
            }

        }
        System.out.println(true);
    }
}
