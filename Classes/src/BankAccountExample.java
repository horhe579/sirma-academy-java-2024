import Classes.BankAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> bankAccountList = new ArrayList<>();
        int currentId = 1;

        for (int i = 1; ; i++) {
            String [] instructions = sc.nextLine().split("[, ]+");
            switch(instructions[0])
            {
                case "Create":
                    BankAccount acc = new BankAccount(currentId);
                    bankAccountList.add(acc);
                    currentId++;
                    System.out.println(acc.notifyOnCreate());
                    break;
                case "Deposit":
                    acc = getAccountById(instructions[1], bankAccountList);
                    if (acc != null) {
                        acc.deposit(Double.parseDouble(instructions[2]));
                    }
                    break;
                case "GetInterest":
                    acc =  getAccountById(instructions[1], bankAccountList);
                    if (acc != null) {
                        System.out.println(acc.getInterest(Integer.parseInt(instructions[2])));
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(instructions[1]));
                    System.out.println(STR."Interest set to \{BankAccount.getInterestRate()}");
                    break;
                case "End":
                    return;
            }
        }
    }

    public static BankAccount getAccountById(String id, ArrayList<BankAccount> bankAccountList)
    {
        for(BankAccount account : bankAccountList)
        {
            if(account.getId() == Integer.parseInt(id))
            {
                return account;
            }
        }
        System.out.println("No such account.");
        return null;
    }
}
