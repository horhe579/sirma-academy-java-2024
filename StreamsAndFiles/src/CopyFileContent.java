import java.io.*;

public class CopyFileContent {
    public static void main(String[] args) {
        File inputFile = new File("./Files/Input.txt");
        File outputFile = new File("./Files/Output.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String line = br.readLine();
            while(line != null)
            {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
