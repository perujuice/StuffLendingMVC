package view;

import controller.MemberController;
import java.util.List;
import model.Member;
import java.util.Scanner;

public class UI {
  private Scanner scanner;
  MemberController memberController = new MemberController();

  public UI() {
    scanner = new Scanner(System.in);
  }

  public void displayMenu() {
    System.out.println("Welcome to the Stuff Lending System!");

    while (true) {
      System.out.println("\nMain Menu:");
      System.out.println("1. Member Management");
      System.out.println("2. Item Management");
      System.out.println("3. Contract Management");
      System.out.println("4. Advance Time");
      System.out.println("5. Exit");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();

      switch (choice) {
        case 1:
          // Member Management
          handleMemberManagement();
          break;
        case 2:
          // Call a method to handle Item Management
          handleItemManagement();
          break;
        case 3:
          // Call a method to handle Contract Management
          handleContractManagement();
          break;
        case 4:
          // Call a method to handle advancing time
          advanceTime();
          break;
        case 5:
          System.out.println("Exiting the application.");
          scanner.close(); // Close the scanner before exiting
          System.exit(0);

        default:
          System.out.println("Invalid Choice. Please enter a valid option.");
        }
      }
  }

  private int getIntInput() {
    int input = -1;
    try {
      input = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      // Invalid input; do nothing, the loop will prompt again.
    }
    return input;
  }

  // methods to handle different functionalities
  private void handleMemberManagement() {
    System.out.println("Member Management:");
    // member management logic
    while (true) {
      System.out.println("\nMember Management Menu:");
      System.out.println("1. Create member");
      System.out.println("2. Delete member");
      System.out.println("3. View member information");
      System.out.println("4. Change member information");
      System.out.println("5. List all memebers");
      System.out.println("6. Back");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();

      switch (choice) {
        case 1:
          //Create Member.
          System.out.println("Creating a new member...\n");
          System.out.print("Enter the member's name: ");
          String name = scanner.nextLine();

          System.out.print("Enter the member's email: ");
          String email = scanner.nextLine();

          System.out.print("Enter the member's phone number: ");
          int phoneNr = scanner.nextInt();

          scanner.nextLine();
          // creat instance create a new member
          //MemberController memberController = new MemberController();
          Member newMember = memberController.createMember(name, email, phoneNr);

          // Print a confirmatiom message
          System.out.println("New member created with Member ID: " + newMember.getMemberId());
          break;
        
        case 2:
          //Deletes a member by member ID
          System.out.print("Enter the member's ID to be deleted: ");
          String mDeleteID = scanner.nextLine();
          memberController.deleteMember(mDeleteID);
          System.out.println("Member successfully deleted! ");
          break;


        case 3:
          // View member information
          //  This probably has to be updated to show more information!
          System.out.print("Enter the member's ID to view information: ");
          String mViewID = scanner.nextLine();
          memberController.printMemberInfo(mViewID);
        
        case 4:
          //Change member information by member ID
          changeMemberInfo();
          break;
        case 5:
          //list all members
          List<String> allMemberNames = memberController.getAllMemberNames();
          
          // Now 'allMemberNames' contains all member names
          for (String member_name : allMemberNames) {
              // Display the member name as needed
              System.out.println("Name: " + member_name);
          }
          break;

        case 6:
          displayMenu();
          break;
      }
    }
  }


  private void handleItemManagement() {
    System.out.println("Item Management:");
    // item management logic
    while (true) {
      System.out.println("\nItem Management Menu:");
      System.out.println("1. Create Item");
      System.out.println("2. List all Items");
      System.out.println("3. Back");

      System.out.print("\nEnter your choice: ");

      int choice = getIntInput();

      switch (choice) {
        case 1:
          // Create Item.
          System.out.println("Creating a new Item...\n");
          System.out.print("Enter the items's name: ");
          String name = scanner.nextLine();
      }
    
    }

  }

  private void handleContractManagement() {
    System.out.println("Contract Management:");
    // contract management logic
  }

  private void changeMemberInfo() {
    System.out.print("Enter the member's ID to change information: ");
    String mChangeID = scanner.nextLine();
    memberController.printMemberInfo(mChangeID);

        while (true) {
        System.out.println("\nWhat information would you like to change? ");
        System.out.println("1. Change name");
        System.out.println("2. Change Email");
        System.out.println("3. Change Phone Number");
        System.out.println("4. Back");
        
        System.out.print("\nEnter your choice: ");

        int choice = getIntInput();
        switch (choice) {
          case 1:
            //change the name
            System.out.print("Enter new name: ");
            String new_name = scanner.nextLine();
            memberController.updateMemberName(mChangeID, new_name);
            break;
          case 2:
            //change the email
            System.out.print("Enter new email: ");
            String new_email = scanner.nextLine();
            memberController.updateMemberEmail(mChangeID, new_email);
            break;
          case 3:
            //change the phone number
            System.out.print("Enter new phone number: ");
            int new_phoneNr = scanner.nextInt();
            memberController.updateMemberPhoneNr(mChangeID, new_phoneNr);
            break;
          case 4:
            handleMemberManagement();
            break;
          }
        }
  }

  private void advanceTime() {
    System.out.println("Advancing Time:");
    // time advancement logic
  }
}
