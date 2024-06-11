import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while (true)
        {
            String [] input = sc.nextLine().split("[ -]+");
            switch (input.length)
            {
                case 2:
                    switch (input[0].toLowerCase())
                    {
                        case "search":
                            searchForContact(input[1], phonebook);
                            break;
                        default:
                            addContact(input[0], input[1], phonebook);
                            break;
                    }
                    break;
                case 1:
                    switch (input[0].toLowerCase())
                    {
                        case "stop":
                            return;
                        default:
                            System.out.println("Invalid command");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid!");
                    break;
            }

        }

    }

    public static void addContact(String name, String phoneNumber, HashMap<String, String> phonebook)
    {
        phonebook.put(name, phoneNumber);
    }

    public static void searchForContact(String name, HashMap<String, String> phonebook)
    {
        var contact = phonebook.get(name);
        System.out.println( contact == null
                ? STR."Contact \{name} not found."
                : STR."\{name} -> \{contact}");
    }
}
