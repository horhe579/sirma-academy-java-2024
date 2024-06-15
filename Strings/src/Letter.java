import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Letter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        String[] words = sc.nextLine().split("[, ]+");
        String[][] letterArray = new String[2][words.length];
        letterArray[0][0] = message;
        letterArray[1] = words;

        fillLetter(letterArray);
    }

    private static void fillLetter(String[][] letter) {
        String message = letter[0][0];
        HashMap<Integer, String> words = new HashMap<>(Arrays.stream(letter[1]).collect(Collectors.toMap(String::length, String::toString)));
        StringBuilder newMessage = new StringBuilder(message.length());

        Pattern missingWordPattern = Pattern.compile("_+");
        Matcher matcher = missingWordPattern.matcher(message);

        int lastMatch = 0;

        while (matcher.find()) {
            newMessage.append(message, lastMatch, matcher.start());
            newMessage.append(words.getOrDefault(matcher.group().length(), matcher.group()));
            words.remove(matcher.group().length());
            lastMatch = matcher.end();
        }

        newMessage.append(message.substring(lastMatch));

        System.out.println(newMessage);
    }
}
