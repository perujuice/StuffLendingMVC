package view;

import controller.MemberController;
import java.util.Scanner;
import model.Member;

/**
 * Class for member UI.
 */
public class MemberView {
  private Scanner scanner;
  private MemberController memberController;

  /**
   * Constructor for member UI class.

   * @param originalController Member controller instance passed for persistance.
   */
  public MemberView(MemberController originalController) {
    this.scanner = new Scanner(System.in, "UTF-8");
    this.memberController = originalController; // Create a copy if the memberController.
  }

  /**
   * Method for user input.
   */
  public void displayMemberOptions() {
    System.out.println("\nMember Management Menu:");
    System.out.println("\n1. Create member");
    System.out.println("2. Delete member");
    System.out.println("3. View member information");
    System.out.println("4. Change member information");
    System.out.println("5. List all memebers in a simple way");
    System.out.println("6. List all members in a verbose way ");
    System.out.println("7. Back");

    System.out.print("\nEnter your choice: ");
  }

  public void displayChangeOptions() {
    System.out.println("\nWhat information would you like to change? ");
    System.out.println("1. Change name");
    System.out.println("2. Change Email");
    System.out.println("3. Change Phone Number");
    System.out.println("4. Back");
  }

  
      switch (choice) {
        case 1:
          // Create Member.
          System.out.println("Creating a new member...\n");
          System.out.print("Enter the member's name: ");
          final String name = scanner.nextLine();

          System.out.print("Enter the member's email: ");
          final String email = scanner.nextLine();

          System.out.print("Enter the member's phone number: ");
          final int phoneNr = scanner.nextInt();

          scanner.nextLine();
          // creat instance create a new member
          // MemberController memberController = new MemberController();
          Member newMember = memberController.createMember(name, email, phoneNr);

          // Print a confirmatiom message
          System.out.println("New member created with Member ID: " + newMember.getMemberId());
          break;

        case 2:
          // Deletes a member by member ID
          System.out.print("Enter the member's email to be deleted: ");
          String deleteEmail = scanner.nextLine();
          memberController.deleteMember(deleteEmail);
          System.out.println("Member successfully deleted! ");
          break;

        case 3:
          // View member information
          // This probably has to be updated to show more information!
          System.out.print("Enter the member's ID to view information: ");
          String viewEmail = scanner.nextLine();
          memberController.printMemberInfo(viewEmail);
          break;

        case 4:
          // Change member information by member ID
          changeMemberInfo();
          break;
        case 5:
          // list all member info in a simple way.
          memberController.printAllMemberInfo();
          break;
        case 6:
          memberController.listAllMembersVerbose();
          break;
        case 7:
          return;
        default:
          throw new IllegalArgumentException("Invalid choice.");
      }
    }
  }

  public int getIntInput() {
    int input = -1;
    try {
      input = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      // Invalid input; do nothing, the loop will prompt again.
    }
    return input;
  }

  private void changeMemberInfo() {
    System.out.print("Enter the member's Email to change information: ");
    String changeEmail = scanner.nextLine();
    memberController.printMemberInfo(changeEmail);

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
          // change the name
          System.out.print("Enter new name: ");
          String newName = scanner.nextLine();
          memberController.updateMemberName(changeEmail, newName);
          break;
        case 2:
          // change the email
          System.out.print("Enter new email: ");
          String newEmail = scanner.nextLine();
          memberController.updateMemberEmail(changeEmail, newEmail);
          break;
        case 3:
          // change the phone number
          System.out.print("Enter new phone number: ");
          int newPhoneNr = scanner.nextInt();
          memberController.updateMemberPhoneNr(changeEmail, newPhoneNr);
          scanner.nextLine(); // Just to consumer the next line.
          break;
        case 4:
          return;
        default:
          throw new IllegalArgumentException("Invalid input.");
      }
    }
  }
}