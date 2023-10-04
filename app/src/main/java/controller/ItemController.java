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


  public void createItem(ItemCategory category, String name, String shortDesc, int costPerDay, String memberId) {
    Member owner = memberController.searchMember(memberId);

    if (owner != null) {
      Item newItem  = new Item(category, name, shortDesc, costPerDay);
      newItem.setOwner(owner);
      items.add(0, newItem);
    } else {
      System.out.println("Member not found with the specified memberId.");
    }
  }



}
