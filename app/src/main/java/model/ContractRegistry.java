package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for managing contracts between members and items.
 * It allows the creation of contracts and retrieval of contract information.
 */
public class ContractRegistry {
  private Map<String, Contract> contracts = new HashMap<>();
  private TimeManager timeManager;

  /**
   * Constructs a new ContractController with the specified dependencies.

   * @param timeManager        The TimeManager used for handling time-related
   *                           operations.
   */
  public ContractRegistry(TimeManager timeManager) {
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

    // Check if the lender has enough credits
    int numberOfDays = endDate - startDate;
    int cost = numberOfDays * item.getCostPerDay();

    if (lender.getCredits() < cost) {
      System.out.println("Contract is not valid. Lender does not have enough credits.");
      return null;
    }
    
    // Check if the item is available based on existing contracts
    boolean isItemAvailable = item.isAvailable(timeManager.getCurrentDay());

    if (!isItemAvailable) {
      System.out.println("Contract is not valid. The item is not available during the specified period.");
      return null;
    }

    // Deduct the cost from the lender's credits and add it to the borrower's credits
    lender.deductCredits(cost);
    borrower.addCredits(cost);

    // Create the contract and update item availability
    Contract contract = new Contract(lender, borrower, item, startDate, endDate);
    item.addContract(contract);
    contracts.put(contract.getContractId(), contract);

    return contract;
  }

  /**
   * Gets all active contracts.

   * @return The active contracts.
   */
  public List<Contract> getAllContracts() {
    List<Contract> activeContracts = new ArrayList<>();
    Iterator<Map.Entry<String, Contract>> iterator = contracts.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry<String, Contract> entry = iterator.next();
      Contract contract = entry.getValue();
      if (contract.isActive(timeManager.getCurrentDay())) {
        activeContracts.add(contract);
      } else {
        System.out.println("Contract not active anymore! ");
        iterator.remove(); // Remove the inactive contract from the map
      }
    }

    return activeContracts;
  }
}
