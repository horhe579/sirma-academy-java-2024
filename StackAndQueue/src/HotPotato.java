import java.util.ArrayDeque;
import java.util.List;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque <String> names = new ArrayDeque<>(List.of(sc.nextLine().split("[, ]+")));
        int tosses = Integer.parseInt(sc.nextLine());

        while(names.size() > 1)
        {
            for (int i = 1; i < tosses; i++) {
                names.offer(names.poll());
            }
            System.out.println(STR."Remove \{names.poll()}");
        }
        System.out.println(STR."Last is \{names.poll()}");
    }
}
