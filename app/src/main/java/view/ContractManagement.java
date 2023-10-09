package view;

import controller.ContractController;
import controller.ItemController;
import controller.MemberController;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.Member;

/**
 * Class for contract UI stuff.
 */
public class ContractManagement {
  private Scanner scanner;
  private ItemController itemController;
  private MemberController memberController;
  private ContractController contractController;

  /**
   * Constructor for contract management.

   * @param originalController Pass in the member controller.
   * @param itemController Pass in the item controller.
   * @param time Pass in the time.
   */
  public ContractManagement(MemberController originalController, ItemController itemController, ContractController contractController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.itemController = itemController;
    this.memberController = originalController;
    this.contractController = contractController;

  }

  /**
   * Handles the contract management user interface.
   */
  public void handleContractManagement() {
    System.out.println("Contract Management:");

    while (true) {
      System.out.println("\nContract Management Menu:");
      System.out.println("1. Create a new lending contract");
      System.out.println("2. List all contracts");
      System.out.println("3. Back");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();
      switch (choice) {
        case 1:
          // Create Contract.
          System.out.println("Creating a new contract...\n");
          System.out.print("Enter member ID of the Borrower: ");
          String borrowerMemberId = scanner.nextLine();
          Member borrower = memberController.searchMember(borrowerMemberId);

          if (borrower != null) {
            System.out.print("Enter Item ID of the item to borrow: ");
            final String itemId = scanner.nextLine();

            System.out.print("Enter the day of return: ");
            final int endDate = getIntInput();

            Item item = itemController.searchItem(itemId);
            if (item != null) {
              Member lender = item.getOwner();

              Contract newContract = contractController.createContract(borrower, lender, item, endDate);
              if (newContract != null) {
                System.out.println("Contract created successfully. Contract ID: " + newContract.getContractId());
              } else {
                System.out.println(
                    "Failed to create a contract."
                      + "Check if the lender has enough credits or the item is not available.");
              }
            } else {
              System.out.println("Item not found with the specified item ID.");
            }
          } else {
            System.out.println("Borrower not found with the specified member ID.");
          }
          break;
        case 2:
          contractController.listAllContracts();
          break;
        case 3:
          return; // Go back to the main menu.
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  /**
   * Reads an integer input from the user.
   *
   * @return The integer input from the user.
   */
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