import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int s = Integer.parseInt(sc.nextLine());
        int x = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if(!queue.isEmpty())
        {
            System.out.println((queue.contains(x)) ? true : Collections.min(queue));
        }
    }
}
