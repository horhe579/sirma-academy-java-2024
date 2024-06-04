import java.util.Scanner;

public class MakeupShop {
    public static void main(String[] args) {
        float renovationBudget = 0.0f;
        int countOfPowders = 0;
        int countOfLipsticks = 0;
        int countOfSpirals = 0;
        int countOfShadows = 0;
        int countOfCorrectors = 0;

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            renovationBudget = Float.parseFloat(scanner.nextLine());
            if(renovationBudget >= 1.0 && renovationBudget <= 10000.0)
            {
                break;
            }
        }
        while(true)
        {
            countOfPowders = Integer.parseInt(scanner.nextLine());
            countOfLipsticks = Integer.parseInt(scanner.nextLine());
            countOfSpirals = Integer.parseInt(scanner.nextLine());
            countOfShadows = Integer.parseInt(scanner.nextLine());
            countOfCorrectors = Integer.parseInt(scanner.nextLine());

            if(countOfPowders >= 0 && countOfPowders <= 1000
                    && countOfLipsticks >= 0 && countOfLipsticks <= 1000
                    && countOfSpirals >= 0 && countOfSpirals <= 1000
                    && countOfShadows >= 0 && countOfShadows <= 1000
                    && countOfCorrectors >= 0 && countOfCorrectors <= 1000)
            {
                break;
            }
        }
        scanner.close();

        float earnedMoney = countOfPowders * 2.6f + countOfLipsticks * 3.0f + countOfSpirals * 4.1f + countOfShadows * 8.2f + countOfCorrectors * 2.0f;
        if(countOfPowders + countOfLipsticks + countOfSpirals + countOfShadows + countOfCorrectors >= 50)
        {
            earnedMoney -= earnedMoney * 0.25f;
        }
        earnedMoney -= earnedMoney * 0.1f;

        if(earnedMoney >= renovationBudget)
        {
            System.out.printf("Yes! %.2f lv left.", earnedMoney - renovationBudget);
        }
        else
        {
            System.out.printf("Not enough money! %.2f lv needed.", renovationBudget - earnedMoney);
        }
    }
}
