import java.util.Scanner;

public class AtSea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = 0;
        String roomType = "";
        String assessment = "";
        float priceOfStay = 0.0f;

        while(true)
        {
            days = Integer.parseInt(scanner.nextLine());
            if(days >= 0 && days <= 365)
            {
                break;
            }
        }
        while(true)
        {
            roomType = scanner.nextLine();
            if(roomType.equals("single room") || roomType.equals("apartment") || roomType.equals("presidential"))
            {
                break;
            }
        }
        while(true)
        {
            assessment = scanner.nextLine();
            if(assessment.equals("positive") || assessment.equals("negative"))
            {
                break;
            }
        }
        scanner.close();

        switch (roomType)
        {
            case "single room":
                priceOfStay = (days - 1) * 25.0f;
                break;
            case "apartment":
                priceOfStay = (days - 1) * 50.0f;
                if(days < 10)
                {
                    priceOfStay -= priceOfStay * 0.3f;
                }
                else if(days >= 10 && days <= 15)
                {
                    priceOfStay -= priceOfStay * 0.35f;
                }
                else
                {
                    priceOfStay -= priceOfStay * 0.5f;
                }
                break;
            case "presidential":
                priceOfStay = (days - 1) * 100.0f;
                if(days < 10)
                {
                    priceOfStay -= priceOfStay * 0.1f;
                }
                else if(days >= 10 && days <= 15)
                {
                    priceOfStay -= priceOfStay * 0.15f;
                }
                else
                {
                    priceOfStay -= priceOfStay * 0.2f;
                }
                break;
            default:
                System.out.println("Invalid room type");
                break;
        }

        switch (assessment)
        {
            case "positive":
                priceOfStay += priceOfStay * 0.25f;
                break;
            case "negative":
                priceOfStay -= priceOfStay * 0.1f;
                break;
            default:
                System.out.println("Invalid assessment");
                break;
        }

        System.out.println(String.format("%.2f", priceOfStay));
    }
}
