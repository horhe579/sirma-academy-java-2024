
import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, ArrayList<String>> synonymDictionary = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();
            addSynonym(synonymDictionary, word, synonym);
        }

        for(var word : synonymDictionary.entrySet())
        {
            System.out.print(STR."\{word.getKey()} - ");
            for (int i = 0; i < word.getValue().size(); i++) {
                if(i != 0)
                {
                    System.out.print(", ");
                }
                System.out.print(STR."\{word.getValue().get(i)}");
            }
            System.out.println();
        }

        sc.close();
    }

    private static void addSynonym(LinkedHashMap<String, ArrayList<String >> dictionary, String word, String synonym)
    {
        dictionary.putIfAbsent(word, new ArrayList<>());
        if(dictionary.containsKey(word))
        {
            dictionary.get(word).add(synonym);
        }
    }

}
