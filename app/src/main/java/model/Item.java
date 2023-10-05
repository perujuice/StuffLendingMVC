package model;

import java.util.Random;

/**
 * This class will handle Item information.
 */
public class Item {
  private String itemId;
  private String name;
  private String shortDesc;
  private ItemCategory category;
  private Member owner; //Reference to the specific member that owns the item.
  private Random random = new Random();
  //private int costPerDay;
  // Date of creation.
  // Cost per day to lend the item.


  /**
   * Item constructor.

   * @param newCategory Category.
   * @param newName Name.
   * @param newShordDesc Short description.
   * @param newCostPerDay Cost per day.
   */
  public Item(ItemCategory newCategory, String newName, String newShordDesc, int newCostPerDay) {
    this.name = newName;
    this.shortDesc = newShordDesc;
    this.category = newCategory;
    this.itemId = generateItemId();
    //this.costPerDay = newCostPerDay;
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

  /**
   * Link the item to its owner.

   * @param owner The specific member.
   */
  public void setOwner(Member owner) {
    this.owner = owner;
    owner.addItem(this);
  }

  public Member getOwner() {
    return owner;
  }

}