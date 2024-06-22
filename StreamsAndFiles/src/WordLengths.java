import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WordLengths {
    public static void main(String[] args) {
        String path = "./Files/Input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            StringBuilder lengths = new StringBuilder();
            while (line != null) {
                String result = Arrays.stream(line.split("\\s+")).map(c -> String.valueOf(c.length())).collect(Collectors.joining(", "));
                lengths.append((lengths.isEmpty()) ? result : ", " + result);
                line = reader.readLine();
            }
            System.out.println(lengths);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
