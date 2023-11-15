package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.MemberController;

/**
 * Class to create Items and handle retrieval of Item information.
 */
public class ItemRegistry {
  final private Map<String, Item> items = new HashMap<>();
  final private MemberController memberController;
  final private TimeManager time;

  /**
   * Constructor for item methods.
   *
   * @param originalController Instance of controller for member passed in.
   */
  public ItemRegistry(MemberController originalController, TimeManager time) {
    this.memberController = originalController;
    this.time = time;
  }

  /**
   * Method to create Item.
   *
   * @param category   Category of item.
   * @param name       Name of item.
   * @param shortDesc  Short description of an item.
   * @param costPerDay Cost per day to borrow an item.
   * @param email   Member who owns the item.
   * @return New Item.
   */
  public Item createItem(ItemCategory category, String name, String shortDesc, int costPerDay, String email) {
    Member owner = memberController.searchMember(email);

    if (owner != null) {
      // Create a new item
      Item newItem = new Item(category, name, shortDesc, costPerDay, owner);

      // Add the item to the owner and get the updated owner
      owner = owner.addItem(newItem);

      // Replace the existing member in the HashMap with the updated member
      memberController.updateMember(owner);

      // Add the item to the items list
      items.put(newItem.getItemId(), newItem);

      int dateOfCreation = time.getCurrentDay();
      System.out.println("Item created: " + newItem.getName() + " Date of creation: " + dateOfCreation);
      return newItem;
    } else {
      System.out.println("Member not found with the specified memberId.");
      return null;
    }
  }

  /**
   * Method to delete an Item.
   *
   * @param itemId   The ID of the item to delete.
   * @param memberId Member who owns the item.
   * @return True if the item is deleted successfully, false otherwise.
   */
  public boolean deleteItem(String itemId, String memberId) {
    Member owner = memberController.searchMember(memberId);
    System.out.println(owner.getName());

    Item itemToRemove = items.get(itemId);
    
    if (itemToRemove != null) {
      items.remove(itemId); // Remove the item from the HashMap by its itemId
      itemToRemove.deleteFromOwner(owner);
      return true; // Item deleted successfully
    }
    
    return false; // Item not found
  }

  /**
   * Method to search for an item by its ID.
   *
   * @param itemId The ID of the item to search for.
   * @return The found item or null if not found.
   */
  public Item searchItem(String itemId) {
    return items.get(itemId);
  }

  /**
   * Method to print information about an item.
   *
   * @param itemId The ID of the item to retrieve information for.
   */
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
    for (Item item : items.values()) {
      String itemInfo = "Item ID: " + item.getItemId() + ", Item Name: "
          + item.getName() + ", OwnerID: " + "Item owner: " + item.getOwner().getMemberId();
      itemsWithIds.add(itemInfo);
    }

    return itemsWithIds;
  }

  /**
 * Method to update the name of an item.
 *
 * @param itemId  The ID of the item to update.
 * @param newName The new name for the item.
 * @return True if the item name is updated successfully, false otherwise.
 */
public boolean updateItemName(String itemId, String newName) {
  Item itemToUpdate = searchItem(itemId);
  if (itemToUpdate != null) {
    // Update the name of the item and get the updated item
    Item updatedItem = itemToUpdate.updateName(newName);
    
    // Replace the existing item in the HashMap with the updated item
    items.put(updatedItem.getItemId(), updatedItem);
    return true;
    }
  return false;
  }

  /**
   * Method to update the short description of an item.
   *
   * @param itemId  The ID of the item to update.
   * @param newDesc The new short description for the item.
   * @return True if the item description is updated successfully, false
   *         otherwise.
   */
  public boolean updateItemDesc(String itemId, String newDesc) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      // Update the name of the item and get the updated item
    Item updatedItem = itemToUpdate.updateDesc(newDesc);
    
    // Replace the existing item in the HashMap with the updated item
    items.put(updatedItem.getItemId(), updatedItem);
      return true;
    }
    return false;
  }

  /**
   * Method to update the category of an item.
   *
   * @param itemId      The ID of the item to update.
   * @param newCategory The new category for the item.
   * @return True if the item category is updated successfully, false otherwise.
   */
  public boolean updateItemCategory(String itemId, ItemCategory newCategory) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      // Update the name of the item and get the updated item
      Item updatedItem = itemToUpdate.updateCategory(newCategory);
      // Replace the existing item in the HashMap with the updated item
      items.put(updatedItem.getItemId(), updatedItem);
      return true;
    }
    return false;
  }

  /**
   * Method to update the cost per day.

   * @param itemId Item ID passed.
   * @param costPerDay Cost per day.
   * @return Returns a boolean.
   */
  public boolean updateCostPerDay(String itemId, int costPerDay) {
    Item itemToUpdate = searchItem(itemId);
    if (itemToUpdate != null) {
      // Update the name of the item and get the updated item
      Item updatedItem = itemToUpdate.updateCost(costPerDay);
    
      // Replace the existing item in the HashMap with the updated item
      items.put(updatedItem.getItemId(), updatedItem);
      return true;
    }
    return false;
  }
}
