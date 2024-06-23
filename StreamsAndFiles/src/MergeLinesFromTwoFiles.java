import java.io.*;

public class MergeLinesFromTwoFiles {
    public static void main(String[] args) {
        File file1 = new File("./Files/Input1.txt");
        File file2 = new File("./Files/Input2.txt");
        File outputFile = new File("./Files/Output.txt");

        try {
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file1));
             BufferedReader br1 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String file1Line = br.readLine();
            String file2Line = br1.readLine();
            boolean endOfFile1 = false;
            boolean endOfFile2 = false;

            StringBuilder mergedText = new StringBuilder();
            while (true) {
                if (endOfFile1 && endOfFile2) {
                    bw.write(mergedText.toString());
                    return;
                }
                if (file1Line != null) {
                    mergedText.append(file1Line + "\n");
                    file1Line = br.readLine();
                } else {
                    endOfFile1 = true;
                }
                if (file2Line != null) {
                    mergedText.append(file2Line + "\n");
                    file2Line = br1.readLine();
                } else {
                    endOfFile2 = true;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
