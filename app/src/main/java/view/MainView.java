package view;

import controller.ContractController;
import controller.ItemController;
import controller.MemberController;
import java.util.Scanner;
import model.TimeManager;

/**
 * Main UI class.
 */
public class MainView {
  private Scanner scanner;
  private MemberController memberController;
  private ItemController itemController;
  private ContractController contractController;
  private TimeManager time;

  /**
   * Constructor for the main UI.

   * @param memberController Member controller instance.
   */
  public MainView(MemberController memberController, 
      ItemController itemController, ContractController contractController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.memberController = memberController;
    this.itemController = itemController;
    this.contractController = contractController;
    this.time = new TimeManager();

  }

  /**
   * Main display menu.
   */
  public void displayMainMenu() {
    System.out.println("Welcome to the Stuff Lending System!");
    System.out.println("Current day: " + time.getCurrentDay());

    System.out.println("\nMain Menu:");
    System.out.println("1. Member Management");
    System.out.println("2. Item Management");
    System.out.println("3. Contract Management");
    System.out.println("4. Advance Time");
    System.out.println("5. Exit");

    System.out.print("\nEnter your choice: ");
  }


  public void displayMenu() {
    System.out.println("Welcome to the Stuff Lending System!");
    System.out.println("Current day: " + time.getCurrentDay());

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
          MemberView memberManagement = new MemberView(memberController);
          memberManagement.handleMemberManagement();
          break;
        case 2:
          // Call a method to handle Item Management
          ItemView itemManagement = new ItemView(memberController, itemController);
          itemManagement.handleItemManagement();
          break;
        case 3:
          // Call a method to handle Contract Management
          new ContractView(memberController, itemController, contractController).handleContractManagement();
          break;
        case 4:
          // Call a method to handle advancing time
          time.advanceDay();
          System.out.println("Current day: " + time.getCurrentDay());
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