import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseLines {

    public static void main(String[] args) {
        File inputFile = new File("./Files/Input.txt");
        File outputFile = new File("./Files/Output.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)))
        {
            StringBuilder reversedText = new StringBuilder();
            String line = br.readLine();
            while (line != null)
            {
                reversedText.append(new StringBuilder(line).reverse());
                line = br.readLine();
            }
            bw.write(reversedText.toString());
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }



}
