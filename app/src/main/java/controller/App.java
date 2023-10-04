package controller;

import view.MemberManagement;
import view.UI;

import java.util.Scanner;

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
    Scanner scanner = new Scanner(System.in);
    MemberController memberController = new MemberController();
    MemberManagement memberManagement = new MemberManagement(scanner, memberController);
    memberManagement.data();
    UI ui = new UI(scanner, memberController);
    ui.displayMenu();
  }
}
