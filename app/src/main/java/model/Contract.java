package model;

/**
 * This class represents a lending contract between a lender, a borrower, and an
 * item.
 * It contains information about the contract, such as start and end dates,
 * total cost, and involved members and items.
 */
public class Contract {
  private int nextContractId = 1;

  private int contractId;
  private int startDate;
  private int endDate;
  private Member borrower;
  private Member lender;
  private Item item;
  private double totalCost;

  /**
   * Constructs a new lending contract with the specified details.
   *
   * @param newLender    The member who is lending the item.
   * @param newBorrower  The member who is borrowing the item.
   * @param newItem      The item being borrowed.
   * @param newStartDate The start date of the contract.
   * @param newEndDate   The end date of the contract.
   */
  public Contract(Member newLender, Member newBorrower, Item newItem, int newStartDate, int newEndDate) {
    this.contractId = nextContractId++;
    this.lender = newLender;
    this.borrower = newBorrower;
    this.item = newItem;
    this.startDate = newStartDate;
    this.endDate = newEndDate;
    this.totalCost = calculateTotalCost();
  }

  private double calculateTotalCost() {
    int diffInDays = (endDate - startDate);
    double pricePerDay = item.getCostPerDay();
    return diffInDays * pricePerDay;
  }

  public boolean overlaps(int newStartDate, int newEndDate) {
    return startDate <= newEndDate && endDate >= newStartDate;
  }

  public double getTotalCost() {
    return totalCost;
  }

  public int getContractId() {
    return contractId;
  }

  public Member getLender() {
    // Return a copy of the lender object to avoid exposing the internal
    // representation
    return this.lender;
  }

  public Member getBorrower() {
    // Return a copy of the borrower object to avoid exposing the internal
    // representation
    return this.borrower;
  }

  public Item getItem() {
    // Return a copy of the item object to avoid exposing the internal
    // representation
    return this.item;
  }

  public void setStartDate(int currentDay) {
    this.startDate = currentDay;
  }

  public int getStartDate() {
    return startDate;
  }

  public void setEndDate(int endDate) {
    this.endDate = endDate;
  }

  public int getEndDate() {
    return endDate;
  }

  public boolean isValid() {
    // Check if the contract is valid (e.g., lender has enough credits, item is
    // available)
    return lender.getCredits() >= totalCost;
    // && item.isAvailable(startDate, endDate);
  }
}
