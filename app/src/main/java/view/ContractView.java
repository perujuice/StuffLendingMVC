package view;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import model.Contract;

/**
 * Class for contract UI stuff.
 */
public class ContractView {
  private Scanner scanner;

  public ContractView() {
    this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
  }

  /**
   * Displays the contract menu.
   */
  public void displayContractMenu() {
    System.out.println("\nContract Management Menu:");
    System.out.println("1. Create a new lending contract");
    System.out.println("2. List all contracts");
    System.out.println("3. Back");

    System.out.print("\nEnter your choice: ");
  }

  /**
   * Prompts user to ender the Email of the borrower.

   * @return  the ID.
   */
  public String promptBorrowerEmail() {
    System.out.println("Creating a new contract...\n");
    System.out.print("Enter member Email of the Borrower: ");
    String borrowerId = scanner.nextLine();
    return borrowerId;
  }

  /**
   * Prompts user to input ItemID.

   * @return ItemId.
   */
  public String promptItemId() {
    System.out.print("Enter Item ID of the item to borrow: ");
    String itemId = scanner.nextLine();
    return itemId;
  }

  /**
   * Prompts for the day of return.

   * @return The date of return.
   */
  public int promptReturnDay() {
    System.out.print("Enter the day of return: ");
    int endDate = getIntInput();
    return endDate;
  }

  /**
   * Method to list all contracts.
   */
  public void listAllContracts(List<Contract> contracts) {
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

  /**
   * Reads an integer input from the user.
   *
   * @return The integer input from the user.
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