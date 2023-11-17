package view;

import java.util.Scanner;
import model.TimeManager;

/**
 * Main menu view.
 */
public class MainView {
  private Scanner scanner;
  private TimeManager time;

  public MainView(Scanner scanner, TimeManager t) {
    this.scanner = scanner;
    this.time = t;
  }

  /**
   * Main display menu.
   */
  public void displayMainMenu() {
    TimeManager time = new TimeManager();
    System.out.println("Welcome to the Stuff Lending System!");
    System.out.println("Current day: " + time.getCurrentDay());

    System.out.println("\nMain Menu:");
    System.out.println("1. Member Management");
    System.out.println("2. Item Management");
    System.out.println("3. Contract Management");
    System.out.println("4. Advance Time");
    System.out.println("5. Exit");

    System.out.print("\nEnter your choice: ");
  }


  public void displayTime() {
    System.out.println("Current day: " + time.getCurrentDay());
  }

  /**
   * Display exit message.
   */
  public void displayExit() {
    System.out.println("Exiting the application...");
    scanner.close();
    throw new RuntimeException("Application has been terminated.");
  }

  /**
   * Method for user input.

   * @return Input integer.
   */
  public int getIntInput() {
    int input = -1;
    try {
      input = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      // Invalid input; do nothing, the loop will prompt again.
    }
    return input;
  }
}