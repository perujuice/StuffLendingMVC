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
    items = new ItemRegistry(t);
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

  /**
   * Some persistent data.
   */
  public void persistentData() {
    Member member1 = members.createMember("John", "john@example.com", 1234567890);
    Member member2 = members.createMember("Alice", "alice@example.com", 986543210);
    Member member3 = members.createMember("Bob", "bob@example.com", 555555555);
    Member member4 = members.createMember("Eve", "eve@example.com", 999999999);
    Member member5 = members.createMember("Charlie", "charlie@example.com", 777777777);
    Member member6 = members.createMember("Mallory", "mallory@example.com", 888888888);

    final Item item1 = items.createItem(ItemCategory.TOOL,
        "Hammer", "Works fine! ", 10, member1);
    final Item item2 = items.createItem(ItemCategory.TOOL,
        "Hammer", "Works fine! ", 10, member2);
    final Item item3 = items.createItem(ItemCategory.VEHICLE,
        "Car", "Runs smoothly", 500, member1);
    items.createItem(ItemCategory.GAME,
        "Board Game", "Fun for the family", 2, member4);
    final Item item5 = items.createItem(ItemCategory.TOY,
        "Action Figure", "Collectible toy", 12, member3);
    final Item item6 = items.createItem(ItemCategory.SPORT,
        "Basketball", "High-quality ball", 30, member2);
    items.createItem(ItemCategory.OTHER,
        "Book", "Bestseller novel", 10, member5);
    items.createItem(ItemCategory.TOOL,
        "Drill", "Powerful drill", 150, member6);
    items.createItem(ItemCategory.VEHICLE,
        "Bicycle", "Great for commuting", 2, member4);
    items.createItem(ItemCategory.GAME,
        "Video Game", "Exciting gameplay", 40, member2);
    final Item item11 = items.createItem(ItemCategory.TOY,
        "Puzzle", "Challenging puzzle", 2, member6);
    items.createItem(ItemCategory.SPORT,
        "Soccer Ball", "Official size", 2, member3);
    items.createItem(ItemCategory.OTHER,
        "Cookware Set", "High-quality pots", 7, member4);
    final Item item14 = items.createItem(ItemCategory.TOOL,
        "Screwdriver Set", "Versatile tools", 3, member3);
    items.createItem(ItemCategory.VEHICLE,
        "Scooter", "Fuel-efficient", 3, member6);
    items.createItem(ItemCategory.GAME,
        "Chess Set", "Classic strategy game", 15, member1);

    contracts.createContract(member1, member2, item1, 2);
    contracts.createContract(member1, member3, item11, 2);
    contracts.createContract(member4, member3, item2, 3);
    contracts.createContract(member2, member4, item3, 4);
    contracts.createContract(member3, member5, item14, 4);
    contracts.createContract(member4, member6, item5, 2);
    contracts.createContract(member5, member1, item6, 3);

    System.out.println("Lender credits: " + member1.getCredits() + member1.getName());

  }

}
