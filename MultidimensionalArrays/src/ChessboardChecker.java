import java.util.Scanner;

public class ChessboardChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        int[][] chessboard = CompareMatrices.createMatrix(rows, rows);

    }
}
