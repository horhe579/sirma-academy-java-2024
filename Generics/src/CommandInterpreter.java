import java.util.Scanner;

public class CommandInterpreter {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            CustomList<String> customList = new CustomList<>(String.class);

            while (true) {
                String command = scanner.nextLine();

                if (command.equals("end")) {
                    break;
                }

                String[] commandParts = command.split("\\s+");
                String action = commandParts[0];

                switch (action) {
                    case "Add":
                        String elementToAdd = commandParts[1];
                        customList.add(elementToAdd);
                        break;

                    case "Remove":
                        int indexToRemove = Integer.parseInt(commandParts[1]);
                        customList.remove(indexToRemove);
                        break;

                    case "Contains":
                        String elementToCheck = commandParts[1];
                        System.out.println(customList.contains(elementToCheck));
                        break;

                    case "Swap":
                        int index1 = Integer.parseInt(commandParts[1]);
                        int index2 = Integer.parseInt(commandParts[2]);
                        customList.swap(index1, index2);
                        break;

                    case "Greater":
                        String elementToCompare = commandParts[1];
                        System.out.println(customList.countGreaterThan(elementToCompare));
                        break;

                    case "Max":
                        System.out.println(customList.getMax());
                        break;

                    case "Min":
                        System.out.println(customList.getMin());
                        break;

                    case "Print":
                        for (int i = 0; i < customList.size(); i++) {
                            System.out.println(customList.get(i));
                        }
                        break;

                    default:
                        System.out.println("Invalid command");
                        break;
                }
            }
        }
    }
}
