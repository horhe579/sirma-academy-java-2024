import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CountLinesWordsAndCharacters {
    public static void main(String[] args) {
        String name = "./Files/Input.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(name)))
        {
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            String line = br.readLine();
            while(line != null)
            {
                lineCount++;
                charCount += line.length();
                wordCount += new StringTokenizer(line).countTokens();
                line = br.readLine();
            }
            System.out.println("Line count: "+ lineCount);
            System.out.println("Word count: "+ wordCount);
            System.out.println("Character count: "+ charCount);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
