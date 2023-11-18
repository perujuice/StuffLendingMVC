package view;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import model.TimeManager;

/**
 * Main menu view.
 */
public class MainView {
  private Scanner scanner;
  private TimeManager time;

  public MainView(TimeManager t) {
    this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    this.time = t;
  }

  public void displayWelcome() {
    System.out.println("\nWelcome to the Stuff Lending System!");
    System.out.println("Current day: " + time.getCurrentDay());
  }

  /**
   * Main display menu.
   */
  public void displayMainMenu() {
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
   * return Input integer.
   */
  public int getIntInput() {
    while (true) {
      try {
        String inputLine = scanner.nextLine();
        if (inputLine.trim().isEmpty()) {
          System.out.println("No input detected. Please enter a number:");
          continue;
        }
        return Integer.parseInt(inputLine);
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number:");
        // The loop continues, prompting the user again.
      }
    }
  }

}