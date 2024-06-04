import java.util.*;

public class ReverseNumbersStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = Integer.parseInt(sc.nextLine());
        int [] numbers = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            numbersStack.push(numbers[i]);
        }

        numbersStack.stream().forEach(e -> System.out.print(e + " "));
    }
}
