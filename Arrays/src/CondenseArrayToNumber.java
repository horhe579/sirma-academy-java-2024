import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        while(arr.length != 1)
        {
            arr = condenseArray(arr);
        }
        System.out.println(Arrays.toString(arr));

    }

    public static int[] condenseArray(int[] arr)
    {
        int[] cloneArr = new int [arr.length-1];
        for (int i = 0; i < cloneArr.length; i++) {
            cloneArr[i] = arr[i] + arr[i+1];
        }

        return cloneArr;
    }


}
