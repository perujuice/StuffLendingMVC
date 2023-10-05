package controller;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.ItemCategory;
import model.Member;


/**
 * Class to handle Item methods.
 */
public class ItemController {
  private List<Item> items;
  private MemberController memberController;

  /**
   * Constructor for item methods.

   * @param originalController Instance of controller for member passed in.
   */
  public ItemController(MemberController originalController) {
    // start a list of items.
    this.items = new ArrayList<>();
    this.memberController = originalController;
  }

  /**TPHMCX
   * Method to create Item.

   * @param category Category of item.
   * @param name  Name of item.
   * @param shortDesc Short description of an item.
   * @param costPerDay Cost per day to borrow an item.
   * @param memberId Member who owns the item.
   * @return New Item.
   */
  public Item createItem(ItemCategory category, String name, String shortDesc, int costPerDay, String memberId) {
    Member owner = memberController.searchMember(memberId);

    if (owner != null) {
      Item newItem  = new Item(category, name, shortDesc, costPerDay);
      newItem.setOwner(owner);
      items.add(0, newItem);
      return newItem;
    } else {
      System.out.println("Member not found with the specified memberId.");
      return null;
    }
  }

  public boolean deleteItem(String itemId, String memberId) {
    Member owner = memberController.searchMember(memberId);
    System.out.println(owner.getName());
    for (Item item : items) {
      if (item.getItemId().equals(itemId)) {
        items.remove(item);
        item.DeleteFromOwner(owner);
        return true; // Item deleted successfully
      }
    }
    return false; // Item not found
  }

  public Item searchItem(String itemId) {
    for (Item item : items) {
      if (item.getItemId().equals(itemId)) {
        return item;
      }
    }
    return null; // Item not found
  }

  public void printItemInfo(String itemId) {
    Item item = searchItem(itemId);
    if (item != null) {
      System.out.println("\nItem Information:");
      System.out.println("Name: " + item.getName());
      System.out.println("Short Description: " + item.getShortDescription());
      System.out.println("Category: " + item.getCategory());
      System.out.println("Cost per day: " + item.getCostPerDay());
    } else {
      System.out.println("Item with ID " + itemId + " not found.");
    }
  }

  /**
   * Method to get all Items.

   * @return Names of items.
   */
  public List<String> getAllItems() {
    List<String> itemsWithIds = new ArrayList<>();
    for (Item item : items) {
        String itemInfo = "Item ID: " + item.getItemId() + ", Item Name: "
         + item.getName() + ", OwnerID: " + "Item owner: " + item.getOwner().getMemberId();
        itemsWithIds.add(itemInfo);
    }

    return itemsWithIds;
  }

  public boolean updateItemName(String itemId, String newName) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      itemToUpdate.setName(newName); // Use the existing setter
      return true;
    }
    return false;
  }

  public boolean updateItemDesc(String itemId, String newDesc) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      itemToUpdate.setShortDescription(newDesc); // Use the existing setter
      return true;
    }
    return false;
  }

  public boolean updateItemCategory(String itemId, ItemCategory newCategory) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      itemToUpdate.setCategory(newCategory);
      return true;
    }
    return false;
  }

  public boolean updateCostPerDay(String itemId, int costPerDay) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      itemToUpdate.setCostPerDay(costPerDay);
      return true;
    }
    return false;
  }

}
