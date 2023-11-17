package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Contract;
import model.DataManager;
import model.Item;
import model.Member;

/**
 * Class for member UI.
 */
public class MemberView {
  private Scanner scanner;
  private DataManager data;

  public MemberView(DataManager d) {
    this.scanner = new Scanner(System.in);
    this.data = d;
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

  /**
   * Creating member with user input.

   * @return True if created sucessfully.
   */
  public Boolean memberCreateInput() {
    System.out.println("Creating a new member...\n");
    System.out.print("Enter the member's name: ");
    final String name = scanner.nextLine();

    System.out.print("Enter the member's email: ");
    final String email = scanner.nextLine();

    System.out.print("Enter the member's phone number: ");
    final int phoneNr = scanner.nextInt();

    scanner.nextLine();
    
    Member newMember = data.getMemberRegistry().createMember(name, email, phoneNr);
    System.out.println("New member created with Member ID: " + newMember.getMemberId());
    
    return true;
  }

  /**
   * Method to delete member based on user input.
   */
  public void displayDelete() {
    System.out.print("\nEnter the member's email to be deleted: ");
    String deleteEmail = scanner.nextLine();
    data.getMemberRegistry().deleteMember(deleteEmail);
    System.out.println("\nMember successfully deleted! ");
  }

  /**
   * Display all member detail.

   * @return The email.
   */
  public String toDisplayMemberInfo() {
    System.out.print("Enter the member's email to view information: ");
    String viewEmail = scanner.nextLine();
    return viewEmail;
  }

  /**
   * Displays all members in a simple way.
   */
  public void displaySimpleList() {
    Map<String, Member> members = data.getMemberRegistry().getMembers();
    for (Member member : members.values()) {
      String memberEmail = member.getEmail();
      System.out.println("\nMember Information for Member email " + memberEmail + ":");
      printMemberInfo(memberEmail);
    }
  }

  /**
   * Lists all members in a verbose way.
   */
  public void displayVerboseList() {
    Map<String, Member> members = data.getMemberRegistry().getMembers();
    for (Member member : members.values()) {
      System.out.println("\nMember Information:");
      System.out.println("Name: " + member.getName());

      // List owned items for this member
      List<Item> ownedItems = member.getOwnedItems();
      if (!ownedItems.isEmpty()) {
        System.out.println("Owned Items:");
        for (Item item : ownedItems) {
          System.out.println("  \nItem Name: " + item.getName());
          System.out.println("  Item Category: " + item.getCategory());
          System.out.println("  Item Description: " + item.getShortDescription());
          System.out.println("  Item Cost Per Day: " + item.getCostPerDay());
          // Add more item details as needed
          // Check if the item has active contracts
          List<Contract> activeContracts = item.getContracts();
          if (!activeContracts.isEmpty()) {
            System.out.println("  Item is currently lent out to:");

            // Display information about the borrowers and time periods
            for (Contract contract : activeContracts) {
              System.out.println("    Borrower: " + contract.getBorrower().getName());
              System.out.println("    Start Date: " + contract.getStartDate());
              System.out.println("    End Date: " + contract.getEndDate());
            }
          } else {
            System.out.println("  This item is not currently lent out.");
          }
        }
      } else {
        System.out.println("This member does not own any items.");
      }
    }
  }

  /**
   * Getting the user input.

   * @return The user input.
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

  /**
   * Display all change options.
   */
  public void displayChangeOptions() {
    System.out.println("\nWhat information would you like to change? ");
    System.out.println("1. Change name");
    System.out.println("2. Change Email");
    System.out.println("3. Change Phone Number");
    System.out.println("4. Back");
  }

  /**
   * Prompt for member email.

   * @return The email.
   */
  public String promtMemberEmail() {
    System.out.print("Enter the member's Email to change information: ");
    String changeEmail = scanner.nextLine();
    return changeEmail;
  }

  /**
   * Prompt for the name to change.

   * @param changeEmail Email to change.
   */
  public void promptChangeName(String changeEmail) {
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    data.getMemberRegistry().updateMemberName(changeEmail, newName);
  }

  /**
   * Prompt user to change email.

   * @param changeEmail Email to change.
   */
  public void promtChangeEmail(String changeEmail) {
    System.out.print("Enter new email: ");
    String newEmail = scanner.nextLine();
    data.getMemberRegistry().updateMemberEmail(changeEmail, newEmail);
  }

  /**
   * Prompt phone number to change.

   * @param changeEmail Email to change.
   */
  public void promtChangePhone(String changeEmail) {
    System.out.print("Enter new phone number: ");
    int newPhoneNr = scanner.nextInt();
    data.getMemberRegistry().updateMemberPhoneNr(changeEmail, newPhoneNr);
    scanner.nextLine(); // Just to consumer the next line.
  } 

  /**
   * Prints all member info.

   * @param email Email passed in.
   */
  public void printMemberInfo(String email) {
    Member member = data.getMemberRegistry().searchMember(email);

    System.out.println("\nMember Information:");
    System.out.println("Name: " + member.getName());
    System.out.println("Email: " + member.getEmail());
    System.out.println("Phone Number: " + member.getPhoneNr());
    System.out.println("Number of owned Items: " + member.getOwnedItemCount());
    System.out.println("Credits: " + member.getCredits());
  }

}