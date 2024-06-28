package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;
import InventoryManagementSystem.Interfaces.*;

public abstract class AbstractItem implements Item, Categorizable, Breakable, Perishable, Sellable {

    private String description;
    private String details;
    private ItemType type;
    private String category;
    private double weight;
    private double price;
    private boolean isBreakable;
    private boolean isPerishable;
    private boolean broken;
    private boolean perished;

//    public AbstractItem()
//    {
//
//    }

    public AbstractItem(String description, String details, ItemType type, String category, double weight, double price,
                        boolean broken, boolean perished) {
        this.description = description;
        this.details = details;
        setItemType(type);
        this.category = category;
        setItemWeight(weight);
        this.price = price;
        this.isBreakable = checkIfBreakable();
        this.isPerishable = checkIfPerishable();
        this.broken = (isBreakable) ? broken : false;
        this.perished = (isPerishable) ? perished : false;
    }

    public AbstractItem(String description, String details, ItemType type, String category, double weight,
                        double price, boolean isBreakable, boolean isPerishable, boolean broken, boolean perished) {
        this.description = description;
        this.details = details;
        setItemType(type);
        this.category = category;
        setItemWeight(weight);
        this.price = price;
        this.isBreakable = isBreakable;
        this.isPerishable = isPerishable;
        this.broken = broken;
        this.perished = perished;
    }

    private void setItemWeight(double weight) {
        if (weight >= 500 || weight <= 0) {
            throw new IllegalArgumentException("Invalid weight");
        }
        this.weight = weight;
    }

    private void setItemType(ItemType type) {
        if (type == null) {
            throw new IllegalArgumentException("ItemType cannot be null");
        }
        this.type = type;
    }

    @Override
    public boolean checkIfBreakable() {
        switch (type) {
            case FRAGILE:
            case ELECTRONICS:
                return true;
            case GROCERY:
                return false;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    @Override
    public void handleItemBreakage() {
        //Something to do with lists, for example if expired add it to a new list(recycle)
        //and remove from old one
        this.broken = true;
    }

    @Override
    public void setItemCategory(String category) {
        this.category = category;
    }

    @Override
    public String getItemCategory() {
        return this.category;
    }

    @Override
    public String getItemDetails() {
        //maybe return a new type for item details or return a string(add a details field)
        return this.details;
    }

    @Override
    public double calculateItemValue() {
        //check if broken or expired, if broken or expired give discount
        //use this to display prices
        if (isBroken() && isPerished()) {
            return this.price * 0.8;
        } else if (isBroken() || isPerished()) {
            return this.price * 0.9;
        }
        return this.price;
    }

    @Override
    public String displayItemDescription() {
        return description;
    }

    @Override
    public boolean checkIfPerishable() {
        switch (type) {
            case FRAGILE:
            case ELECTRONICS:
                return false;
            case GROCERY:
                return true;
            default:
                throw new IllegalArgumentException("Invalid type");
        }
    }

    @Override
    public void handleItemExpiration() {
        //Something to do with lists, for example if expired add it to a new list
        //give food to the homeless etc.
        this.perished = true;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return calculateItemValue();
        //return this.price;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public boolean isPerished() {
        return perished;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", type=" + type +
                ", category='" + category + '\'' +
                ", weight=" + weight +
                ", price=" + calculateItemValue() +
                ", isBreakable=" + isBreakable +
                ", isPerishable=" + isPerishable +
                ", broken=" + broken +
                ", perished=" + perished + " ";
    }

    public String toFileFormat() {
        return description + "~~~" +
                details + "~~~" +
                type + "~~~" +
                category + "~~~"
                + weight + "~~~"
                + calculateItemValue() + "~~~"
                + isBreakable + "~~~"
                + isPerishable + "~~~"
                + broken + "~~~"
                + perished;
    }
}
