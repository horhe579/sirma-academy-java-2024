import java.util.Scanner;

public class AirlineLuggageCharges {
    public static final int ALLOWED_DIMENSIONS = 158;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = Integer.parseInt(scanner.nextLine());
        int dimensions = Integer.parseInt(scanner.nextLine());
        int fee = 0;
        int flag = 0;
        String weightFee = "";
        String dimensionFee = "";
        scanner.close();

        if(weight > 50)
        {
            fee += 100;
            weightFee = "Overweight";
            flag++;
        }
        if(dimensions > ALLOWED_DIMENSIONS)
        {
            dimensionFee = "Oversized";
            if(dimensions - ALLOWED_DIMENSIONS > 50) {
                fee += 200;
                flag++;
            }
            else if(dimensions - ALLOWED_DIMENSIONS > 20)
            {
                fee += 100;
                flag++;
            }
            else
            {
                dimensionFee = "Slightly Oversized";
                fee += 50;
            }
        }

        if(flag == 2)
        {
            fee += 50;
        }

        System.out.print("$" + fee);

        if(flag > 0)
        {
            System.out.print(" (");
            if(!weightFee.equals(""))
            {
                System.out.print(weightFee);
            }
            if(!dimensionFee.equals(""))
            {
                if(!weightFee.equals(""))
                {
                    System.out.print(" + ");
                }
                System.out.print(dimensionFee);
            }
            if(flag == 2)
            {
                System.out.print(" + Handling");
            }
            System.out.print(")");
        }

        }

    }

