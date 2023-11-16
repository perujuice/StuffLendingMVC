package controller;

import java.util.Scanner;

import view.ContractView;
import view.ItemView;
import view.MainView;
import view.MemberView;


/**
 * Responsible for staring the application.
 */
public class App {
  Scanner scanner = new Scanner(System.in);
  MainView v = new MainView(scanner);
  MemberView m = new MemberView(scanner);
  ItemView i = new ItemView(scanner);
  ContractView c = new ContractView(scanner); 
  UserInterface ui = new UserInterface(v, m, i, c);

  /**
   * This is just some data for persistance.
   */
  /*public void data() {
    Member member1 = memberController.createMember("John", "john@example.com", 1234567890);
    Member member2 = memberController.createMember("Alice", "alice@example.com", 986543210);
    Member member3 = memberController.createMember("Bob", "bob@example.com", 555555555);
    Member member4 = memberController.createMember("Eve", "eve@example.com", 999999999);
    Member member5 = memberController.createMember("Charlie", "charlie@example.com", 777777777);
    Member member6 = memberController.createMember("Mallory", "mallory@example.com", 888888888);

    Item item1 = itemController.createItem(ItemCategory.TOOL,
        "Hammer", "Works fine! ", 10, member1.getEmail());
    Item item2 = itemController.createItem(ItemCategory.TOOL,
        "Hammer", "Works fine! ", 10, member2.getEmail());
    Item item3 = itemController.createItem(ItemCategory.VEHICLE,
        "Car", "Runs smoothly", 500, member1.getEmail());
    itemController.createItem(ItemCategory.GAME,
        "Board Game", "Fun for the family", 2, member4.getEmail());
    Item item5 = itemController.createItem(ItemCategory.TOY,
        "Action Figure", "Collectible toy", 12, member3.getEmail());
    Item item6 = itemController.createItem(ItemCategory.SPORT,
        "Basketball", "High-quality ball", 30, member2.getEmail());
    itemController.createItem(ItemCategory.OTHER,
        "Book", "Bestseller novel", 10, member5.getEmail());
    itemController.createItem(ItemCategory.TOOL,
        "Drill", "Powerful drill", 150, member6.getEmail());
    itemController.createItem(ItemCategory.VEHICLE,
        "Bicycle", "Great for commuting", 2, member4.getEmail());
    itemController.createItem(ItemCategory.GAME,
        "Video Game", "Exciting gameplay", 40, member2.getEmail());
    Item item11 = itemController.createItem(ItemCategory.TOY,
        "Puzzle", "Challenging puzzle", 2, member6.getEmail());
    itemController.createItem(ItemCategory.SPORT,
        "Soccer Ball", "Official size", 2, member3.getEmail());
    itemController.createItem(ItemCategory.OTHER,
        "Cookware Set", "High-quality pots", 7, member4.getEmail());
    Item item14 = itemController.createItem(ItemCategory.TOOL,
        "Screwdriver Set", "Versatile tools", 3, member3.getEmail());
    itemController.createItem(ItemCategory.VEHICLE,
        "Scooter", "Fuel-efficient", 3, member6.getEmail());
    itemController.createItem(ItemCategory.GAME,
        "Chess Set", "Classic strategy game", 15, member1.getEmail());

    contractController.createContract(member1, member2, item1, 2);
    contractController.createContract(member1, member3, item11, 2);
    contractController.createContract(member4, member3, item2, 3);
    contractController.createContract(member2, member4, item3, 4);
    contractController.createContract(member3, member5, item14, 4);
    contractController.createContract(member4, member6, item5, 2);
    contractController.createContract(member5, member1, item6, 3);

    System.out.println("Lender credits: " + member1.getCredits() + member1.getName());

  }*/


  /**
   * Application starting point.
   *
   * @param args command line arguments.MLNMJD
   */
  public static void main(String[] args) {
    App app = new App(); // Create an instance of the App class
    //app.data();
    UserInterface ui = app.ui; // Get the UserInterface instance from the App instance
    ui.mainMenu();
  }
}
