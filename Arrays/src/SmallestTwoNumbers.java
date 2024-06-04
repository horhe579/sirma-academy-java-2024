import java.util.Arrays;
import java.util.Scanner;

public class SmallestTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        int firstSmallest = arr[0];
        int secondSmallest = arr[0];

        for(int num : arr)
        {
            if(num<firstSmallest)
            {
                firstSmallest = num;
            }
        }
        for(int num : arr)
        {
            if(num<secondSmallest && num>firstSmallest)
            {
                secondSmallest = num;
            }
        }
        System.out.println(firstSmallest + " " + secondSmallest);

    }
}
