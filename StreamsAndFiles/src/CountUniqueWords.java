import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class CountUniqueWords {
    public static void main(String[] args) {
        File file = new File("./Files/Input.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            HashSet<String> words = new HashSet<>();
            String line = br.readLine();
            while (line != null) {
                Arrays.stream(line.split("[,\\. ]+")).forEach(words::add);
                line = br.readLine();
            }
            System.out.println("Unique words: " + words.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
