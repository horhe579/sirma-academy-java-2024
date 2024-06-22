import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountLinesWordsAndCharacters {
    public static void main(String[] args) {
        String name = "./Files/Input.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(name)))
        {
            int lineCount = 0;
            int wordCount = 0;

        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
