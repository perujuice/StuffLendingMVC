package controller;

import model.TimeManager;
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
    TimeManager timeManager = new TimeManager();
    MemberController memberController = new MemberController(timeManager);
    ItemController itemController = new ItemController(memberController, timeManager);
    MemberManagement memberManagement = new MemberManagement(memberController, itemController);
    memberManagement.data();
    UserInterface ui = new UserInterface(memberController, itemController);
    ui.displayMenu();

  }
}
