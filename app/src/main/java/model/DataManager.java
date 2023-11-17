package model;

/**
 * Class to store the state of the data.
 */
public class DataManager {
  private MemberRegistry members;
  private ItemRegistry items;
  private ContractRegistry contracts;

  /**
   * Constructor for data.

   * @param t Time.
   */
  public DataManager(TimeManager t) {
    members = new MemberRegistry(t);
    items = new ItemRegistry(members, t);
    contracts = new ContractRegistry(t);
  }

  public MemberRegistry getMemberRegistry() {
    return members;
  }

  public ItemRegistry getItemRegistry() {
    return items;
  }

  public ContractRegistry getContractRegistry() {
    return contracts;
  }
}
