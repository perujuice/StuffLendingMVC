package model;

/**
 * Class for handling time.
 */
public class TimeManager {
  private int currentDay;

  public TimeManager() {
    // Initialize the current day to 1 when the system starts
    this.currentDay = 1;
  }

  public int getCurrentDay() {
    return currentDay;
  }

  public void advanceDay() {
    // Method to advance the current day by 1
    currentDay++;
  }
}
