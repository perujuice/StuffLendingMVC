package controller;

import view.UI;

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
    UI ui = new UI();
    ui.data();
    ui.displayMenu();
  }
}
