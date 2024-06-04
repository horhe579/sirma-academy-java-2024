import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DocumentEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> undo = new ArrayDeque<>();
        ArrayDeque<String> redo = new ArrayDeque<>();
        ArrayList<String> input = new ArrayList<>(Arrays.asList(sc.nextLine().split("[( )\"]")));

        while(!input.get(0).equals("end"))
        {
            switch(input.get(0).toLowerCase())
            {
                case "insert":
                    undo.push(input.get(1));
                    redo.clear();
                    undo.stream().toList().reversed().forEach(e -> System.out.print(STR."\{e} "));
                    break;
                case "redo":
                    if (!redo.isEmpty()) {
                        undo.push(redo.pop());
                        undo.stream().toList().reversed().forEach(e -> System.out.print(STR."\{e} "));
                    } else {
                        System.out.println("Nothing to redo.");
                    }
                    break;
                case "undo":
                    if (!undo.isEmpty()) {
                        redo.push(undo.pop());
                        undo.stream().toList().reversed().forEach(e -> System.out.print(STR."\{e} "));
                    } else {
                        System.out.println("Nothing to undo.");
                    }
                    break;
                default:
                    System.out.println("Invalid.");
                    break;
            }
            input = new ArrayList<>(Arrays.asList(sc.nextLine().split("[( )\"]")));
        }
    }
}
