package controller;

import view.ContractView;

/**
 * This class is responsible for managing contracts between members and items.
 * It allows the creation of contracts and retrieval of contract information.
 */
public class ContractController {
  ContractView view;

  private enum ContractOptions {
    CREATE,
    LIST,
    BACK;
  }

  public void handleContractManagement() {
    ContractOptions option = displayContractManagementMenu();

    switch (option) {
      case CREATE:
        break;
      case LIST:
        break;
      case BACK:
        break;
      default:
        throw new IllegalArgumentException("Invalid input! ");
    }
  }

  private ContractOptions displayContractManagementMenu() {
    int selectedOption = view.getIntInput();

    switch (selectedOption) {
      case 1:
        return ContractOptions.CREATE;
      case 2:
        return ContractOptions.LIST;
      case 3:
        return ContractOptions.BACK;
      default:
        return null;
    }
  }
}

