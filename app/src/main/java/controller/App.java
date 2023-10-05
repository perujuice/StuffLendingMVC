package controller;

import view.ItemManagement;
import view.MemberManagement;
import view.UserInterface;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.MLNMJD
   */

  public static void main(String[] args) {

    MemberController memberController = new MemberController();
    ItemController itemController = new ItemController(memberController);
    MemberManagement memberManagement = new MemberManagement(memberController, itemController);
    memberManagement.data();
    UserInterface ui = new UserInterface(memberController, itemController);
    ui.displayMenu();

  }
}
