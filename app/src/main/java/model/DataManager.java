package model;

public class DataManager {
  private MemberRegistry m;
  private ItemRegistry i;
  private ContractRegistry c;

  public DataManager(TimeManager t) {
    m = new MemberRegistry(t);
    i = new ItemRegistry(m, t);
    c = new ContractRegistry(t);
  }

  public MemberRegistry getMemberRegistry() {
    return m;
  }

  public ItemRegistry getItemRegistry() {
    return i;
  }

  public ContractRegistry getContractRegistry() {
    return c;
  }
}
