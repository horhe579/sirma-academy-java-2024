import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array 1 elements:");
        int [] array1 = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println("Enter array 2 elements:");
        int [] array2 = Arrays.stream(sc.nextLine().split("[, ]+"))
                .mapToInt(Integer::parseInt).toArray();

        int flag = 0;

        for (int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i])
            {
                System.out.println("Arrays are not identical. Found difference at " + i + " index.");
                flag = -1;
                break;
            }
        }
        if(flag != -1)
        {
            System.out.println("Arrays are identical. Sum: " + Arrays.stream(array1).sum());
        }

    }
}
