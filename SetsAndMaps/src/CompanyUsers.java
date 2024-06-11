import java.util.*;

//10-15 min

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, ArrayList<String>> companyUsers = new LinkedHashMap<>();

        while (true) {
            String[] command = sc.nextLine().split("->");
            switch (command.length)
            {
                case 1:
                    if(command[0].toLowerCase().equals("end"))
                    {
                        printCompanies(companyUsers);
                        return;
                    }
                    else
                    {
                        System.err.println("Formatting should be like this | CompanyName -> UserID");
                    }
                    break;
                case 2:
                    addUser(companyUsers, command[0].trim(), command[1].trim());
                    break;
                default:
                    System.err.println("Formatting should be like this | CompanyName -> UserID");
                    break;
            }

        }
    }

    private static void addUser(LinkedHashMap<String, ArrayList<String>> companies, String companyName, String userID) {
        companies.putIfAbsent(companyName, new ArrayList<>());
        if(!companies.get(companyName).contains(userID))
        {
            companies.get(companyName).add(userID);
        }
    }

    private static void printCompanies(LinkedHashMap<String, ArrayList<String>> companies)
    {
        for(var company: companies.entrySet())
        {
            System.out.println(STR."\{company.getKey()}");
            for(String user : company.getValue())
            {
                System.out.println(STR."-- \{user}");
            }
        }
    }
}
