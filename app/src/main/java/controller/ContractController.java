package controller;

import java.util.List;
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
  UserInterface ui;

  /**
   * Constructor for the contract controller.
   * c Contract view.
   * d Data.
   * ui User interface.
   */
  public ContractController(ContractView c, DataManager d, UserInterface ui) {
    this.view = c;
    this.data = d;
    this.ui = ui;
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
    boolean continueManagingContracts = true;

    while (continueManagingContracts) {
      view.displayContractMenu();
      ContractOptions option = displayContractManagementMenu();

      switch (option) {
        case CREATE:
          continueManagingContracts = createNewContract();
          break;
        case LIST:
          List<Contract> contracts = data.getContractRegistry().getAllContracts();
          view.listAllContracts(contracts);
          break;
        case BACK:
          continueManagingContracts = false;
          ui.mainMenu();
          break;
        default:
          throw new IllegalArgumentException("Invalid input! ");
      }
    }
  }

  private ContractOptions displayContractManagementMenu() {
    while (true) {
      int selectedOption = view.getIntInput();
      switch (selectedOption) {
        case 1:
          return ContractOptions.CREATE;
        case 2:
          return ContractOptions.LIST;
        case 3:
          return ContractOptions.BACK;
        default:
          System.out.println("Invalid option selected. Please enter 1, 2, or 3.");
          view.displayContractMenu(); // Re-display the contract menu
      }
    }
  }

  private boolean createNewContract() {
    String borrowerId = view.promptBorrowerEmail();
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
    return true;
  }
}
