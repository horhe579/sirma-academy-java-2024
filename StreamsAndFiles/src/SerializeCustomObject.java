import Classes.Person;

import java.io.*;
import java.util.*;

public class SerializeCustomObject {
    private static final HashSet<String> inputChoices = new HashSet<>();

    static {
        inputChoices.add("read");
        inputChoices.add("r");
        inputChoices.add("write");
        inputChoices.add("w");
    }

    public static void main(String[] args) {

        File file = new File("./Files/persons.ser");
        String choice = "";
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Az", 18));
        people.add(new Person("Ti", 8));
        people.add(new Person("Toi", 778));
        people.add(new Person("Tq", 7));
        people.add(new Person("To", 59));

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
                //ArrayList<int[]> nums = new ArrayList<>(Arrays.asList(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
                //System.out.println(nums.toString());
                break;
            case "w":
            case "write":
                writeMapToFile(file, people);
                break;
        }
    }

    private static void readMapFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {

            ArrayList<Person> people = (ArrayList<Person>) ois.readObject();
            System.out.println(people);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeMapToFile(File file, ArrayList<Person> peopleList) {
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream ous = new ObjectOutputStream(fos)) {

            ous.writeObject(peopleList);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
