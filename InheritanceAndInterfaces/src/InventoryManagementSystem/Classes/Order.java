package InventoryManagementSystem.Classes;

import java.util.LinkedHashMap;

public class Order {

    //An inventory, related to the order
    //Mai ne e hubavo da sedi taka?
    private final InventoryClient inventory;
    //Map of the ordered items, Key - ItemID, Value - Item Quantity
    private final LinkedHashMap<String, Integer> order = new LinkedHashMap<>();
    private double orderPrice = 0;

    public Order(InventoryClient inventory) {
        this.inventory = inventory;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    //Might be bad to change the quantities of the items before payment, probably is

    protected void addItemToCart(String ID, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Invalid order quantity.");
        }
        //check if valid ID
        try {
            order.putIfAbsent(ID, order.getOrDefault(ID, 0) + quantity);
            inventory.tweakCart(ID, quantity);
            orderPrice = calculateOrderPrice();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    protected void removeItemFromCart(String ID, int quantity) {
        if (!order.containsKey(ID)) {
            throw new IllegalArgumentException("No such item in order.");
        }
        if (quantity > order.get(ID)) {
            throw new IllegalArgumentException("Cannot remove more than you have, you have " + order.get(ID) + " items with ID " + ID);
        }
        try {
            order.put(ID, order.get(ID) - quantity);
            inventory.tweakCart(ID, -quantity);
            orderPrice = calculateOrderPrice();
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    protected void emptyCart() {
        if (order.isEmpty()) {
            throw new IllegalArgumentException("Order is empty.");
        }
        System.out.println(order.toString());
        this.order.clear();
        this.orderPrice = 0;
    }

    private double calculateOrderPrice() {
        return this.order.entrySet().stream().map(i -> inventory.getItemPrice(i.getKey()) * i.getValue())
                .reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        order.forEach((key, value) -> sb.append("ID: ").append(key).append(" quantity: ").append(value).append("\n"));
        return sb.toString();
    }

}
