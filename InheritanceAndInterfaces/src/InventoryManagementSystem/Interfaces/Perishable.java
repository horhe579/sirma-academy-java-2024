package InventoryManagementSystem.Interfaces;

public interface Perishable {

    boolean checkIfPerishable();

    void handleItemExpiration();

    boolean isPerished();
}
