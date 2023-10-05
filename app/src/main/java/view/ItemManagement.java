package view;

import controller.ItemController;
import controller.MemberController;
import java.util.List;
import java.util.Scanner;
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
  public ItemManagement(MemberController originalController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.itemController = new ItemController(new MemberController(originalController));
    this.memberController = new MemberController(originalController);
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
            final ItemCategory category = getCategoryFromUserInput();

            scanner.nextLine();

            System.out.print("Enter Item Name: ");
            final String name = scanner.nextLine();

            System.out.print("Enter Item Description: ");
            final String description = scanner.nextLine();

            System.out.print("Enter Cost Per Day: ");
            final int costPerDay = scanner.nextInt();

            scanner.nextLine();

            itemController.createItem(category, name, description, costPerDay, memberId);
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
}