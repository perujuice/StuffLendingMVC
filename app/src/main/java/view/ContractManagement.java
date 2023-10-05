package view;

import java.util.Scanner;
import controller.ContractController;
import controller.ItemController;
import controller.MemberController;
import model.Contract;
import model.Item;
import model.Member;
import model.TimeManager;

/**
 * Class for contract UI stuff.
 */
public class ContractManagement {
  private Scanner scanner;
  private ItemController itemController;
  private MemberController memberController;
  private ContractController contractController;
  private TimeManager timeManager;

  public ContractManagement(MemberController originalController, ItemController itemController, TimeManager time) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.itemController = itemController;
    this.memberController = originalController;
    this.contractController = new ContractController(originalController, itemController, timeManager);
    this.timeManager = time;
  }

  public void handleContractManagement() {
    System.out.println("Contract Management:");

    // Contract management logic

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
          System.out.println("Creating a new Item...\n");
          System.out.print("Enter member ID of the Borrower: ");
          String borrowerMemberId = scanner.nextLine();
          Member borrower = memberController.searchMember(borrowerMemberId); //5V4E78

          if (borrower != null) {
            System.out.print("Enter Item ID of the item to borrow: ");
            final String itemId = scanner.nextLine();
            
            System.out.print("Enter the day of return: ");
            final int endDate = scanner.nextInt();

            scanner.nextLine();

            Item item = itemController.searchItem(itemId);
            Member lender = item.getOwner();

            Contract newContract = contractController.createContract(borrower, lender, item, endDate);
            System.out.println("Item ID: " + newContract.getContractId());

          } else {
            System.out.println("Borrower not found with the specified memberId.");
          }
            break;
          case 2:
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
}