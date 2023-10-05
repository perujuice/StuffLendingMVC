package view;

import controller.MemberController;
import java.util.Scanner;

/**
 * Main UI class.
 */
public class UserInterface {
  private Scanner scanner;
  private MemberController memberController;

  /**
   * Constructor for the main UI.

   * @param memberController Member controller instance.
   */
  public UserInterface(MemberController memberController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.memberController = memberController;
  }

  /**
   * Main display menu.
   */
  public void displayMenu() {
    System.out.println("Welcome to the Stuff Lending System!");

    while (true) {
      System.out.println("\nMain Menu:");
      System.out.println("1. Member Management");
      System.out.println("2. Item Management");
      System.out.println("3. Contract Management");
      System.out.println("4. Advance Time");
      System.out.println("5. Exit");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();

      switch (choice) {
        case 1:
          // Member Management
          MemberManagement memberManagement = new MemberManagement(memberController);
          memberManagement.handleMemberManagement();
          break;
        case 2:
          // Call a method to handle Item Management
          ItemManagement itemManagement = new ItemManagement(memberController);
          itemManagement.handleItemManagement();
          break;
        case 3:
          // Call a method to handle Contract Management
          new ContractManagement().handleContractManagement();
          break;
        case 4:
          // Call a method to handle advancing time
          new TimeManagement().advanceTime();
          break;
        case 5:
          System.out.println("Exiting the application...");
          scanner.close();
          throw new RuntimeException("Application has been terminated.");
        default:
          throw new IllegalArgumentException("Invalid input from user. ");
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

}