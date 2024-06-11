import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        TreeMap<Character, Integer> symbolCount = new TreeMap<>();
        CountAndPrintSymbols(text, symbolCount);
    }

    public static void CountAndPrintSymbols(String text, TreeMap<Character, Integer> symbolCount)
    {
        for(Character c : text.toCharArray())
        {
            symbolCount.put(c, symbolCount.getOrDefault(c, 0) + 1);
        }
        for(var c : symbolCount.entrySet())
        {
            System.out.println(STR."\{c.getKey()}: \{c.getValue()}");
        }
    }
}
