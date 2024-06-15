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
        //System.out.println(text.replaceAll("(.)\\1+", "$1"));

        StringBuilder newText = new StringBuilder(text.length());
        char currentChar = text.charAt(0);
        newText.append(currentChar);

        for (int i = 1; i < text.length(); i++) {
            if(currentChar == text.charAt(i))
            {
                continue;
            }
            newText.append(text.charAt(i));
            currentChar = text.charAt(i);
        }
        System.out.println(newText.toString());
    }
}
