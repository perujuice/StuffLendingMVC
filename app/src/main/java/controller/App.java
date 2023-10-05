package controller;

import view.UserInterface;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    // adapt to start the application in your way
    UserInterface ui = new UserInterface(System.in);
    //ui.data();
    ui.displayMenu();
  }
}
