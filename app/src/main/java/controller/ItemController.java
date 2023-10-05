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
  //MemberController memberController = new MemberController();

  /**
   * Constructor for item methods.

   * @param originalController Instance of controller for member passed in.
   */
  public ItemController(MemberController originalController) {
    // start a list of items.
    this.items = new ArrayList<>();
    this.memberController = new MemberController(originalController);
  }

  /**
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

  /**
   * Method to get all Items.

   * @return Names of items.
   */
  public List<String> getAllItems() {
    List<String> itemNames = new ArrayList<>();
    for (Item item : items) {
      itemNames.add(item.getName());
    }

    return itemNames;
  }



}
