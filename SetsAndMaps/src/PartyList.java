import java.util.*;

//17 min
//add VIP Priority

public class PartyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean partyStart = false;

        LinkedHashSet<String> reservationList = new LinkedHashSet<>();

        LinkedHashSet<String> partyAnimals = new LinkedHashSet<>();


        while (!partyStart) {
            String input = sc.nextLine();
            switch (input.length()) {
                case 5:
                    switch (input.toLowerCase()) {
                        case "party":
                            partyStart = true;
                            break;
                        default:
                            System.err.println("Invalid command.");
                            break;
                    }
                    break;
                case 8:
                    //add guest to list
                    reservationList.add(input);
                    break;
                default:
                    System.err.println("Invalid guest format, must be 8 characters long.");
                    break;
            }
        }
        while (true) {
            String guest = sc.nextLine();
            switch (guest.length()) {
                case 3:
                    switch (guest.toLowerCase()) {
                        case "end":
                            TreeSet<String> missingPeople = new TreeSet<>();
                            for (var partyGoer : reservationList) {
                                if (!partyAnimals.contains(partyGoer)) {
                                    missingPeople.add(partyGoer);
                                }
                            }

                            System.out.println(missingPeople.size());

                            List<String> vipGuests = new ArrayList<>();
                            List<String> otherGuests = new ArrayList<>();

                            for (var missingPerson : missingPeople) {
                                if (Character.isDigit(missingPerson.charAt(0))) {
                                    vipGuests.add(missingPerson);
                                } else {
                                    otherGuests.add(missingPerson);
                                }
                            }

                            vipGuests.forEach(System.out::println);
                            otherGuests.forEach(System.out::println);

                            return;
                        default:
                            System.err.println("Invalid command.");
                            break;
                    }
                    break;
                case 8:
                    //if on the reservation list let in
                    if (reservationList.contains(guest)) {
                        partyAnimals.add(guest);
                    }
                    break;
                default:
                    System.err.println("Invalid guest format, must be 8 characters long.");
                    break;
            }
        }
    }
}
