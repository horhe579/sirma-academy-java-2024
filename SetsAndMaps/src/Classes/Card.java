package Classes;

import java.util.HashMap;
import java.util.Objects;

public class Card {
    private String power;
    private String type;
    private int value;

    private static final HashMap<String, Integer> powerValues = new HashMap<>();
    private static final HashMap<String, Integer> typeMultipliers = new HashMap<>();

    static {
        powerValues.put("2", 2);
        powerValues.put("3", 3);
        powerValues.put("4", 4);
        powerValues.put("5", 5);
        powerValues.put("6", 6);
        powerValues.put("7", 7);
        powerValues.put("8", 8);
        powerValues.put("9", 9);
        powerValues.put("10", 10);
        powerValues.put("J", 11);
        powerValues.put("Q", 12);
        powerValues.put("K", 13);
        powerValues.put("A", 14);

        typeMultipliers.put("S", 4);
        typeMultipliers.put("H", 3);
        typeMultipliers.put("D", 2);
        typeMultipliers.put("C", 1);
    }

    public Card(String power, String type) {
        this.power = power;
        this.type = type;
        this.value = getCardValue();
    }

    public Card(String card)
    {
        String [] cardDetails = fromString(card);
        this.power = cardDetails[0];
        this.type = cardDetails[1];
        this.value = getCardValue();
    }

    public int getValue() {
        return value;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private int getCardValue()
    {
        try {
            return powerValues.get(this.power) * typeMultipliers.get(this.type);
        } catch (Exception e) {
            throw new IllegalArgumentException(STR."Invalid value or power for card \{this.power}\{this.type}.");
        }
    }

    public static String[] fromString(String card)
    {
        String[] cardDetails = new String[2];
        try {
            switch (card.length()) {
                case 3:
                    cardDetails[1] = card.substring(2);
                    cardDetails[0] = card.substring(0, 2);
//                    if(!typeMultipliers.containsKey(cardDetails[1]) || !powerValues.containsKey(cardDetails[0]))
//                    {
//                        throw new IllegalArgumentException("Card value or power not recognised.");
//                    }
                    break;
                case 2:
                    cardDetails[1] = card.substring(1);
                    cardDetails[0] = card.substring(0, 1);
//                    if(!typeMultipliers.containsKey(cardDetails[1]) || !powerValues.containsKey(cardDetails[0]))
//                    {
//                        throw new IllegalArgumentException("Card value or power not recognised.");
//                    }
                    break;
                default:
                    throw new IllegalArgumentException("Card signature must have at least 2 characters.");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return cardDetails;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.power, this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(power, card.power) && Objects.equals(type, card.type);
    }
}
