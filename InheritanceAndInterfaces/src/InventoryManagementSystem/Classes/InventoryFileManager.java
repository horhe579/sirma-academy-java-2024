package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InventoryFileManager {


    public static void writeInventoryToFile(Map<String, InventoryItem> inventory, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (var item : inventory.entrySet()) {
                bw.write(item.getValue().toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new IOException("Some IO ex occurred.");
        }
    }

    public static Map<String, InventoryItem> readInventoryFromFile(String fileName) throws IOException {
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

    public static InventoryItem fromFileFormat(String line) {
        String[] itemFields = line.split("~~~");
        if (itemFields.length != 12)
        {
            throw new IllegalArgumentException("Invalid line format for line:\n" + line);
        }
        return new InventoryItem(itemFields[0], itemFields[1], ItemType.valueOf(itemFields[2]), itemFields[3],
                Double.parseDouble(itemFields[4]), Double.parseDouble(itemFields[5]), Boolean.valueOf(itemFields[6]),
                Boolean.valueOf(itemFields[7]), Boolean.valueOf(itemFields[8]), Boolean.valueOf(itemFields[9]),
                itemFields[10], Integer.parseInt(itemFields[11]));
    }
}
