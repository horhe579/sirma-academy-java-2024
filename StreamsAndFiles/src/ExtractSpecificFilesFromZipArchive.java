import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExtractSpecificFilesFromZipArchive {
    public static void main(String[] args) {
        File zipFile = new File("./Files/Archive1.zip");
        try {
            extractTxtFiles(zipFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void extractTxtFiles(File dir) throws FileNotFoundException {

        try(ZipInputStream zipFile = new ZipInputStream(new FileInputStream(dir))) {
            StringBuilder sb = new StringBuilder("./Files/Extracted_Files/");
            final int startOfFile = sb.length();
            ZipEntry entry = zipFile.getNextEntry();
            while(entry != null)
            {
                if(entry.isDirectory())
                {
                    extractTxtFiles(new File(entry.getName()));
                }
                else if(entry.getName().endsWith(".txt"))
                {
                    System.out.println(entry.getName());
                    sb.append(entry.getName());
                    createFile(sb.toString());
                    //COPY FILE CONTENTS
                    try(BufferedWriter bw =  new BufferedWriter(new FileWriter(sb.toString())))
                    {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zipFile.read(buffer)) > 0) {
                            bw.write(new String(buffer), 0, len);
                        }
                    }
                    catch (IOException e)
                    {
                        System.out.println("KURRR");
                        return;
                    }

                    sb.delete(startOfFile, sb.length());
                }
                zipFile.closeEntry();
                entry = zipFile.getNextEntry();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFile(String filePath)
    {
        File file = new File(filePath);
        try(FileOutputStream fos = new FileOutputStream(file))
        {
            file.createNewFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
