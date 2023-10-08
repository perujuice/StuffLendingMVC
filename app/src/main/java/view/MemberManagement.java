package view;

import controller.ItemController;
import controller.MemberController;
import java.util.Scanner;
import model.ItemCategory;
import model.Member;

/**
 * Class for member UI.
 */
public class MemberManagement {
  private Scanner scanner;
  private MemberController memberController;
  private ItemController itemController;

  /**
   * Constructor for member UI class.

   * @param originalController Member controller instance passed for persistance.
   */
  public MemberManagement(MemberController originalController, ItemController itemController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.memberController = originalController;
    this.itemController = itemController;

  }

  /**
   * Method for user input.
   */
  public void handleMemberManagement() {
    System.out.println("Member Management:");
    // member management logic
    while (true) {
      System.out.println("\nMember Management Menu:");
      System.out.println("1. Create member");
      System.out.println("2. Delete member");
      System.out.println("3. View member information");
      System.out.println("4. Change member information");
      System.out.println("5. List all memebers in a simple way");
      System.out.println("6. List all members in a verbose way ");
      System.out.println("7. Back");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();

      switch (choice) {
        case 1:
          // Create Member.
          System.out.println("Creating a new member...\n");
          System.out.print("Enter the member's name: ");
          final String name = scanner.nextLine();

          System.out.print("Enter the member's email: ");
          final String email = scanner.nextLine();

          System.out.print("Enter the member's phone number: ");
          final int phoneNr = scanner.nextInt();

          scanner.nextLine();
          // creat instance create a new member
          // MemberController memberController = new MemberController();
          Member newMember = memberController.createMember(name, email, phoneNr);

          // Print a confirmatiom message
          System.out.println("New member created with Member ID: " + newMember.getMemberId());
          break;

        case 2:
          // Deletes a member by member ID
          System.out.print("Enter the member's ID to be deleted: ");
          String deleteId = scanner.nextLine();
          memberController.deleteMember(deleteId);
          System.out.println("Member successfully deleted! ");
          break;

        case 3:
          // View member information
          // This probably has to be updated to show more information!
          System.out.print("Enter the member's ID to view information: ");
          String viewId = scanner.nextLine();
          memberController.printMemberInfo(viewId);
          break;

        case 4:
          // Change member information by member ID
          changeMemberInfo();
          break;
        case 5:
          // list all member info in a simple way.
          memberController.printAllMemberInfo();
          break;
        case 6:
          memberController.listAllMembersVerbose();
          break;
        case 7:
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

  private void changeMemberInfo() {
    System.out.print("Enter the member's ID to change information: ");
    String changeId = scanner.nextLine();
    memberController.printMemberInfo(changeId);

    while (true) {
      System.out.println("\nWhat information would you like to change? ");
      System.out.println("1. Change name");
      System.out.println("2. Change Email");
      System.out.println("3. Change Phone Number");
      System.out.println("4. Back");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();
      switch (choice) {
        case 1:
          // change the name
          System.out.print("Enter new name: ");
          String newName = scanner.nextLine();
          memberController.updateMemberName(changeId, newName);
          break;
        case 2:
          // change the email
          System.out.print("Enter new email: ");
          String newEmail = scanner.nextLine();
          memberController.updateMemberEmail(changeId, newEmail);
          break;
        case 3:
          // change the phone number
          System.out.print("Enter new phone number: ");
          int newPhoneNr = scanner.nextInt();
          memberController.updateMemberPhoneNr(changeId, newPhoneNr);
          scanner.nextLine(); // Just to consumer the next line.
          break;
        case 4:
          return;
        default:
          throw new IllegalArgumentException("Invalid input.");
      }
    }
  }

  /**
   * This is just some data for persistance.
   */
  public void data() {
    Member member1 = memberController.createMember("John", "john@example.com", 1234567890);
    Member member2 = memberController.createMember("Alice", "alice@example.com", 986543210);
    Member member3 = memberController.createMember("Bob", "bob@example.com", 555555555);
    Member member4 = memberController.createMember("Eve", "eve@example.com", 999999999);
    Member member5 = memberController.createMember("Charlie", "charlie@example.com", 777777777);
    Member member6 = memberController.createMember("Mallory", "mallory@example.com", 888888888);

    itemController.createItem(ItemCategory.TOOL, "Hammer", "Works fine! ", 100, member1.getMemberId());
    itemController.createItem(ItemCategory.TOOL, "Hammer", "Works fine! ", 100, member2.getMemberId());
    itemController.createItem(ItemCategory.VEHICLE, "Car", "Runs smoothly", 500, member1.getMemberId());
    itemController.createItem(ItemCategory.GAME, "Board Game", "Fun for the family", 20, member4.getMemberId());
    itemController.createItem(ItemCategory.TOY, "Action Figure", "Collectible toy", 15, member3.getMemberId());
    itemController.createItem(ItemCategory.SPORT, "Basketball", "High-quality ball", 30, member2.getMemberId());
    itemController.createItem(ItemCategory.OTHER, "Book", "Bestseller novel", 10, member5.getMemberId());
    itemController.createItem(ItemCategory.TOOL, "Drill", "Powerful drill", 150, member6.getMemberId());
    itemController.createItem(ItemCategory.VEHICLE, "Bicycle", "Great for commuting", 200, member4.getMemberId());
    itemController.createItem(ItemCategory.GAME, "Video Game", "Exciting gameplay", 40, member2.getMemberId());
    itemController.createItem(ItemCategory.TOY, "Puzzle", "Challenging puzzle", 25, member6.getMemberId());
    itemController.createItem(ItemCategory.SPORT, "Soccer Ball", "Official size", 25, member3.getMemberId());
    itemController.createItem(ItemCategory.OTHER, "Cookware Set", "High-quality pots", 75, member4.getMemberId());
    itemController.createItem(ItemCategory.TOOL, "Screwdriver Set", "Versatile tools", 30, member3.getMemberId());
    itemController.createItem(ItemCategory.VEHICLE, "Scooter", "Fuel-efficient", 300, member6.getMemberId());
    itemController.createItem(ItemCategory.GAME, "Chess Set", "Classic strategy game", 15, member1.getMemberId());
  }
}