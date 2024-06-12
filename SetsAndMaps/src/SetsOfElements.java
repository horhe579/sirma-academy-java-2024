import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> firstSet = new ArrayList<>(n);
        ArrayList<Integer> secondSet = new ArrayList<>(n);

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                firstSet.add(Integer.parseInt(sc.nextLine()));
            }
            else
            {
                secondSet.add(Integer.parseInt(sc.nextLine()));
            }
        }

        HashSet<Integer> nonRepeatingElements = new HashSet<>(firstSet.stream().filter(e -> secondSet.contains(e)).collect(Collectors.toSet()));
        nonRepeatingElements.stream().forEach(System.out::println);
    }
}
