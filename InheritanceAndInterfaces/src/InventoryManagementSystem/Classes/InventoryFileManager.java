package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public abstract class InventoryFileManager {

    protected InventoryFileManager() {

    }

    //Writes an Inventory in the structure of a Map to a file
    protected static void writeInventoryToFile(Map<String, InventoryItem> inventory, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (var item : inventory.entrySet()) {
                bw.write(item.getValue().toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Some IO ex occurred.");
        }
    }

    //Reads an Inventory in the structure of a Map from a file and returns it
    protected static Map<String, InventoryItem> readInventoryFromFile(String fileName) throws IOException {
        Map<String, InventoryItem> inventory = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                InventoryItem item = fromFileFormat(line);
                inventory.put(item.getID(), item);
            }
            return inventory;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Nonexistent dir " + fileName);
        } catch (IOException e) {
            throw new IOException("Some IO ex occurred.");
        }
    }

    //Helper method to parse lines read from files, checks if the format is correct
    private static InventoryItem fromFileFormat(String line) {
        String[] itemFields = line.split("~~~");
        if (itemFields.length != 12) {
            throw new IllegalArgumentException("Invalid line format for line:\n" + line);
        }
        return new InventoryItem(itemFields[0], itemFields[1], ItemType.valueOf(itemFields[2]), itemFields[3],
                Double.parseDouble(itemFields[4]), Double.parseDouble(itemFields[5]), Boolean.parseBoolean(itemFields[6]),
                Boolean.parseBoolean(itemFields[7]), Boolean.parseBoolean(itemFields[8]), Boolean.parseBoolean(itemFields[9]),
                itemFields[10], Integer.parseInt(itemFields[11]));
    }
}
