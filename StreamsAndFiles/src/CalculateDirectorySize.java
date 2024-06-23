import java.io.File;

public class CalculateDirectorySize {
    public static void main(String[] args) {
        File directory = new File("./Files");
        System.out.println("Dir " + directory.getName() + " size:" + calculateDirectory(directory));
    }

    private static long calculateDirectory(File dir)
    {
        long size = 0;
        File [] dirFiles = dir.listFiles();

        if (dirFiles == null) {
            return 0;
        }

        for(File file: dirFiles)
        {
            if(file.isFile())
            {
                size += file.length();
            }
            else if(file.isDirectory())
            {
                size += calculateDirectory(file);
            }
        }
        return size;
    }
}
