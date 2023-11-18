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

  /**
   * Constructor for the UserInterface.
   * v The main view.
   * m Member view.
   * i Item view.
   * c Contract view.
   * t Time.
   * d Data manager.
   */
  public UserInterface(MainView v, MemberView m, ItemView i, ContractView c, TimeManager t, DataManager d) {
    member = new MemberController(m, this, d);
    contract = new ContractController(c, d, this);
    item = new ItemController(i, d, this, t);
    time = t;
    view = v;
  }

  /**
   * Main menu options for the user, state of the app.
   * return True if the app is running.
   */
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
        mainMenu();
        break;
      case EXIT:
        break;
      default:
        throw new IllegalArgumentException("Wrong user input! ");
    }

    return option != MainMenuOptions.EXIT;
  }

  /**
   * Handling displayal of user options.
   * return The chosen option.
   */
  public MainMenuOptions displayMainMenuOptions() {
    while (true) {
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
          System.out.println("Invalid option selected. Please try again.");
          view.displayMainMenu(); // Re-display the menu to prompt again
      }
    }
  }

}
