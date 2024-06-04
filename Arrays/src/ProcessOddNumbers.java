import java.util.Arrays;
import java.util.Scanner;

public class ProcessOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();
        int [] oddNumbers = new int[arr.length/2];

        for (int i = 1, j = 0; i < arr.length; i+=2, j++) {
            oddNumbers[j] = arr[i]*2;
        }
        oddNumbers = reverseIntArray(oddNumbers);
        System.out.println(Arrays.toString(oddNumbers));
    }

    public static int[] reverseIntArray(int[] arr)
    {
        for(int i = 0; i < arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}
