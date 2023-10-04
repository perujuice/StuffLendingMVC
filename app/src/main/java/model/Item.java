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
  private int costPerDay;
  // Date of creation.
  // Cost per day to lend the item.

  public Item(ItemCategory new_category, String new_name, String new_shordDesc, int new_costPerDay) {
    this.name = new_name;
    this.shortDesc = new_shordDesc;
    this.category = new_category;
    this.itemId = generateItemID();
    this.costPerDay = new_costPerDay;

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

  private String generateItemID() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
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
