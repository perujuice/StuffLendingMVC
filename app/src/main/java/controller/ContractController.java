package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contract;
import model.Item;
import model.Member;
import model.TimeManager;

/**
 * This class is responsible for managing contracts between members and items.
 * It allows the creation of contracts and retrieval of contract information.
 */
public class ContractController {
  private List<Contract> contracts;
  private TimeManager timeManager;

  /**
   * Constructs a new ContractController with the specified dependencies.
   *
   * @param originalController The MemberController used for managing members.
   * @param itemController     The ItemController used for managing items.
   * @param timeManager        The TimeManager used for handling time-related
   *                           operations.
   */
  public ContractController(TimeManager timeManager) {
    this.contracts = new ArrayList<>();
    this.timeManager = timeManager;
  }

  /**
   * Creates a new contract between a borrower and a lender for a specific item.
   *
   * @param borrower The borrower who is borrowing the item.
   * @param lender   The lender who is lending the item.
   * @param item     The item being borrowed.
   * @param endDate  The end date of the contract.
   * @return The created Contract object if the contract is valid, or null
   *         otherwise.
   */
  public Contract createContract(Member borrower, Member lender, Item item, int endDate) {
    int startDate = timeManager.getCurrentDay();

    // Calculate the cost of the contract
    int numberOfDays = endDate - startDate;
    int cost = numberOfDays * item.getCostPerDay();

    // Check if the lender has enough credits and the item is available
    if (lender.getCredits() >= cost && item.isAvailable(startDate, endDate)) {
      // Deduct the cost from the lender's credits and add it to the borrower's
      // credits
      lender.deductCredits(cost);
      borrower.addCredits(cost);

      // Create the contract and update item availability
      Contract contract = new Contract(lender, borrower, item, startDate, endDate);
      contracts.add(contract);
      item.addContract(contract);

      return contract;
    } else {
      System.out.println("Contract is not valid. Lender does not have enough credits or the item is not available.");
      return null;
    }
  }

  // list all contracts
  public List<Contract> getAllContracts() {
    return contracts;
  }

  public void listAllContracts() {
    List<Contract> contracts = getAllContracts();

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
}

