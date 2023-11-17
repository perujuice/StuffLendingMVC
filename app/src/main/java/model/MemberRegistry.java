package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Member wrapper class for member methods, retrieval and creaton of members.
 */
public class MemberRegistry {
  private Map<String, Member> members = new HashMap<>();
  TimeManager time;

  /**
   * Constructor for member controller.

   * @param time Time is passed in.
   */
  public MemberRegistry(TimeManager time) {
    this.time = time;
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
      members.put(newMember.getEmail(), newMember); // Add the new member to the map with email as unique.
      int dayOfCreation = time.getCurrentDay();
      System.out.println("Member added to the list with ID: " + newMember.getMemberId()
          + " Date of creation: " + dayOfCreation);
      return newMember;
    } else {
      System.out.println("Email or Phone number is not unique! ");
      return null;
    }
  }

  public void updateMember(Member updatedMember) {
    members.put(updatedMember.getEmail(), updatedMember);
  }

  private boolean isEmailUnique(String email) {
    for (Member member : members.values()) {
      if (member.getEmail() != null && member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

  private boolean isPhoneNrUnique(int phoneNr) {
    for (Member member : members.values()) {
      if (member.getPhoneNr() == phoneNr) {
        return false;
      }
    }
    return true;
  }

  public Map<String, Member> getMembers() {
    return members;
  }

  /**
   * Method to delete a member.

   * @param email email of member passed in.
   * @return  Returns a boolean to verify if it worked.
   */
  public boolean deleteMember(String email) {
    Member memberToRemove = members.get(email);
    if (memberToRemove != null) {
      members.remove(email);
      return true; // Member deleted successfully
    } else {
      return false; // Member not found
    }
  }

  /**
   * A method to search for members.

   * @param email Email of a member to search.
   * @return Returns a member if found.
   */
  public Member searchMember(String email) {
    return members.get(email);
  }


  /**
   * Method to update member name.

   * @param email Email parameter.
   * @param newName New name for the member.
   * @return Returns a boolean.
   */
  public boolean updateMemberName(String email, String newName) {
    Member memberToUpdate = searchMember(email);
    if (memberToUpdate != null) {
      memberToUpdate.updateName(newName); // Use the existing setter
      updateMember(memberToUpdate);
      return true;
    }
    return false;
  }

  /**
   * Method to update member email.

   * @param email Email parameter.
   * @param newEmail  Member email for the member.
   * @return Returns a boolean.
   */
  public boolean updateMemberEmail(String email, String newEmail) {
    Member memberToUpdate = searchMember(email);
    if (memberToUpdate != null) {
      memberToUpdate.updateEmail(newEmail); // Use the existing setter
      updateMember(memberToUpdate);
      return true;
    }
    return false;
  }

  /**
   * Method to update phone numbers.

   * @param email Email parameter.
   * @param newPhoneNr Phone number to be changed.
   * @return Returns a boolean.
   */
  public boolean updateMemberPhoneNr(String email, int newPhoneNr) {
    Member memberToUpdate = searchMember(email);
    if (memberToUpdate != null) {
      memberToUpdate.updatePhoneNr(newPhoneNr); // Use the existing setter
      updateMember(memberToUpdate);
      return true;
    }
    return false;
  }
}
