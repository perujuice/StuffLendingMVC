package controller;

import model.Contract;
import model.DataManager;
import model.Item;
import model.Member;
import view.ContractView;

/**
 * Class handling state of the contract menu.
 */
public class ContractController {
  ContractView view;
  DataManager data;

  public ContractController(ContractView c, DataManager d) {
    this.view = c;
    this.data = d;
  }

  private enum ContractOptions {
    CREATE,
    LIST,
    BACK;
  }

  /**
   * Method to handle user options.
   */
  public void handleContractManagement() {
    view.displayContractMenu();
    ContractOptions option = displayContractManagementMenu();

    switch (option) {
      case CREATE:
        createNewContract();
        break;
      case LIST:
        view.listAllContracts();
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

  private void createNewContract() {
    String borrowerId = view.promptBorrowerId();
    Member borrower = data.getMemberRegistry().searchMember(borrowerId);

    if (borrower != null) {
      String itemId = view.promptItemId();
      int returnDay = view.promptReturnDay();
      Item item = data.getItemRegistry().searchItem(itemId);
      if (item != null) {
        Member lender = item.getOwner();
        Contract newContract = data.getContractRegistry().createContract(borrower, lender, item, returnDay);
        if (newContract != null) {
          System.out.println("Contract created successfully. Contract ID: " + newContract.getContractId());
        }
      } else {
        System.out.println("Item not found with the specified item ID.");
      }
    } else {
      System.out.println("Borrower not found with the specified member ID.");
    }
  }
}

