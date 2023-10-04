package view;

import java.util.Scanner;

import controller.MemberController;

public class UI {
  private Scanner scanner;
  private MemberController memberController;

  public UI(Scanner scanner, MemberController memberController) {
    this.scanner = scanner;
    this.memberController = memberController;
  }

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
          MemberManagement memberManagement = new MemberManagement(scanner, memberController);
          memberManagement.handleMemberManagement();
          break;
        case 2:
          // Call a method to handle Item Management
          new ItemManagement(scanner).handleItemManagement();
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
          System.out.println("Exiting the application.");
          scanner.close(); // Close the scanner before exiting
          System.exit(0);

        default:
          System.out.println("Invalid Choice. Please enter a valid option.");
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