import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class ExtractFile {
    public static void main(String[] args) {
        File file = new File("./Files/Input.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try
        {
            if(file.isFile())
            {
                System.out.println("File name: " +  file.getName().replaceAll("(\\.[^.]+)$", ""));
                System.out.println("File extension: " + file.getName().replaceAll(".*(\\.[^.]+)$", "$1"));
                System.out.println("File size: " +  file.length() + " bytes");
            }
        }
        catch (Exception e)
        {
            System.out.println("kur");
        }
    }
}
