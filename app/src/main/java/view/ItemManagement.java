package view;

import controller.ItemController;
import controller.MemberController;
import model.ItemCategory;
import model.Member;

import java.util.List;
import java.util.Scanner;

public class ItemManagement {
    private Scanner scanner;
    private ItemController itemController;
    private MemberController memberController;

    public ItemManagement(Scanner scanner, MemberController memberController) {
        this.scanner = scanner;
        this.itemController = new ItemController(memberController);
        this.memberController = memberController;
    }

    public void handleItemManagement() {
        System.out.println("Item Management:");
        // item management logic
        while (true) {
            System.out.println("\nItem Management Menu:");
            System.out.println("1. Create Item");
            System.out.println("2. List all Items");
            System.out.println("3. Back");

            System.out.print("\nEnter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    // Create Item.
                    System.out.println("Creating a new Item...\n");
                    System.out.print("Enter member ID of the owner: ");
                    String memberId = scanner.nextLine();
                    Member owner = memberController.searchMember(memberId);

                    if (owner != null) {
                        ItemCategory category = getCategoryFromUserInput();

                        scanner.nextLine();

                        System.out.print("Enter Item Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Item Description: ");
                        String description = scanner.nextLine();

                        System.out.print("Enter Cost Per Day: ");
                        int costPerDay = scanner.nextInt();

                        scanner.nextLine();

                        itemController.createItem(category, name, description, costPerDay, memberId);
                        System.out.println("Item created successfully.");
                    } else {
                        System.out.println("Member not found with the specified memberId.");
                    }
                    break;
                case 2:
                    List<String> allItems = itemController.getAllItems();

                    //
                    for (String Items : allItems) {
                        // Display the member name as needed
                        System.out.println("Item: " + Items);
                    }
                    break;
                case 3:
                    return;

            }
        }

    }

    private int getIntInput() {
        int input = -1;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Invalid input; do nothing, the loop will prompt again.
        }
        return input;
    }

    public ItemCategory getCategoryFromUserInput() {
        System.out.println("Enter Item Category: ");
        System.out.println("1. Tool");
        System.out.println("2. Vehicle");
        System.out.println("3. Game");
        System.out.println("4. Toy");
        System.out.println("5. Sport");
        System.out.println("6. Other");

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        } while (choice < 1 || choice > 6);

        switch (choice) {
            case 1:
                return ItemCategory.TOOL;
            case 2:
                return ItemCategory.VEHICLE;
            case 3:
                return ItemCategory.GAME;
            case 4:
                return ItemCategory.TOY;
            case 5:
                return ItemCategory.SPORT;
            case 6:
                return ItemCategory.OTHER;
            default:
                throw new IllegalArgumentException("Invalid choice.");
        }
    }
}