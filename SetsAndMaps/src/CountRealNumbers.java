import java.util.*;


public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] numbers = sc.nextLine().split("[, ]+");
        Map<String, Integer> realNumbersCount = new LinkedHashMap<>();

        for(String number : numbers)
        {
            realNumbersCount.put(number, realNumbersCount.getOrDefault(number, 0) + 1);
        }

        for(var set : realNumbersCount.entrySet())
        {
            System.out.println(STR."\{set.getKey()} -> \{set.getValue()}");
        }
    }
}
