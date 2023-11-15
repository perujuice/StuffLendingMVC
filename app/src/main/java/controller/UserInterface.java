package controller;

import model.TimeManager;
import view.MainView;

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

  public UserInterface() {
    member = new MemberController();
    contract = new ContractController();
    item = new ItemController();
    time = new TimeManager();
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
