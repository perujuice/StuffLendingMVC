package model;

/**
 * This class will handle the lending contract information.
 */
public class Contract {
  private TimeManager timeManager;
  private int nextContractId = 1;

  private int contractId;
  private int startDate;
  private int endDate;
  private Member borrower;
  private Member lender;
  private Item item;
  private double totalCost;

  public Contract(Member newLender, Member newBorrower, Item newItem, int newStartDate, int newEndDate) {
    this.contractId = nextContractId++;
    this.lender = newLender;
    this.borrower = newBorrower;
    this.item = newItem;
    this.startDate = newStartDate;
    this.endDate = newEndDate;
    this.totalCost = calculateTotalCost();
    this.timeManager = timeManager;
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
    return lender;
  }

  public Member getBorrower() {
    return borrower;
  }

  public Item getItem() {
    return item;
  }

  public void setStartDate() {
    this.startDate = timeManager.getCurrentDay();
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
