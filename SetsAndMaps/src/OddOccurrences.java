import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

        String[] words = sc.nextLine().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            addWord(wordCount, words[i].toLowerCase());
        }

        ArrayList<String> oddOccurrences = new ArrayList<>();
        for (var word : wordCount.entrySet()) {
            if (word.getValue() % 2 != 0) {
                oddOccurrences.add(word.getKey());
            }
        }

        System.out.println(String.join(", ", oddOccurrences));
    }

    private static void addWord(LinkedHashMap<String, Integer> words, String word) {
        words.put(word, words.getOrDefault(word, 0) + 1);
    }
}
