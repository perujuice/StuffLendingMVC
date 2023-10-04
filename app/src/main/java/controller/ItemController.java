package controller;

import model.Item;
import model.ItemCategory;
import model.Member;
import java.util.ArrayList;
import java.util.List;

public class ItemController {
  private List<Item> items;
  MemberController memberController = new MemberController();

  public ItemController() {
    // start a list of items.
    this.items = new ArrayList<>();
  }


  public Item createItem(ItemCategory category, String name, String shortDesc, int costPerDay, String memberId) {
    System.out.println("Received memberId: " + memberId);
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

  public List<String> getAllItems() {
    List<String> itemNames = new ArrayList<>();
    for (Item item : items) {
      itemNames.add(item.getName());
    }

    return itemNames;
  }



}
