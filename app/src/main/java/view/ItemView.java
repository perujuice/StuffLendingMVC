package view;

import java.util.List;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.ItemCategory;
import model.ItemRegistry;
import model.Member;
import model.MemberRegistry;

/**
 * Class for Item UI.
 */
public class ItemView {
  private Scanner scanner;
  private MemberRegistry memberRegistry;
  private ItemRegistry itemRegistry;

  public ItemView(Scanner scanner) {
    this.scanner = scanner;
  }

/**
   * Method that handles user inpur.
   */
  public void displayItemMenu() {
    System.out.println("\nItem Management Menu:");

    System.out.println("1. Create Item");
    System.out.println("2. List all Items");
    System.out.println("3. Delete Item");
    System.out.println("4. Change an item information ");
    System.out.println("5. View an item Information");
    System.out.println("6. Back");

    System.out.print("\nEnter your choice: ");
  }

  public void displayChange() {
    System.out.println("\nWhat information would you like to change? ");
    System.out.println("1. Change name");
    System.out.println("2. Change description");
    System.out.println("3. Change category");
    System.out.println("4. Change cost per day");
    System.out.println("5. Back");

    System.out.print("\nEnter your choice: ");
  }

  public String promtMemberEmail() {
    System.out.print("Enter the member's Email to change information: ");
    String ownerEmail = scanner.nextLine();
    return ownerEmail;
  }

  public void itemCreateInput() {
    String email = promtMemberEmail();
    Member owner = memberRegistry.searchMember(email);
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

      Item newItem = itemRegistry.createItem(category, name, description, costPerDay, email);
      System.out.println("Item ID: " + newItem.getItemId());
      System.out.println("Item created successfully.");
    } else {
      System.out.println("Member not found with the specified memberId.");
    }
  }

  public void displayItemList() {
    List<String> allItems = itemRegistry.getAllItems();
    for (String items : allItems) {
      // Display the member name as needed
      System.out.println("Item: " + items);
    }
  }

  public void promtItemDelete() {
    System.out.print("Enter the items's ID to be deleted: ");
    String deleteId = scanner.nextLine();
    Item itemDelete = itemRegistry.searchItem(deleteId);
    Member itemowner = itemDelete.getOwner();
    itemRegistry.deleteItem(deleteId, itemowner.getMemberId());
    System.out.println(itemDelete.getName() + "successfully deleted! ");
  }

  public int getIntInput() {
    int input = -1;
    try {
      input = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      // Invalid input; do nothing, the loop will prompt again.
    }
    return input;
  }

  public String promtItemId() {
    System.out.print("Enter the Item's ID to change information: ");
    String changeId = scanner.nextLine();
    printItemInfo(changeId);
    return changeId;
  }


  public void promptChangeName(String changeId) {
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    itemRegistry.updateItemName(changeId, newName);
  }

  public void promptChangeDesc(String changeId) {
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    itemRegistry.updateItemName(changeId, newName);
  }
  
  public void promptChangeCategory(String changeId) {
    ItemCategory newCategory = getCategoryFromUserInput();
    System.out.println("New Category: " + newCategory);
    itemRegistry.updateItemCategory(changeId, newCategory);
    scanner.nextLine();
  }

  public void promptChangeCost(String changeId) {
    System.out.print("Enter new cost per day: ");
    int newCost = scanner.nextInt();
    scanner.nextLine();
    itemRegistry.updateCostPerDay(changeId, newCost);
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

  /**
   * Method to view an item's information including its contracts (historical and
   * future).
   */
  public void viewItemInformation() {
    System.out.print("Enter the Item's ID to view information: ");
    String itemId = scanner.nextLine();
    Item item = itemRegistry.searchItem(itemId);

    if (item != null) {
      // Display item information
      printItemInfo(itemId);

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

  /**
   * Method to print information about an item.
   *
   * @param itemId The ID of the item to retrieve information for.
   */
  public void printItemInfo(String itemId) {
    Item item = itemRegistry.searchItem(itemId);

    if (item != null) {
      System.out.println("\nItem Information:");
      System.out.println("Name: " + item.getName());
      System.out.println("Short Description: " + item.getShortDescription());
      System.out.println("Category: " + item.getCategory());
      System.out.println("Cost per day: " + item.getCostPerDay());
    } else {
      System.out.println("Item with ID " + itemId + " not found.");
    }
  }
}