import java.util.Scanner;

public class NewBuilding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height = Integer.parseInt(sc.nextLine());
        int width = Integer.parseInt(sc.nextLine());
        sc.close();

        for(int i = height; i > 0; i--)
        {
            for(int j = 0; j < width; j++)
            {
                char roomType = 'A';
                if(i == height)
                {
                    roomType = 'L';
                }
                else if(i % 2 == 0)
                {
                    roomType = 'O';
                }

                System.out.print(roomType + "" + i + j + " ");
            }
            System.out.println();
        }
    }
}
