import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        LinkedHashMap<String, String> registeredCars = new LinkedHashMap<>();

        for (int i = 0; i < n; ) {
            String [] commands = sc.nextLine().split("\\s+");

            switch (commands.length)
            {
                case 3:
                    switch(commands[0].toLowerCase())
                    {
                        case "register":
                            registerCar(registeredCars, commands[1], commands[2]);
                            i++;
                            break;
                        default:
                            System.err.println("Invalid command.");
                            break;
                    }
                    break;
                case 2:
                    switch(commands[0].toLowerCase())
                    {
                        case "unregister":
                            unregisterCar(registeredCars, commands[1]);
                            i++;
                            break;
                        default:
                            System.err.println("Invalid command.");
                            break;
                    }
                    break;
            }
        }

        printRegisteredUsers(registeredCars);
    }

    private static void registerCar(LinkedHashMap<String, String> registeredCars, String username, String licensePlateNumber)
    {
        if(registeredCars.containsKey(username))
        {
            System.err.println(STR."ERROR: already registered with plate number \{licensePlateNumber}");
        }
        else
        {
            registeredCars.put(username, licensePlateNumber);
            System.out.println(STR."\{username} registered \{licensePlateNumber} successfully.");
        }
    }

    private static void unregisterCar(LinkedHashMap<String, String> registeredCars, String username)
    {
        if(registeredCars.containsKey(username))
        {
            registeredCars.remove(username);
            System.out.println(STR."\{username} unregistered successfully.");
        }
        else
        {
            System.err.println(STR."ERROR: user \{username} not found.");
        }
    }

    private static void printRegisteredUsers(LinkedHashMap<String, String> registeredCars)
    {
        for( var user: registeredCars.entrySet())
        {
            System.out.println(STR."\{user.getKey()} => \{user.getValue()}");
        }
    }
}
