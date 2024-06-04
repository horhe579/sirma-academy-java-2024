import java.util.HashMap;
import java.util.Map;

public class RecursiveFibonacci {

    private static Map<Integer, Long> memo = new HashMap<>();

    public static long getFibonacci(int n)
    {
        switch (n)
        {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                if(memo.containsKey(n))
                {
                    return  memo.get(n);
                }
                long result =  (getFibonacci(n-1) + getFibonacci(n-2));
                memo.put(n, result);
                return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(getFibonacci(50));
    }
}
