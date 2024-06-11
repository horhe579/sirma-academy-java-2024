import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> evenLengthWords = new HashSet<String>();

        String [] words = sc.nextLine().split("\\s+");
        for (String word : words)
        {
            if(word.length()%2 == 0)
            {
                evenLengthWords.add(word);
                System.out.println(word);
            }
        }
    }
}
