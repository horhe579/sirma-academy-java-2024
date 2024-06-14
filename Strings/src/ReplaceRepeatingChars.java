import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceRepeatingChars {

     private static Set<Character> memo = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char c = text.charAt(0);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < text.length(); i++) {
            if(memo.contains(text.charAt(i)))
            {
                continue;
            }
            String regex = STR."[\{text.charAt(i)}]{2,}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            text = matcher.replaceAll(STR."\{text.charAt(i)}");
            memo.add(text.charAt(i));
        }
        System.out.println(text);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime);
        //System.out.println(newText);
    }
}
