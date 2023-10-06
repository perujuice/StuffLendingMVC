package view;

import java.util.List;
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
    this.timeManager = time;
    this.contractController = new ContractController(originalController, itemController, timeManager);

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
                    "Failed to create a contract. Check if the lender has enough credits or the item is not available.");
              }
            } else {
              System.out.println("Item not found with the specified item ID.");
            }
          } else {
            System.out.println("Borrower not found with the specified member ID.");
          }
          break;
        case 2:
          listAllContracts();
          return;
        default:
          throw new IllegalArgumentException("Invalid choice.");
      }
    }
  }

  private void listAllContracts() {
    List<Contract> contracts = contractController.getAllContracts();

    if (contracts.isEmpty()) {
      System.out.println("No contracts found.");
    } else {
      System.out.println("\nList of all contracts:");
      for (Contract contract : contracts) {
        System.out.println("Contract ID: " + contract.getContractId());
        System.out.println("Lender: " + contract.getLender().getName());
        System.out.println("Borrower: " + contract.getBorrower().getName());
        System.out.println("Item: " + contract.getItem().getName());
        System.out.println("Start Date: " + contract.getStartDate());
        System.out.println("End Date: " + contract.getEndDate());
        System.out.println("Total Cost: " + contract.getTotalCost());
        System.out.println();
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