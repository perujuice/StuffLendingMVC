package controller;

import view.MemberManagement;
import view.UserInterface;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */

  public static void main(String[] args) {

    MemberController memberController = new MemberController();
    MemberManagement memberManagement = new MemberManagement(memberController);
    memberManagement.data();
    UserInterface ui = new UserInterface(memberController);
    ui.displayMenu();

  }
}
