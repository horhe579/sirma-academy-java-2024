package Classes;

import java.util.HashSet;
import java.util.Scanner;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashSet<String> elements = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String [] compound = sc.nextLine().split("[, ]+");
            for(String element : compound)
            {
                elements.add(element);
            }
        }

        System.out.println(elements);
    }
}
