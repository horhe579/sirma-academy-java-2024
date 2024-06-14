import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern characterPattern = Pattern.compile("[A-Z]|[a-z]");
        Pattern otherCharacters = Pattern.compile("[^a-zA-Z\\d]");

        Matcher digitMatcher = digitPattern.matcher(text);
        Matcher characterMatcher = characterPattern.matcher(text);
        Matcher otherCharacterMatcher = otherCharacters.matcher(text);

        StringBuilder digits = new StringBuilder();
        StringBuilder characters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        while(digitMatcher.find())
        {
            digits.append(digitMatcher.group());
        }

        while(characterMatcher.find())
        {
            characters.append(characterMatcher.group());
        }

        while(otherCharacterMatcher.find())
        {
            others.append(otherCharacterMatcher.group());
        }

        System.out.println(String.join(" " ,digits.toString()));
        System.out.println(String.join(" " ,characters.toString()));
        System.out.println(String.join(" " ,others.toString()));

    }
}
