package controller;

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
  TimeManager time = new TimeManager();
  DataManager data = new DataManager(time);
  MainView view = new MainView(time);
  MemberView memberView = new MemberView(data);
  ItemView itemView = new ItemView(data);
  ContractView contractView = new ContractView(data); 
  UserInterface ui = new UserInterface(view, memberView, itemView, contractView, time, data);

  public void initiateApp() {
    data.persistentData();
    view.displayWelcome();
  }

  /**
   * Application starting point.
   *
   * @param args command line arguments.MLNMJD
   */
  public static void main(String[] args) {
    App app = new App(); // Create an instance of the App class
    app.initiateApp();
    UserInterface ui = app.ui;
    ui.mainMenu();
  }
}
