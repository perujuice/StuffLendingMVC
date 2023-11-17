package controller;

import model.DataManager;
import model.TimeManager;
import view.ContractView;
import view.ItemView;
import view.MainView;
import view.MemberView;

/**
 * Main scenario controller for the app.
 */
public class UserInterface {
  MainView view;
  MemberController member;
  ItemController item;
  ContractController contract;
  TimeManager time;

  private enum MainMenuOptions {
    MEMBER_MANAGEMENT,
    ITEM_MANAGEMENT,
    CONTRACT_MANAGEMENT,
    ADVANCE_TIME,
    EXIT;
  }

  public UserInterface(MainView v, MemberView m, ItemView i, ContractView c, TimeManager t, DataManager d) {
    member = new MemberController(m, this);
    contract = new ContractController(c, d);
    item = new ItemController(i);
    time = t;
    view = v;
  }

  public boolean mainMenu() {
    view.displayMainMenu();

    MainMenuOptions option = displayMainMenuOptions();

    switch (option) {
      case MEMBER_MANAGEMENT:
        member.handleMemberManagement();
        break;
      case ITEM_MANAGEMENT:
        item.handleItemManagement();
        break;
      case CONTRACT_MANAGEMENT:
        contract.handleContractManagement();
        break;
      case ADVANCE_TIME:
        time.advanceDay();
        view.displayTime();
        break;
      case EXIT:
        break;
      default:
        throw new IllegalArgumentException("Wrong user input! ");
    }

    return option != MainMenuOptions.EXIT;
  }


  public MainMenuOptions displayMainMenuOptions() {
    int selectedOption = view.getIntInput();

    switch (selectedOption) {
      case 1:
        return MainMenuOptions.MEMBER_MANAGEMENT;
      case 2:
        return MainMenuOptions.ITEM_MANAGEMENT;
      case 3:
        return MainMenuOptions.CONTRACT_MANAGEMENT;
      case 4:
        return MainMenuOptions.ADVANCE_TIME;
      case 5:
        return MainMenuOptions.EXIT;
      default:
        return null;
    }
  }

}
