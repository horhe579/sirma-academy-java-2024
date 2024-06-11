import Classes.Card;
import Classes.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        HashMap<String, Person> people1 = new HashMap<>();
        while(true)
        {
            String [] input = sc.nextLine().split("[,: ]+");
            switch (input.length)
            {
                case 1:
                    switch (input[0].toLowerCase())
                    {
                        case "joker":
                            for(var person : people1.entrySet())
                            {
                                System.out.println(person.getValue().toString());
                            }
                            return;
                        default:
                            System.out.println("Invalid command");
                            break;
                    }
                default:
                    String playerName = input[0];
                    ArrayList<Card> cards = new ArrayList<>();
                    try {
                        for (int i = 1; i < input.length; i++) {
                            cards.add(new Card(input[i]));
                        }
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                    Person p = (people1.containsKey(playerName))
                            ? people1.get(playerName)
                            : new Person(playerName);

                    for(Card card : cards)
                    {
                        p.addCard(card);
                    }
                    if(!people1.containsKey(p.getName()))
                    {
                        people1.put(p.getName(), p);
                    }
            }
        }
    }
}
