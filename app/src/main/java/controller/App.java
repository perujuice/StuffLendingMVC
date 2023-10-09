package controller;

import model.Item;
import model.ItemCategory;
import model.Member;
import model.TimeManager;
import view.MemberManagement;
import view.UserInterface;

/**
 * Responsible for staring the application.
 */
public class App {
  TimeManager timeManager = new TimeManager();
  MemberController memberController = new MemberController(timeManager);
  ContractController contractController = new ContractController(timeManager);
  ItemController itemController = new ItemController(memberController, timeManager);
  MemberManagement memberManagement = new MemberManagement(memberController);
  UserInterface ui = new UserInterface(memberController, itemController, contractController);

  /**
   * This is just some data for persistance.
   */
  public void data() {
    Member member1 = memberController.createMember("John", "john@example.com", 1234567890);
    Member member2 = memberController.createMember("Alice", "alice@example.com", 986543210);
    Member member3 = memberController.createMember("Bob", "bob@example.com", 555555555);
    Member member4 = memberController.createMember("Eve", "eve@example.com", 999999999);
    Member member5 = memberController.createMember("Charlie", "charlie@example.com", 777777777);
    Member member6 = memberController.createMember("Mallory", "mallory@example.com", 888888888);

    Item item1 = itemController.createItem(ItemCategory.TOOL, "Hammer", "Works fine! ", 100, member1.getMemberId());
    Item item2 = itemController.createItem(ItemCategory.TOOL, "Hammer", "Works fine! ", 100, member2.getMemberId());
    Item item3 = itemController.createItem(ItemCategory.VEHICLE, "Car", "Runs smoothly", 500, member1.getMemberId());
    Item item4 = itemController.createItem(ItemCategory.GAME, "Board Game", "Fun for the family", 20, member4.getMemberId());
    Item item5 = itemController.createItem(ItemCategory.TOY, "Action Figure", "Collectible toy", 15, member3.getMemberId());
    Item item6 = itemController.createItem(ItemCategory.SPORT, "Basketball", "High-quality ball", 30, member2.getMemberId());
    Item item7 = itemController.createItem(ItemCategory.OTHER, "Book", "Bestseller novel", 10, member5.getMemberId());
    Item item8 = itemController.createItem(ItemCategory.TOOL, "Drill", "Powerful drill", 150, member6.getMemberId());
    Item item9 = itemController.createItem(ItemCategory.VEHICLE, "Bicycle", "Great for commuting", 200, member4.getMemberId());
    Item item10 = itemController.createItem(ItemCategory.GAME, "Video Game", "Exciting gameplay", 40, member2.getMemberId());
    Item item11 = itemController.createItem(ItemCategory.TOY, "Puzzle", "Challenging puzzle", 25, member6.getMemberId());
    Item item12 = itemController.createItem(ItemCategory.SPORT, "Soccer Ball", "Official size", 25, member3.getMemberId());
    Item item13 = itemController.createItem(ItemCategory.OTHER, "Cookware Set", "High-quality pots", 75, member4.getMemberId());
    Item item14 = itemController.createItem(ItemCategory.TOOL, "Screwdriver Set", "Versatile tools", 30, member3.getMemberId());
    Item item15 = itemController.createItem(ItemCategory.VEHICLE, "Scooter", "Fuel-efficient", 300, member6.getMemberId());
    Item item16 = itemController.createItem(ItemCategory.GAME, "Chess Set", "Classic strategy game", 15, member1.getMemberId());

    contractController.createContract(member1, member2, item1, 2);
    contractController.createContract(member1, member3, item11, 2);
    contractController.createContract(member4, member3, item2, 3);
    contractController.createContract(member2, member4, item3, 1);
    contractController.createContract(member3, member5, item14, 4);
    contractController.createContract(member4, member6, item5, 2);
    contractController.createContract(member5, member1, item6, 3);

  }


  /**
   * Application starting point.
   *
   * @param args command line arguments.MLNMJD
   */
  public static void main(String[] args) {
    App app = new App(); // Create an instance of the App class
    app.data();
    UserInterface ui = app.ui; // Get the UserInterface instance from the App instance
    ui.displayMenu();
  }
}
