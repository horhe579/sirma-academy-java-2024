import java.util.HashMap;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> letterOccurrences = new HashMap<>();
        String word = sc.nextLine();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter != ' ') {
                letterOccurrences.put(letter, letterOccurrences.getOrDefault(letter, 0) + 1);
            }
        }

        for (var c : letterOccurrences.entrySet()) {
            System.out.println(STR."\{c.getKey()} -> \{c.getValue()}");
        }
    }
}
