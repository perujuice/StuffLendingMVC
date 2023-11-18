package controller;

import java.util.List;
import model.Contract;
import model.DataManager;
import model.Item;
import model.ItemCategory;
import model.Member;
import model.TimeManager;
import view.ItemView;

/**
 * Class to handle Item methods.
 */
public class ItemController {
  ItemView view;
  UserInterface ui;
  DataManager data;
  TimeManager time;

  /**
   * Constructor for item controller.

   * @param v Item view.
   * @param d Data.
   * @param ui  User interface.
   */
  public ItemController(ItemView v, DataManager d, UserInterface ui, TimeManager time) {
    this.view = v;
    this.ui = ui;
    this.data = d;
    this.time = time;
  }

  private enum ItemOptions {
    CREATE_ITEM,
    LIST_ITEMS,
    DELETE,
    CHANGE, 
    VIEW,
    BACK;
  }

  private enum ChangeItemInfo {
    NAME,
    DESC,
    CATEGORY,
    COST,
    BACK;
  }

  /**
   * Method to handle user options.
   */
  public void handleItemManagement() {
    boolean continueManagingItems = true;

    while (continueManagingItems) {
      view.displayItemMenu();
      ItemOptions option = displayItemManagementMenu();

      switch (option) {
        case CREATE_ITEM:
          String email = view.promtMemberEmail();
          Member owner = data.getMemberRegistry().searchMember(email);
          if (owner != null) {
            ItemCategory category = view.getCategoryFromUserInput();      
            String name = view.promptItemName();
            String description = view.promptItemDesc();
            int costPerDay = view.promptsItemCost();
            Item newItem = data.getItemRegistry().createItem(category, name, description, costPerDay, email);
            continueManagingItems = view.displayItemCreate(newItem);
          } else {
            System.out.println("Member not found with the specified memberId.");
          }
          break;
        case LIST_ITEMS:
          List<String> allItems = data.getItemRegistry().getAllItems();
          view.displayItemList(allItems);
          break;
        case DELETE:
          String deleteId = view.promtItemId();
          Item deleteItem = data.getItemRegistry().searchItem(deleteId);
          Member itemOwner = deleteItem.getOwner();
          data.getItemRegistry().deleteItem(deleteId, itemOwner.getEmail());
          view.displayItemDelete(deleteItem);
          break;
        case CHANGE:
          changeItemInfo();
          break;
        case VIEW:
          String itemId = view.promtItemId();
          Item item = data.getItemRegistry().searchItem(itemId);
          view.printItemInfo(item, itemId);
          List<Contract> contracts = item.getContracts(time.getCurrentDay());
          view.viewItemInformation(item, itemId, contracts);
          break;
        case BACK:
          continueManagingItems = false;
          ui.mainMenu();
          break;
        default:
          throw new IllegalArgumentException("Wrong user input! ");
      }
    }
  }

  private ItemOptions displayItemManagementMenu() {
    int selectedOption = view.getIntInput();

    switch (selectedOption) {
      case 1:
        return ItemOptions.CREATE_ITEM;
      case 2:
        return ItemOptions.LIST_ITEMS;
      case 3:
        return ItemOptions.DELETE;
      case 4:
        return ItemOptions.CHANGE;
      case 5:
        return ItemOptions.VIEW;
      case 6:
        return ItemOptions.BACK;
      default:
        return null;
    }
  }

  private void changeItemInfo() {
    view.displayChange();
    ChangeItemInfo option = displayItemChange();
    String changeId = view.promtItemId();
    
    switch (option) {
      case NAME:
        String newName = view.promptChangeName(changeId);
        data.getItemRegistry().updateItemName(changeId, newName);
        break;
      case DESC:
        String newDesc = view.promptChangeDesc(changeId);
        data.getItemRegistry().updateItemDesc(changeId, newDesc);
        break;
      case CATEGORY:
        ItemCategory newCategory = view.promptChangeCategory(changeId);
        data.getItemRegistry().updateItemCategory(changeId, newCategory);
        break;
      case COST:
        int newCost = view.promptChangeCost(changeId);
        data.getItemRegistry().updateCostPerDay(changeId, newCost);
        break;
      case BACK:
        handleItemManagement();
        break;
      default:
        throw new IllegalArgumentException("Invalid intput! ");
    }
  }

  private ChangeItemInfo displayItemChange() {
    int selectedOption = view.getIntInput();

    switch (selectedOption) {
      case 1:
        return ChangeItemInfo.NAME;
      case 2:
        return ChangeItemInfo.DESC;
      case 3:
        return ChangeItemInfo.CATEGORY;
      case 4:
        return ChangeItemInfo.COST;
      case 5:
        return ChangeItemInfo.BACK;
      default:
        throw new IllegalArgumentException("Wrong input! ");
    }
  }
}
