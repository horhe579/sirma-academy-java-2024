import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int [][] matrix = CompareMatrices.createMatrix(rows, cols);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(Arrays.stream(matrix).flatMapToInt(Arrays::stream).reduce(0, Integer::sum));
    }
}
