package model;

import java.util.Random;

/**
 * This class represents a lending contract between a lender, a borrower, and an
 * item.
 * It contains information about the contract, such as start and end dates,
 * total cost, and involved members and items.
 */
public class Contract {
  private int startDate;
  private int endDate;
  private Member borrower;
  private Member lender;
  private Item item;
  private double totalCost;
  private String contractId;
  private Random random = new Random();

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
    this.lender = newLender;
    this.borrower = newBorrower;
    this.item = newItem;
    this.startDate = newStartDate;
    this.endDate = newEndDate;
    this.totalCost = calculateTotalCost();
    this.contractId = generateItemId();
  }

  private double calculateTotalCost() {
    int diffInDays = (endDate - startDate);
    double pricePerDay = item.getCostPerDay();
    return diffInDays * pricePerDay;
  }

  public boolean isActive(int newStartDate, int newEndDate) {
    return startDate <= newEndDate && endDate >= newStartDate;
  }

  public double getTotalCost() {
    return totalCost;
  }

  private String generateItemId() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char[] contractId = new char[6];

    for (int i = 0; i < 6; i++) {
      int randomIndex = random.nextInt(characters.length());
      contractId[i] = characters.charAt(randomIndex);
    }

    return new String(contractId);
  }
  public String getContractId() {
    return contractId;
  }

  /**
   * Method to get lender.

   * @return The lender.
   */
  public Member getLender() {
    return this.lender;
  }

  /**
   * Gets the borrower.

   * @return Borrower.
   */
  public Member getBorrower() {
    return this.borrower;
  }

  public Item getItem() {
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

  /**
   * Method to check for validity of contract.

   * @return Boolean.
   */
  public boolean isValid() {
    // Check if the contract is valid (e.g., lender has enough credits, item is
    // available)
    return lender.getCredits() >= totalCost;
    // && item.isAvailable(startDate, endDate);
  }
}
