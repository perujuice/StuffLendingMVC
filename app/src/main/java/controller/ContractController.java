package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contract;
import model.Item;
import model.Member;
import model.TimeManager;


public class ContractController {
  private List<Contract> contracts;
  private MemberController memberController;
  private ItemController itemController;
  private TimeManager timeManager;


  public ContractController(MemberController originalController, ItemController itemController, TimeManager timeManager) {
    this.contracts = new ArrayList<>();
    this.memberController = originalController;
    this.itemController = itemController;
    this.timeManager = timeManager;
  }

  public Contract createContract(Member borrower, Member lender, Item item, int endDate) {
    int startDate = timeManager.getCurrentDay();
    
    Contract contract = new Contract(lender, borrower, item, startDate, endDate);

    if (contract.isValid()) {
      contracts.add(contract);
      return contract;
    } else {
      System.out.println("Contract is not valid. Lender does not have enough credits.");
      return null;
    }
  }

}
