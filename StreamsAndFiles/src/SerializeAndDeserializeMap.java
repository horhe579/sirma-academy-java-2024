import java.io.*;
import java.util.*;

public class SerializeAndDeserializeMap {
    private static final HashSet<String> inputChoices = new HashSet<>();

    static {
        inputChoices.add("read");
        inputChoices.add("r");
        inputChoices.add("write");
        inputChoices.add("w");
    }

    public static void main(String[] args) {

        File file = new File("./Files/map.ser");
        String choice = "";
        HashMap<String, Integer> people = new HashMap<>();
        people.put("Gosho", 19);
        people.put("Pesho", 12);
        people.put("Bobi", 13);
        people.put("Viktor", 16);
        people.put("Atanas", 33);

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter 'read' or 'write': ");
                choice = sc.nextLine().toLowerCase().trim();
                if (inputChoices.contains(choice)) {
                    break;
                } else {
                    System.err.println("Invalid choice. Please enter 'read' or 'write'.");
                }
            }
        }

        switch (choice) {
            case "r":
            case "read":
                readMapFromFile(file);
                break;
            case "w":
            case "write":
                writeMapToFile(file, people);
                break;
        }
    }

    private static void readMapFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {

            HashMap<String, Integer> map = (HashMap<String, Integer>) ois.readObject();
            System.out.println(map.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeMapToFile(File file, HashMap<String, Integer> map) {
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream ous = new ObjectOutputStream(fos)) {

            ous.writeObject(map);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
