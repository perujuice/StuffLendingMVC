package view;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.Member;

/**
 * Class for member UI.
 */
public class MemberView {
  private Scanner scanner;

  public MemberView() {
    this.scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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
   * Display member created.

   * @param newMember The member.
   * @return True if member created.
   */
  public boolean displayMemberCreated(Member newMember) {
    System.out.println("New member created with Member ID: " + newMember.getMemberId());
    return true;
  }

  /**
   * Getting member name from user input.

   * @return  Member name.
   */
  public String promptMemberName() {
    System.out.print("Enter the member's name: ");
    String name = scanner.nextLine();
    return name;
  }

  /**
   * Prompt for member email.

   * @return The email.
   */
  public String promtMemberEmail() {
    System.out.print("Enter the member's Email: ");
    String changeEmail = scanner.nextLine();
    return changeEmail;
  }

  /**
   * Getting member phone number from user input.

   * @return  Phone number.
   */
  public int promptMemberPhone() {
    System.out.print("Enter the member's phone number: ");
    int phoneNr = scanner.nextInt();
    scanner.nextLine();
    return phoneNr;
  }

  /**
   * Method to delete member based on user input.
   */
  public void displayDelete() {
    System.out.println("\nMember successfully deleted! ");
  }

  /**
   * Displays all members in a simple way.
   */
  public void displaySimpleList(List<Member> members) {
    for (Member member : members) {
      String memberEmail = member.getEmail();
      System.out.println("\nMember Information for Member email " + memberEmail + ":");
      printMemberInfo(member);
    }
  }

  /**
   * Lists all members in a verbose way.
   */
  public void displayVerboseList(List<Member> members) {
    for (Member member : members) {
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
   * Prompt for the name to change.
   */
  public String promptChangeName() {
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    return newName;
  }

  /**
   * Prompt user to change email.
   */
  public String promtChangeEmail() {
    System.out.print("Enter new email: ");
    String newEmail = scanner.nextLine();
    return newEmail;
  }

  /**
   * Prompt phone number to change.
   */
  public int promtChangePhone() {
    System.out.print("Enter new phone number: ");
    int newPhoneNr = scanner.nextInt();
    scanner.nextLine(); // Just to consumer the next line.
    return newPhoneNr;
  } 

  /**
   * Printing all member information.

   * @param member  Member passed in.
   */
  public void printMemberInfo(Member member) {
    System.out.println("\nMember Information:");
    System.out.println("Name: " + member.getName());
    System.out.println("Email: " + member.getEmail());
    System.out.println("Phone Number: " + member.getPhoneNr());
    System.out.println("Member ID: " + member.getMemberId());
    System.out.println("Number of owned Items: " + member.getOwnedItemCount());
    System.out.println("Credits: " + member.getCredits());
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
}