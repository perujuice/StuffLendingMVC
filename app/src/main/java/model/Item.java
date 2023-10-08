package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class will handle Item information.
 */
public class Item {
  private String itemId;
  private String name;
  private String shortDesc;
  private ItemCategory category;
  private Member owner; // Reference to the specific member that owns the item.
  private int costPerDay;
  private Random random = new Random();
  private List<Contract> contracts;
  // private int costPerDay;
  // Date of creation.
  // Cost per day to lend the item.

  /**
   * Item constructor.

   * @param newCategory   Category.
   * @param newName       Name.
   * @param newShordDesc  Short description.
   * @param newCostPerDay Cost per day.
   */
  public Item(ItemCategory newCategory, String newName, String newShordDesc, int newCostPerDay) {
    this.name = newName;
    this.shortDesc = newShordDesc;
    this.category = newCategory;
    this.itemId = generateItemId();
    this.costPerDay = newCostPerDay;
    contracts = new ArrayList<>();
  }

  public Item(Item item) {
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setShortDescription(String shortDesc) {
    this.shortDesc = shortDesc;
  }

  public String getShortDescription() {
    return shortDesc;
  }

  public void setCategory(ItemCategory category) {
    this.category = category;
  }

  public ItemCategory getCategory() {
    return category;
  }

  public void setCostPerDay(int costPerDay) {
    this.costPerDay = costPerDay;
  }

  public int getCostPerDay() {
    return costPerDay;
  }

  private String generateItemId() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char[] itemId = new char[6];

    for (int i = 0; i < 6; i++) {
      int randomIndex = random.nextInt(characters.length());
      itemId[i] = characters.charAt(randomIndex);
    }

    return new String(itemId);
  }

  public String getItemId() {
    return itemId;
  }

  public void addContract(Contract contract) {
    contracts.add(contract); // Add a contract to the list
  }

  /**
   * Checks if item is available.

   * @param startDate The start day.
   * @param endDate The end day.
   * @return Boolean.
   */
  public boolean isAvailable(int startDate, int endDate) {
    for (Contract contract : contracts) {
      // Check if the item is unavailable during the specified time period
      if (contract.isActive(startDate, endDate)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Link the item to its owner.

   * @param owner The specific member.
   */
  public void setOwner(Member owner) {
    // Create a copy of the owner object before assigning it
    this.owner = owner;
    owner.addItem(this);
  }

  public Member getOwner() {
    // Return a new copy of the owner object
    return this.owner;
  }

  public void deleteFromOwner(Member owner) {
    owner.removeOwnedItem(this);
  }

  public List<Contract> getContracts() {
    return contracts;
  }

}