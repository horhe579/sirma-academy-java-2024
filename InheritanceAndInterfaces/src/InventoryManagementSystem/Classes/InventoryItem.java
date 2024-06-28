package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InventoryItem extends AbstractItem {

    private final String ID;
    private int quantity;

    public InventoryItem(String description, String details, ItemType type, String category, double weight,
                         double price, boolean broken, boolean perished, String ID, int quantity) {
        super(description, details, type, category, weight, price, broken, perished);
        this.ID = ID;
        setQuantity(quantity);
    }

    //constructor for reading from file

    public InventoryItem(String description, String details, ItemType type, String category, double weight,
                         double price, boolean isBreakable, boolean isPerishable, boolean broken,
                         boolean perished, String ID, int quantity) {
        super(description, details, type, category, weight, price, isBreakable, isPerishable, broken, perished);
        this.ID = ID;
        setQuantity(quantity);
    }


    public String getID() {
        return this.ID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Invalid quantity " + quantity);
        }
        this.quantity = quantity;
    }

    private String generateUniqueID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void handleItemBreakage() {
        super.handleItemBreakage();
        System.out.println("Item " + super.displayItemDescription() + " with ID " + ID + "has been broken.");
    }

    @Override
    public void handleItemExpiration() {
        super.handleItemExpiration();
        System.out.println("Item " + super.displayItemDescription() + " with ID " + ID + "has expired.");
    }

    @Override
    public String toString() {
        return super.toString() +
                "ID='" + ID + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String toFileFormat() {
        return super.toFileFormat() +
                "~~~" + ID +
                "~~~" + quantity;
    }


}
