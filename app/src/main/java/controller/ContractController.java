package controller;

import model.Contract;
import model.ContractRegistry;
import model.Item;
import model.ItemRegistry;
import model.Member;
import model.MemberRegistry;
import view.ContractView;


public class ContractController {
  ContractView view;
  MemberRegistry memberRegistry;
  ItemRegistry itemRegistry;
  ContractRegistry contract;

  private enum ContractOptions {
    CREATE,
    LIST,
    BACK;
  }

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
    Member borrower = memberRegistry.searchMember(borrowerId);

    if (borrower != null) {
      String itemId = view.promptItemId();
      int returnDay = view.promptReturnDay();
      Item item = itemRegistry.searchItem(itemId);
      if (item != null) {
        Member lender = item.getOwner();
        Contract newContract = contract.createContract(borrower, lender, item, returnDay);
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

