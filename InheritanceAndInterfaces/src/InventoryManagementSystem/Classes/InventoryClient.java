package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class InventoryClient {

    private HashMap<String, InventoryItem> inventory = new HashMap<>();
    private HashMap<String, InventoryItem> discounted = new HashMap<>();
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

    public void addItem(String description, String details, ItemType type,
                        String category, double weight, double price, boolean broken, boolean perished,
                        int quantity) {
        String ID = generateUniqueID();
        InventoryItem item = new InventoryItem(description, details, type, category, weight, price, broken, perished, ID, quantity);
        this.inventory.put(ID, item);
        this.discounted.put(ID, item);
        if (item.isBroken() || item.isPerished()) {
        }
        System.out.println("Added item " + description + " (#" + ID + ").");
    }

    public void removeItemByID(String ID) {
        if (!this.inventory.containsKey(ID)) {
            System.err.println("Item with ID " + ID + " does not exist.");
            return;
        }
        this.inventory.remove(ID);
        if (discounted.containsKey(ID)) {
            this.discounted.remove(ID);
        }
        System.out.println("Removed Item with ID " + ID + ".");
    }

    public void displayItemInventory(String listName) {
        if (!listTypes.containsKey(listName)) {
            System.err.println("Invalid list.");
            return;
        }
        switch (listTypes.get(listName)) {
            case 1:
                System.out.println(itemsToString(this.inventory));
                break;
            case 2:
                System.out.println(itemsToString(this.discounted));
                break;
            default:
                System.err.println("Invalid list type.");
        }
    }

    public void placeOrder() {


    }

    public void loadInventoryFromFile(String fileName) throws IOException {
        this.inventory = new HashMap<>(InventoryFileManager.readInventoryFromFile(fileName));
        moveDiscountedItems();
    }

    public void saveInventoryToFile(String fileName) throws IOException {
        InventoryFileManager.writeInventoryToFile(this.inventory, fileName);
    }

    public void categorizeItems(String category) {
        StringBuilder itemsList = new StringBuilder();

        for (var item : this.inventory.entrySet()) {
            if (item.getValue().getItemCategory().equals(category)) {
                itemsList.append(item.getValue().toString() + "\n");
            }

        }
        System.out.println((itemsList.isEmpty()) ? "No matches for category " + category : itemsList.toString());
    }


    private String generateUniqueID() {
        String ID;
        do {
            ID = UUID.randomUUID().toString();

        } while (this.inventory.containsKey(ID));
        return ID;
    }

    private String itemsToString(HashMap<String, InventoryItem> items) {
        if (items.isEmpty()) {
            return "List is empty.";
        }
        StringBuilder itemsList = new StringBuilder();

        for (var item : items.entrySet()) {
            itemsList.append(item.getValue().toString() + "\n");
        }

        return itemsList.toString();
    }

    private void moveDiscountedItems() {
        this.discounted = new HashMap<>(this.inventory.entrySet().stream()
                .filter(i -> (i.getValue().isBroken() || i.getValue().isPerished()))
                .collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue())));
    }

    public static boolean isValidInventoryType(String type) {
        return listTypes.containsKey(type);
    }

    private void decreaseItemQuantity(String ID, int quantity) {
        InventoryItem item = inventory.get(ID);
        if (item == null) {
            throw new IllegalArgumentException("Item with ID " + ID + " does not exist.");
        }
        if (item.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient quantity for item " + ID + ((item.getQuantity() == 0) ? " none left." : (", only " + inventory.get(ID).getQuantity() + "left.");
        }
        item.setQuantity(item.getQuantity() - quantity);
    }

    private void increaseItemQuantity(String ID, int quantity) {
        InventoryItem item = inventory.get(ID);
        if (item == null) {
            throw new IllegalArgumentException("Item with ID " + ID + " does not exist.");
        }
        item.setQuantity(item.getQuantity() + quantity);
    }

    public double tweakCart(String ID, int quantity, String action, double orderPrice) {
        try {
            switch (action) {
                case "add":
                    increaseItemQuantity(ID, quantity);
                    orderPrice -= inventory.get(ID).calculateItemValue()*quantity;
                    break;
                case "remove":
                    decreaseItemQuantity(ID, quantity);
                    orderPrice += inventory.get(ID).calculateItemValue()*quantity;
                    break;
                default:
                    System.err.println("Invalid flag.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        return orderPrice;
    }

}
