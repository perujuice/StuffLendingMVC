package view;

import java.util.List;
import java.util.Scanner;
import model.Contract;
import model.DataManager;

/**
 * Class for contract UI stuff.
 */
public class ContractView {
  private Scanner scanner;
  private DataManager data;


  public ContractView(Scanner scanner, DataManager d) {
    this.scanner = scanner;
    this.data = d;
 }

public void displayContractMenu() {
    System.out.println("\nContract Management Menu:");
    System.out.println("1. Create a new lending contract");
    System.out.println("2. List all contracts");
    System.out.println("3. Back");

    System.out.print("\nEnter your choice: ");
  }

  public String promptBorrowerId() {
    System.out.println("Creating a new contract...\n");
    System.out.print("Enter member ID of the Borrower: ");
    String borrowerId = scanner.nextLine();
    return borrowerId;
  }

  public String promptItemId() {
    System.out.print("Enter Item ID of the item to borrow: ");
    String itemId = scanner.nextLine();
    return itemId;
  }

  public int promptReturnDay() {
    System.out.print("Enter the day of return: ");
    int endDate = getIntInput();
    return endDate;
  }

  /**
   * Method to list all contracts.
   */
  public void listAllContracts() {
    List<Contract> contracts = data.getContractRegistry().getAllContracts();

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