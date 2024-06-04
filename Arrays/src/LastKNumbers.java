import java.util.Arrays;
import java.util.Scanner;

public class LastKNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());
        int [] copy = new int[n];
        copy[0] = 1;
        StringBuilder sequence = new StringBuilder("1");

        for (int i = 1; i < copy.length; i++) {
            copy[i] = sumOfPrevNElements(copy, i, k);
        }
        System.out.println(Arrays.toString(copy));
    }

    public static int sumOfPrevNElements(int[] arr, int i, int n)
    {
        int sum=0;
        for (int j = i-1, k = 1; k <= n ; j--, k++) {

            if(j<0)
            {
                sum += 0;
            }
            else{
                sum += arr[j];
            }
        }
        return sum;
    }
}
