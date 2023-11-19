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
  public Item(ItemCategory newCategory, String newName, String newShordDesc, int newCostPerDay, Member owner) {
    this.name = newName;
    this.shortDesc = newShordDesc;
    this.category = newCategory;
    this.itemId = generateItemId();
    this.costPerDay = newCostPerDay;
    this.owner = new Member(owner);
    contracts = new ArrayList<>();
  }

  /**
   * Copy constructor for item.

   * @param other The copy.
   */
  public Item(Item other) {
    this.name = other.name;
    this.shortDesc = other.shortDesc;
    this.category = other.category;
    this.itemId = other.itemId;
    this.costPerDay = other.costPerDay;
    this.owner = other.owner;
    this.contracts = new ArrayList<>(other.contracts);
  }

  public void updateName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void updateDesc(String shortDesc) {
    this.shortDesc = shortDesc;
  }

  public String getShortDescription() {
    return shortDesc;
  }

  public void updateCategory(ItemCategory category) {
    this.category = category;
  }

  public ItemCategory getCategory() {
    return category;
  }

  public void updateCost(int costPerDay) {
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
   * Checking if item is available.

   * @param currentDate The current date.
   * @return  True if available.
   */
  public boolean isAvailable(int currentDate) {
    for (Contract contract : contracts) {
      // Check if the item is unavailable during the specified time period
      if (contract.isActive(currentDate)) {
        return false;
      }
    }
    return true;
  }

  public Member getOwner() {
    // Return a new copy of the owner object
    return new Member(this.owner);
  }

  public void deleteFromOwner(Member owner) {
    owner.removeOwnedItem(this);
  }

  /**
   * Gettinf only the active contracts.

   * @param time Time.
   * @return  Active contracts.
   */
  public List<Contract> getContracts(int time) {
    List<Contract> activeContracts = new ArrayList<>();
    for (Contract contract : contracts) {
      if (contract.isActive(time)) {
        activeContracts.add(contract);
      } 
    }
    return activeContracts;
  }

}