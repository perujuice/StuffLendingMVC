package controller;

import java.util.Scanner;
import model.DataManager;
import model.TimeManager;
import view.ContractView;
import view.ItemView;
import view.MainView;
import view.MemberView;


/**
 * Responsible for staring the application.
 */
public class App {
  Scanner scanner = new Scanner(System.in);
  TimeManager time = new TimeManager();
  DataManager data = new DataManager(time);
  MainView view = new MainView(scanner, time);
  MemberView memberView = new MemberView(data);
  ItemView itemView = new ItemView(scanner, data);
  ContractView contractView = new ContractView(scanner, data); 
  UserInterface ui = new UserInterface(view, memberView, itemView, contractView, time, data);

  public void initiateData() {
    data.persistentData();
  }

  /**
   * Application starting point.
   *
   * @param args command line arguments.MLNMJD
   */
  public static void main(String[] args) {
    App app = new App(); // Create an instance of the App class
    app.initiateData();
    UserInterface ui = app.ui;
    ui.mainMenu();
  }
}
