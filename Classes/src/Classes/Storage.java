package Classes;

import netscape.javascript.JSObject;

import java.util.ArrayList;

public class Storage {

    private int capacity;
    private ArrayList<Product> storage = new ArrayList<>();
    private double totalCost = 0;

    public Storage(int capacity)
    {
        this.capacity = capacity;
    }

    public void addProduct(Product product)
    {
        if(capacity < product.getQuantity())
        {
            System.out.println("No space for such a quantity");
            return;
        }
        this.storage.add(product);
        this.totalCost += product.getPrice()* product.getQuantity();
        this.capacity -= product.getQuantity();
    }

    public String getProducts()
    {
        StringBuilder productsToJson = new StringBuilder();
        productsToJson.append("[");
        for(Product product : storage)
        {
            productsToJson.append("\n");
            productsToJson.append("\t{\n" +
                    "\t\t\"name\": " + STR."\"\{product.getName()}\",\n" +
                    "\t\t\"price\": " + STR."\"\{product.getPrice()}\",\n" +
                    "\t\t\"quantity\": " + STR."\"\{product.getQuantity()}\"\n");
            productsToJson.append((product == storage.getLast()) ? "\t}" : "\t},");
        }
        productsToJson.append("\n]");

        return productsToJson.toString();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getCapacity() {
        return capacity;
    }
}
