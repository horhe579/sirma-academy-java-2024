package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryClient extends InventoryFileManager {

    //Two private Maps to store Items with Key - Item ID and Value - InventoryItem object
    //One is for all the items
    //The other one is for the discounted items
    private HashMap<String, InventoryItem> inventory = new HashMap<>();
    private HashMap<String, InventoryItem> discounted = new HashMap<>();
    //Set of all possible values used to display the inventories
    private static final HashMap<String, Integer> listTypes;

    static {
        listTypes = new HashMap<>();
        listTypes.put("discounted", 2);
        listTypes.put("d", 2);
        listTypes.put("inventory", 1);
        listTypes.put("i", 1);
    }

    public InventoryClient() {
    }

    //Function that lets the user add a new item to the inventory
    public void addItem(String description, String details, ItemType type,
                        String category, double weight, double price, boolean broken, boolean perished,
                        int itemQuantity) {
        String itemID = generateUniqueID();
        InventoryItem item = new InventoryItem(description, details, type, category, weight, price, broken, perished, itemID, itemQuantity);
        this.inventory.put(itemID, item);
        if (item.isBroken() || item.isPerished()) {
            this.discounted.put(itemID, item);
        }
        System.out.println("Added item " + description + " (#" + itemID + ").");
    }

    //Function that lets the user remove an item from the inventory
    public void removeItemByID(String itemID) {
        if (!this.inventory.containsKey(itemID)) {
            System.err.println("Item with ID " + itemID + " does not exist.");
            return;
        }
        this.inventory.remove(itemID);
        if (discounted.containsKey(itemID)) {
            this.discounted.remove(itemID);
        }
        System.out.println("Removed Item with ID " + itemID + ".");
    }

    //Function that returns one of the two inventories as a String
    public String displayItemInventory(String listName) {
        if (!isValidInventoryType(listName)) {
            System.err.println("Invalid list.");
            return null;
        }
        return switch (listTypes.get(listName)) {
            case 1 -> itemsToString(this.inventory);
            case 2 -> itemsToString(this.discounted);
            default -> {
                System.err.println("Invalid list type.");
                yield null;
            }
        };
    }

    //Lets the user load an inventory from a specified file path, and sets both the inventories
    public void loadInventoryFromFile(String fileName) throws IOException {
        this.inventory = new HashMap<>(InventoryFileManager.readInventoryFromFile(fileName));
        moveDiscountedItems();
    }

    //Lets the user save the inventory to a file
    public void saveInventoryToFile(String fileName) throws IOException {
        InventoryFileManager.writeInventoryToFile(this.inventory, fileName);
    }

    //Displays all items that have the said category
    public void categorizeItems(String category) {
        StringBuilder itemsList = new StringBuilder();

        for (var item : this.inventory.entrySet()) {
            if (item.getValue().getItemCategory().equals(category)) {
                itemsList.append(item.getValue().toString()).append("\n");
            }

        }
        System.out.println((itemsList.isEmpty()) ? "No matches for category " + category : itemsList.toString());
    }

    //Helper function to generate a random unique Item ID
    private String generateUniqueID() {
        String itemID = UUID.randomUUID().toString();
        while (this.inventory.containsKey(itemID)) {
            itemID = UUID.randomUUID().toString();
        }
        return itemID;
    }

    //Helper function that returns an inventory as a String
    private String itemsToString(HashMap<String, InventoryItem> items) {
        if (items.isEmpty()) {
            return "List is empty.";
        }

        StringBuilder itemsList = new StringBuilder();

        for (var item : items.entrySet()) {
            itemsList.append(item.getValue().toString()).append("\n");
        }

        return itemsList.toString();
    }

    //Helper function used to check for discounted items in the inventory and move them to the discounted inventory
    private void moveDiscountedItems() {
        this.discounted = new HashMap<>(this.inventory.entrySet().stream()
                .filter(i -> (i.getValue().isBroken() || i.getValue().isPerished()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
    

    protected void tweakCart(String itemID, int itemQuantity) {
        try {
            updateItemQuantity(itemID, itemQuantity);
//            switch (itemQuantity) {
//                //cover the case where we remove from the users cart
//                case "add":
//                    updateItemQuantity(itemID, -itemQuantity);
//                    //increaseItemQuantity(itemID, itemQuantity);
//                    orderPrice -= inventory.get(itemID).calculateItemValue() * itemQuantity;
//                    break;
//                //cover the case where we add to the users cart
//                case "remove":
//                    updateItemQuantity(itemID, itemQuantity);
//                    //decreaseItemQuantity(itemID, itemQuantity);
//                    orderPrice += inventory.get(itemID).calculateItemValue() * itemQuantity;
//                    break;
//                default:
//                    System.err.println("Invalid flag.");
//            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean isValidInventoryType(String type) {
        return listTypes.containsKey(type);
    }

    private void updateItemQuantity(String itemID, int itemQuantity) {
        //when ordering the quantity shall be decreased EX. 10 available -> 5 ordered -> 5 available
        //when removing from order the quantity shall be increased EX. 10 available -> 5 removed from order -> 15 available
        //meaning when we have to check if
        InventoryItem item = inventory.get(itemID);
        if (item == null) {
            throw new IllegalArgumentException("Item with itemID " + itemID + " does not exist.");
        }
        if (itemQuantity > item.getQuantity()) {
            throw new IllegalArgumentException("Only " + item.getQuantity() + " left.");
        }
        item.setQuantity(item.getQuantity() - itemQuantity);
    }

    protected double getItemPrice(String itemID) {
        return inventory.get(itemID).calculateItemValue();
    }
}
