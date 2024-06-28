package InventoryManagementSystem.Classes;

import java.util.LinkedHashMap;

public class Order {

    private InventoryClient inventory;
    private LinkedHashMap<String, Integer> order = new LinkedHashMap<>();
    private double orderPrice;

    public Order(InventoryClient inventory) {
        this.inventory = inventory;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    //Might be bad to change the quantities of the items before payment, probably is

    public void addItemToCart(String ID, int quantity)
    {
        try {
            inventory.tweakCart(ID, quantity, "remove", orderPrice);
            order.putIfAbsent(ID, order.getOrDefault(ID, 0) + quantity);
        }
        catch (IllegalArgumentException ex)
        {
            System.err.println(ex);
        }
    }

    public void removeItemFromCart(String ID, int quantity)
    {
        if(!order.containsKey(ID))
        {
            throw new IllegalArgumentException("No such item in order.");
        }
        if(quantity > order.get(ID))
        {
            throw new IllegalArgumentException("Cannot remove more than you have, you have " + order.get(ID) + " items with ID " + ID);
        }
        try {
            orderPrice = inventory.tweakCart(ID, quantity, "add", orderPrice);
            order.put(ID, order.get(ID) - quantity);

        }
        catch (IllegalArgumentException ex)
        {
            System.err.println(ex);
        }
    }
}
