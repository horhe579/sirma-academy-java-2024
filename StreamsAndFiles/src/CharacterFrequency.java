import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String path = "./Files/Input2.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(path)))
        {
            String line = reader.readLine();
            LinkedHashMap<Character, Integer> letterOccurrences = new LinkedHashMap<>();
            while (line != null) {
                line.chars().mapToObj(c -> (char) c).forEach(c -> letterOccurrences.put(c, letterOccurrences.getOrDefault(c , 0) + 1));
                line = reader.readLine();
            }
            for(var letterCount : letterOccurrences.entrySet())
            {
                System.out.println(letterCount.getKey() + ": " + letterCount.getValue());
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
