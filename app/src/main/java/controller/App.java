package controller;

import java.util.Scanner;
import view.MemberManagement;
import view.UI;

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
    // adapt to start the application in your way
    Scanner scanner = new Scanner(System.in);
    MemberController memberController = new MemberController();
    MemberManagement memberManagement = new MemberManagement(scanner, memberController);
    memberManagement.data();
    UI ui = new UI(scanner, memberController);
    ui.displayMenu();

  }
}
