package InventoryManagementSystem.Interfaces;

public interface Breakable {

    boolean checkIfBreakable();

    void handleItemBreakage();

    boolean isBroken();
}
