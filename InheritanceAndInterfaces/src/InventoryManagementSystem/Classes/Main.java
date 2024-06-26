package InventoryManagementSystem.Classes;

import InventoryManagementSystem.Enums.ItemType;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static int userInputsCount = 0;
    private static InventoryClient client = new InventoryClient();
    private static Payment payment = new Payment(100000, client);
    //private static Order order = new Order(client);

    public static void main(String[] args) {
        handleUserInput();
    }

    private static void handleUserInput() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                try {
                    if (userInputsCount % 2 == 0) {
                        displayMenu();
                    }
                    String userInput = sc.nextLine().trim();
                    if (!isValidUserInput(userInput)) {
                        System.err.println("Invalid input.");
                    }
                    readUserInput(client, Integer.parseInt(userInput), sc);
                    userInputsCount++;
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item by ID");
        System.out.println("3. Display List of Items");
        System.out.println("4. Categorize Items");
        System.out.println("5. Add Item to Order");
        System.out.println("6. Remove Item from Order");
        System.out.println("7. Place Order");
        System.out.println("8. Load Inventory from File");
        System.out.println("9. Save Inventory to File");
        System.out.println("10. Exit");
    }


    private static boolean isValidUserInput(String input) {
        return input.matches("[1-9]|10");
    }

    private static void readUserInput(InventoryClient client, int choice, Scanner sc) {
        try {
            switch (choice) {
                case 1:
                    handleItemCreation(sc, client);
                    break;
                case 2:
                    handleItemRemoval(sc, client);
                    break;
                case 3:
                    handleListInventory(sc, client);
                    break;
                case 4:
                    handleCategorizeItems(sc, client);
                    break;
                case 5:
                    handleAddItemToOrder(sc);
                    break;
                case 6:
                    handleRemoveItemFromOrder(sc);
                    break;
                case 7:
                    handlePlaceOrder(sc, client);
                    break;
                case 8:
                    handleReadFromDir(sc, client);
                    break;
                case 9:
                    handleWriteToDir(sc, client);
                    break;
                case 10:
                    System.exit(0);

                default:
                    System.err.println("Invalid choice. Please try again.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    private static void handleRemoveItemFromOrder(Scanner sc) {
        System.out.print("Enter the ID of the item to remove from the cart:");
        String ID = sc.nextLine();
        System.out.print("Enter the quantity you want to remove:");
        int quantity = Integer.parseInt(sc.nextLine());
        payment.removeItemFromCart(ID, quantity);
        payment.printOrder();
    }

    private static void handleAddItemToOrder(Scanner sc) {
        System.out.print("Enter the ID of the item to add to the cart:");
        String ID = sc.nextLine();
        System.out.print("Enter the quantity you want to order:");
        int quantity = Integer.parseInt(sc.nextLine());
        payment.addItemToCart(ID, quantity);
        payment.printOrder();
    }

    private static void handleItemCreation(Scanner sc, InventoryClient cli) {
        String description = null, details = null, category = null;
        ItemType type = null;
        double weight = 0, price = 0;
        boolean broken = false, perished = false;
        int quantity = 0;
        boolean isInvalidInput = true;

        while (isInvalidInput) {
            try {
                System.out.print("Item description: ");
                description = sc.nextLine().trim();

                System.out.print("Item details: ");
                details = sc.nextLine().trim();


                System.out.print("Item type (FRAGILE | GROCERY | ELECTRONICS): ");
                while (true) {
                    try {
                        type = ItemType.valueOf(sc.nextLine().trim().toUpperCase());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.err.println("Invalid item type. Please enter one of the following: FRAGILE, GROCERY, ELECTRONICS.");
                    }
                }

                System.out.print("Item category: ");
                category = sc.nextLine().trim();


                System.out.print("Item weight: ");
                while (true) {
                    try {
                        weight = Double.parseDouble(sc.nextLine().trim());
                        if (weight < 500 && weight > 0) {
                            break;
                        }
                        System.err.println("Enter a valid number between 1 and 500");
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input. Please enter a valid number.");
                    }
                }

                System.out.print("Item price: ");
                while (true) {
                    try {
                        price = Double.parseDouble(sc.nextLine().trim());
                        if (price > 0) {
                            break;
                        }
                        System.err.println("Enter a valid price above 0");
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input. Please enter a valid number.");
                    }
                }

                System.out.print("Item isBroken (true | false): ");
                while (true) {
                    String input = sc.nextLine().trim().toLowerCase();
                    if (input.equals("true") || input.equals("false")) {
                        broken = Boolean.parseBoolean(input);
                        break;
                    } else {
                        System.err.println("Invalid input. Please enter true or false.");
                    }
                }

                System.out.print("Item isPerished (true | false): ");
                while (true) {
                    String input = sc.nextLine().trim().toLowerCase();
                    if (input.equals("true") || input.equals("false")) {
                        perished = Boolean.parseBoolean(input);
                        break;
                    } else {
                        System.err.println("Invalid input. Please enter true or false.");
                    }
                }

                System.out.print("Item quantity: ");
                while (true) {
                    try {
                        quantity = Integer.parseInt(sc.nextLine().trim());
                        if (quantity > 0) {
                            break;
                        }
                        System.err.println("Enter a valid quantity above 0");
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid input. Please enter a valid number.");
                    }
                }

                isInvalidInput = false;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        cli.addItem(description, details, type, category, weight, price, broken, perished, quantity);
    }


    private static void handleItemRemoval(Scanner sc, InventoryClient cli) {
        System.out.print("Remove item with ID: ");
        String ID = sc.nextLine();
        cli.removeItemByID(ID);
    }

    private static void handleListInventory(Scanner sc, InventoryClient cli) {
        System.out.print("List to display(inventory/i OR discounted/d): ");
        String listToString = cli.displayItemInventory(sc.nextLine().toLowerCase(Locale.US).trim());
        while (listToString == null) {
            listToString = cli.displayItemInventory(sc.nextLine().toLowerCase(Locale.US).trim());
        }
        System.out.println(listToString);;
    }

    private static void handleCategorizeItems(Scanner sc, InventoryClient cli) {
        System.out.println("Categorize by category:");
        String categorizeBy = sc.nextLine();
        cli.categorizeItems(categorizeBy);
    }

    private static void handlePlaceOrder(Scanner sc, InventoryClient cli) {
        try {
            payment.completeOrderPayment();
            //payment.printOrder();
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }

    private static void handleReadFromDir(Scanner sc, InventoryClient cli) {
        System.out.println("Write the directory of the txt file you want to load an inventory from:");
        while (true) {
            try {
                String loadFrom = sc.nextLine();
                cli.loadInventoryFromFile(loadFrom);
                break;
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private static void handleWriteToDir(Scanner sc, InventoryClient cli) {
        System.out.println("Write the directory of the txt file you want to save this inventory to:");
        while (true) {
            try {
                String loadTo = sc.nextLine();
                cli.saveInventoryToFile(loadTo);
                break;
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }
}



