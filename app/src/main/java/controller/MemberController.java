package controller;

import java.util.ArrayList;
import java.util.List;
import model.Member;

/**
 * Controller class for member methods.
 */
public class MemberController {
  private List<Member> members;

  public MemberController() {
    // start list of members
    this.members = new ArrayList<>();
  }

  /**
   * Method to create a new member.

   * @param name Member name.
   * @param email Member email.
   * @param phoneNr Member phone number.
   * @return Returns the member.
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

  /**
   * A method to get all members.

   * @return Returns a list of member names.
   */
  public List<String> getAllMemberNames() {
    List<String> memberNames = new ArrayList<>();
    for (Member member : members) {
      memberNames.add(member.getName());
    }

    return memberNames;
  }

  //Probably needs to be modified once we implement everything for the items
  //Since when a member is deleted the items belonging to that member should be deleted as well.

  /**
   * Method to delete a membver.

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

  /**
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
}