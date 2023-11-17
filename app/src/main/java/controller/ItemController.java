package controller;

import view.ItemView;

/**
 * Class to handle Item methods.
 */
public class ItemController {
  ItemView view;
  UserInterface ui;

  public ItemController(ItemView v, UserInterface ui) {
    this.view = v;
    this.ui = ui;
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
          continueManagingItems = view.itemCreateInput();
          break;
        case LIST_ITEMS:
          view.displayItemList();
          break;
        case DELETE:
          view.promtItemDelete();
          break;
        case CHANGE:
          changeItemInfo();
          break;
        case VIEW:
          view.viewItemInformation();
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
        view.promptChangeName(changeId);
        break;
      case DESC:
        view.promptChangeDesc(changeId);
        break;
      case CATEGORY:
        view.promptChangeCategory(changeId);
        break;
      case COST:
        view.promptChangeCost(changeId);
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
