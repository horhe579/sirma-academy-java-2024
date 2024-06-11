package Classes;

import java.util.HashMap;

public class Person {
    private String name;
    private HashMap<Card, Integer> deck = new HashMap<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card)
    {
        deck.putIfAbsent(card, card.getValue());
    }

    private int getDeckValue()
    {
        int value = 0;
        for(var card : deck.entrySet())
        {
            value += card.getValue();
        }
        return value;
    }

    @Override
    public String toString() {
        return STR."\{this.name}: \{getDeckValue()}";
    }
}
