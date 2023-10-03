package model;

/**
 * This class will handle Item information.
 */
public class Item {
  private String name;
  private String shortDesc;
  // Category (Not sure if this should be a string or somehow defined otherwise.)
  // Date of creation.
  // Cost per day to lend the item.

  public Item(String new_name, String new_shordDesc) {
    name = new_name;
    shortDesc = new_shordDesc;
  }

  public String getName() {
    return name;
  }

  public String getShortDescription() {
    return shortDesc;
  }

 }
