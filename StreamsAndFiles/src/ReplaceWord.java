import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReplaceWord {
    public static void main(String[] args) {
        String path = "./Files/Input3.txt";
        File file = new File("./Files/Output.txt");
        try {
            if(!file.exists())
            {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            String [] words = Arrays.stream(br.readLine().split("->")).map(s -> s.trim()).toArray(String[]::new);
            String line = br.readLine();
            while(line != null)
            {
                bw.write(line.replaceAll(words[0], words[1]));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
