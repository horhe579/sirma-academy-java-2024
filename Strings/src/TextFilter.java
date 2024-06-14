import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String [] forbiddenWords = sc.nextLine().split("[, ]+");
        String text = sc.nextLine();
        Pattern pattern;
        Matcher matcher;

        for (String forbiddenWord : forbiddenWords)
        {
            pattern = Pattern.compile(forbiddenWord);
            matcher = pattern.matcher(text);
            text = matcher.replaceAll("*".repeat(forbiddenWord.length()));
        }

        System.out.println(text);

    }
}
