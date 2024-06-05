import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());

        char[][] matrix1 = new char[N][M];
        char[][] matrix2 = new char[N][M];

        for (int i = 0; i < 2 * N; i++) {
            char[] rowElements = String.join("", sc.nextLine().split("[, ]+")).toCharArray();
            if (i < N) {
                for (int j = 0; j < M; j++) {
                    matrix1[i][j] = rowElements[j];
                }
            } else {
                for (int j = 0; j < M; j++) {
                    matrix2[i - N][j] = rowElements[j];
                }
            }
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print((matrix1[i][j] == matrix2[i][j])
                        ? matrix1[i][j] + " "
                        : "* ");
            }
            System.out.println();
        }
    }
}
