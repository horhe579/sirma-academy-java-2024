import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

    }

    public static int[] AddNumber(int [] arr, int number)
    {
        int [] tempArr = Arrays.copyOf(arr, arr.length+1);
        tempArr[tempArr.length-1] = number;
        return tempArr;
    }
    public static int[] RemoveNumber(int [] arr, int number)
    {
        return Arrays.stream(arr).filter(e -> e != number).toArray();
    }
    public static int[] RemoveAt(int [] arr, int i)
    {
        return IntStream.range(0, arr.length).filter(index -> index != i).map(e -> arr[e]).toArray();
    }
    public static int[] Insert(int [] arr, int i, int n)
    {
        int[] temp = Arrays.copyOf(arr, arr.length+1);
        for (int j = temp.length-1; j >= i ; j--) {
            temp[j] = arr[j-1];
        }
        temp[i] = n;
        return temp;
    }


}
