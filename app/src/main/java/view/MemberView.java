package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Contract;
import model.Item;
import model.Member;
import model.MemberRegistry;

/**
 * Class for member UI.
 */
public class MemberView {
  private Scanner scanner;
  private MemberRegistry memberRegistry;

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

  public void memberCreateInput() {
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
    Member newMember = memberRegistry.createMember(name, email, phoneNr);
    System.out.println("New member created with Member ID: " + newMember.getMemberId());
  }

  public void displayDelete() {
    System.out.print("\nEnter the member's email to be deleted: ");
    String deleteEmail = scanner.nextLine();
    memberRegistry.deleteMember(deleteEmail);
    System.out.println("\nMember successfully deleted! ");
  }

  public String toDisplayMemberInfo() {
    System.out.print("Enter the member's email to view information: ");
    String viewEmail = scanner.nextLine();
    return viewEmail;
  }

  public void displaySimpleList() {
    Map<String, Member> members = memberRegistry.getMembers();
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
    Map<String, Member> members = memberRegistry.getMembers();
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

  public int getIntInput() {
    int input = -1;
    try {
      input = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      // Invalid input; do nothing, the loop will prompt again.
    }
    return input;
  }

  public void displayChangeOptions() {
    System.out.println("\nWhat information would you like to change? ");
    System.out.println("1. Change name");
    System.out.println("2. Change Email");
    System.out.println("3. Change Phone Number");
    System.out.println("4. Back");
  }

  public String promtMemberEmail() {
    System.out.print("Enter the member's Email to change information: ");
    String changeEmail = scanner.nextLine();
    return changeEmail;
  }

  public void promptChangeName(String changeEmail) {
    System.out.print("Enter new name: ");
    String newName = scanner.nextLine();
    memberRegistry.updateMemberName(changeEmail, newName);
  }

  public void promtChangeEmail(String changeEmail) {
    System.out.print("Enter new email: ");
    String newEmail = scanner.nextLine();
    memberRegistry.updateMemberEmail(changeEmail, newEmail);
  }

  public void promtChangePhone(String changeEmail) {
    System.out.print("Enter new phone number: ");
    int newPhoneNr = scanner.nextInt();
    memberRegistry.updateMemberPhoneNr(changeEmail, newPhoneNr);
    scanner.nextLine(); // Just to consumer the next line.
  } 

  /**
   * Prints all member info.

   * @param email Email passed in.
   */
  public void printMemberInfo(String email) {
    Member member = memberRegistry.searchMember(email);

    System.out.println("\nMember Information:");
    System.out.println("Name: " + member.getName());
    System.out.println("Email: " + member.getEmail());
    System.out.println("Phone Number: " + member.getPhoneNr());
    System.out.println("Number of owned Items: " + member.getOwnedItemCount());
    System.out.println("Credits: " + member.getCredits());
  }

}