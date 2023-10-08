package view;

import controller.ItemController;
import controller.MemberController;
import java.util.List;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.ItemCategory;
import model.Member;

/**
 * Class for Item UI.
 */
public class ItemManagement {
  private Scanner scanner;
  private ItemController itemController;
  private MemberController memberController;

  /**
   * Construcor for item ui.

   * @param originalController Member controller instance passed in.
   */
  public ItemManagement(MemberController originalController, ItemController itemController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.itemController = itemController;
    this.memberController = originalController;
  }

  /**
   * Method that handles user inpur.
   */
  public void handleItemManagement() {
    System.out.println("Item Management:");
    // item management logic
    while (true) {
      System.out.println("\nItem Management Menu:");
      System.out.println("1. Create Item");
      System.out.println("2. List all Items");
      System.out.println("3. Delete Item");
      System.out.println("4. Change an item information ");
      System.out.println("5. View an item Information");
      System.out.println("6. Back");

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
            final ItemCategory category = getCategoryFromUserInput();

            scanner.nextLine();

            System.out.print("Enter Item Name: ");
            final String name = scanner.nextLine();

            System.out.print("Enter Item Description: ");
            final String description = scanner.nextLine();

            System.out.print("Enter Cost Per Day: ");
            final int costPerDay = scanner.nextInt();

            scanner.nextLine();

            Item newItem = itemController.createItem(category, name, description, costPerDay, memberId);
            System.out.println("Item ID: " + newItem.getItemId());
            System.out.println("Item created successfully.");
          } else {
            System.out.println("Member not found with the specified memberId.");
          }
          break;
        case 2:
          List<String> allItems = itemController.getAllItems();

          for (String items : allItems) {
            // Display the member name as needed
            System.out.println("Item: " + items);
          }
          break;
        case 3:
          // Deletes an item by item ID
          System.out.print("Enter the items's ID to be deleted: ");
          String deleteId = scanner.nextLine();
          Item itemDelete = itemController.searchItem(deleteId);
          Member itemowner = itemDelete.getOwner();
          itemController.deleteItem(deleteId, itemowner.getMemberId());
          System.out.println(itemDelete.getName() + "successfully deleted! ");
          break;
        case 4:
          // Change Item information.
          changeItemInfo();
          break;
        case 5:
          viewItemInformation();
          break;
        case 6:
          return;

        default:
          throw new IllegalArgumentException("Invalid choice.");

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

  /**
   * Mehtod to promt user for a category choice.

   * @return Returns the category.
   */
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

  private void changeItemInfo() {
    System.out.print("Enter the Item's ID to change information: ");
    String changeId = scanner.nextLine();
    itemController.printItemInfo(changeId);

    while (true) {
      System.out.println("\nWhat information would you like to change? ");
      System.out.println("1. Change name");
      System.out.println("2. Change description");
      System.out.println("3. Change category");
      System.out.println("4. Change cost per day");
      System.out.println("5. Back");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();
      switch (choice) {
        case 1:
          // change the name
          System.out.print("Enter new name: ");
          String newName = scanner.nextLine();
          itemController.updateItemName(changeId, newName);
          break;
        case 2:
          // change the descritpion
          System.out.print("Enter new description of item: ");
          String newDesc = scanner.nextLine();
          itemController.updateItemDesc(changeId, newDesc);
          break;
        case 3:
          // change the Category
          ItemCategory newCategory = getCategoryFromUserInput();
          System.out.println("New Category: " + newCategory);
          itemController.updateItemCategory(changeId, newCategory);
          scanner.nextLine();
          break;
        case 4:
          // Change cost per day of item.
          System.out.print("Enter new cost per day: ");
          int newCost = scanner.nextInt();
          scanner.nextLine();
          itemController.updateCostPerDay(changeId, newCost);
          break;
        case 5:
          return;
        default:
          throw new IllegalArgumentException("Invalid input for changing item info.");
      }
    }
  }

  /**
   * Method to view an item's information including its contracts (historical and
   * future).
   */
  public void viewItemInformation() {
    System.out.print("Enter the Item's ID to view information: ");
    String itemId = scanner.nextLine();
    Item item = itemController.searchItem(itemId);

    if (item != null) {
      // Display item information
      itemController.printItemInfo(itemId);

      // Display item's contracts
      List<Contract> contracts = item.getContracts();
      if (!contracts.isEmpty()) {
        System.out.println("\n Contracts for this Item:");

        for (Contract contract : contracts) {
          System.out.println("Contract ID: " + contract.getContractId());
          System.out.println("Lender: " + contract.getLender().getName());
          System.out.println("Borrower: " + contract.getBorrower().getName());
          System.out.println("Start Date: " + contract.getStartDate());
          System.out.println("End Date: " + contract.getEndDate());
          System.out.println("Total Cost: " + contract.getTotalCost());
          System.out.println();
        }
      } else {
        System.out.println("No contracts found for this item.");
      }
    } else {
      System.out.println("Item with ID " + itemId + " not found.");
    }
  }
}