package controller;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

import model.Item;
=======
import java.util.stream.Collectors;
>>>>>>> ca32481c4092c530e1ebc90b32e6fe391c8363d3
import model.Member;

/**.
 * 
 */

public class MemberController {
  private List<Member> members;

  public MemberController() {
    // start list of members
    this.members = new ArrayList<>();
  }

  /**.
   * To create or add new members
   *
   * @param name
   *
   * @param email
   *
   * @param phoneNr
   *
   * @return
   *
   */
  public Member createMember(String name, String email, int phoneNr) {
    // check for uniqueness of variables
    if (isEmailUnique(email) && isPhoneNrUnique(phoneNr)) {
      Member newMember = new Member(name, email, phoneNr);
      members.add(newMember); // Add the new member to the list
      return newMember;
    } else {
      System.out.println("Email or Phone number is not unique! ");
      return null;
    }
  }

  // To delete a member
  public void deleteMember(String memberId) {
    members = members.stream().filter(m -> !m.getMemberId().equals(memberId)).collect(Collectors.toList());
  }

  public Member findMemberById(String memberId) {
    return members.stream().filter(m -> m.getMemberId().equals(memberId)).findFirst().orElse(null);
  }

  private boolean isEmailUnique(String email) {
    for (Member member : members) {
      if (member.getEmail() != null && member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

  private boolean isPhoneNrUnique(int phoneNr) {
    for (Member member : members) {
      if (member.getPhoneNr() == phoneNr) {
        return false;
      }
    }
    return true;
  }

  /**.
   *
   * @return
   *
   */
<<<<<<< HEAD
  public void printAllMemberInfo() {
=======
  public List<String> getAllMemberNames() {
    List<String> memberNames = new ArrayList<>();

>>>>>>> ca32481c4092c530e1ebc90b32e6fe391c8363d3
    for (Member member : members) {
        String memberId = member.getMemberId();
        System.out.println("\nMember Information for ID " + memberId + ":");
        printMemberInfo(memberId);
    }
  }
<<<<<<< HEAD

  public void listAllMembersVerbose() {
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
            }
        } else {
            System.out.println("This member does not own any items.");
        }
    }
  }

  /**
   * Method to delete a member.

   * @param memberId Id of member passed in.
   * @return  Returns a boolean to verify if it worked.
   */
  public boolean deleteMember(String memberId) {
    for (Member member : members) {
      if (member.getMemberId().equals(memberId)) {
        members.remove(member);
        return true; // Member deleted successfully
      }
    }
    return false; // Member not found
  }


  /**
   * A method to search for members.

   * @param memberId Id of a member to search.
   * @return Returns a member if found.
   */
  public Member searchMember(String memberId) {
    for (Member member : members) {
      if (member.getMemberId().equals(memberId)) {
        return member;
      }
    }
    return null; // member not found
  }

  /**8PTE0X
   * Prints all member info.

   * @param memberId Member Id passed in.
   */
  public void printMemberInfo(String memberId) {
    Member member = searchMember(memberId);
    if (member != null) {
      System.out.println("\nMember Information:");
      System.out.println("Name: " + member.getName());
      System.out.println("Email: " + member.getEmail());
      System.out.println("Phone Number: " + member.getPhoneNr());
      System.out.println("Number of owned Items: " + member.getOwnedItemCount());
      System.out.println("Credits: " + member.getCredits());
    } else {
      System.out.println("Member with ID " + memberId + " not found.");
    }
  }


  /**
   * Method to update member name.

   * @param memberId Member ID parameter.
   * @param newName New name for the member.
   * @return Returns a boolean.
   */
  public boolean updateMemberName(String memberId, String newName) {
    Member memberToUpdate = searchMember(memberId);
    if (memberToUpdate != null) {
      memberToUpdate.setName(newName); // Use the existing setter
      return true;
    }
    return false;
  }

  /**
   * Method to update member email.

   * @param memberId Member ID parameter.
   * @param newEmail  Member email for the member.
   * @return Returns a boolean.
   */
  public boolean updateMemberEmail(String memberId, String newEmail) {
    Member memberToUpdate = searchMember(memberId);
    if (memberToUpdate != null) {
      memberToUpdate.setEmail(newEmail); // Use the existing setter
      return true;
    }
    return false;
  }

  /**
   * Method to update phone numbers.

   * @param memberId Member ID parameter.
   * @param newPhoneNr Phone number to be changed.
   * @return Returns a boolean.
   */
  public boolean updateMemberPhoneNr(String memberId, int newPhoneNr) {
    Member memberToUpdate = searchMember(memberId);
    if (memberToUpdate != null) {
      memberToUpdate.setPhoneNr(newPhoneNr); // Use the existing setter
      return true;
    }
    return false;
  }
=======
>>>>>>> ca32481c4092c530e1ebc90b32e6fe391c8363d3
}