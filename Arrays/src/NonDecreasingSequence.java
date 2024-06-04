import java.util.Arrays;
import java.util.Scanner;

public class NonDecreasingSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        int max = arr[0];


        for(int num : arr)
        {
            if(num >= max)
            {
                max = num;
                System.out.print(max + " ");
            }
        }

    }
}
