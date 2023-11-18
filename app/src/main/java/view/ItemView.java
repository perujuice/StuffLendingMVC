package view;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.ItemCategory;

/**
 * Class for Item UI.
 */
public class ItemView {
  private Scanner scanner;

  public ItemView() {
    this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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

  /**
   * Method to display change options.
   */
  public void displayChange() {
    System.out.println("\nWhat information would you like to change? ");
    System.out.println("1. Change name");
    System.out.println("2. Change description");
    System.out.println("3. Change category");
    System.out.println("4. Change cost per day");
    System.out.println("5. Back");

    System.out.print("\nEnter your choice: ");
  }

  /**
   * Prompts for email.

   * @return The email.
   */
  public String promtMemberEmail() {
    System.out.print("Enter the owners email: ");
    String ownerEmail = scanner.nextLine();
    return ownerEmail;
  }

  /**
   * Getting the itemId from user input.

   * @return Item Id.
   */
  public String promtItemId() {
    System.out.print("Enter the Item's ID: ");
    String itemId = scanner.nextLine();
    return itemId;
  }

  /**
   * Getting item name from user input.

   * @return Item name.
   */
  public String promptItemName() {
    System.out.print("Enter Item Name: ");
    String name = scanner.nextLine();
    return name;
  }

  /**
   * Getting item description from user input.

   * @return  Item description.
   */
  public String promptItemDesc() {
    System.out.print("Enter Item Description: ");
    String description = scanner.nextLine();
    return description;
  }

  /**
   * Getting item cost from user input.

   * @return  Item cost.
   */
  public int promptsItemCost() {
    System.out.print("Enter Cost Per Day: ");
    int costPerDay = scanner.nextInt();
    scanner.nextLine();
    return costPerDay;
  }
  
  /**
   * Method creating the item from user input.
   */
  public boolean displayItemCreate(Item newItem) {
    System.out.println("Item ID: " + newItem.getItemId());
    System.out.println("Item created successfully.");
    return true;
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
   * Display the items.
   */
  public void displayItemList(List<String> allItems) {
    for (String items : allItems) {
      // Display the member name as needed
      System.out.println("Item: " + items);
    }
  }

  /**
   * Delete a specific item from user input.
   */
  public void displayItemDelete(Item itemDelete) {
    System.out.println(itemDelete.getName() + "successfully deleted! ");
  }


  /**
   * Get the name to change from the user.

   * @param changeId the Id of the item.
   */
  public String promptChangeName(String changeId) {
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    return newName;
  }

  /**
   * Method to get the new description from user.

   * @param changeId Item Id.
   */
  public String promptChangeDesc(String changeId) {
    System.out.print("Enter new Description: ");
    String newDesc = scanner.nextLine();
    return newDesc;
  }
  
  /**
   * Method to get the new category from user.

   * @param changeId Item Id.
   */
  public ItemCategory promptChangeCategory(String changeId) {
    ItemCategory newCategory = getCategoryFromUserInput();
    System.out.println("New Category: " + newCategory);
    scanner.nextLine();
    return newCategory;
  }

  /**
   * Method to get the new cost from user.

   * @param changeId Item Id.
   */
  public int promptChangeCost(String changeId) {
    System.out.print("Enter new cost per day: ");
    int newCost = scanner.nextInt();
    scanner.nextLine();
    return newCost;
  }

  /**
   * Method to view an item's information including its contracts (historical and
   * future).
   */
  public void viewItemInformation(Item item, String itemId, List<Contract> contracts) {
    if (item != null) {
      // Display item information
      printItemInfo(item, itemId);

      // Display item's contracts
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
  public void printItemInfo(Item item, String itemId) {
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

  /**
   * Get the input from the user.

   * @return The input.
   */
  public int getIntInput() {
    int input = -1;
    try {
      input = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      // Invalid input; do nothing, the loop will prompt again.
    }
    return input;
  }
}