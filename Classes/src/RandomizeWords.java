import java.util.*;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = Arrays.stream(sc.nextLine().split("[, ]+"))
                .collect(Collectors.toCollection(ArrayList::new));
        Random rnd = new Random();

        int randomInt;

        for (int i = words.size()-1; i >= 0 ; i--) {
            randomInt = rnd.nextInt(words.size());
            String temp = words.get(i);
            words.set(i, words.get(randomInt));
            words.set(randomInt, temp);
        }

        System.out.println(words);
    }
}
