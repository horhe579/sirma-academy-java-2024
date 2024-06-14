import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();

        String fileNameRegex = "[^\\\\]+$";

        Pattern extractFilename = Pattern.compile(fileNameRegex);
        Matcher matcher = extractFilename.matcher(filePath);

        if(matcher.find())
        {
            String [] result = matcher.group().split("\\.");
            System.out.println(STR."Filename: \{result[0]}");
            System.out.println(STR."Extension: \{result[1]}");
        }
    }
}
