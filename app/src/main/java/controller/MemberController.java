package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
  public List<String> getAllMemberNames() {
    List<String> memberNames = new ArrayList<>();

    for (Member member : members) {
      memberNames.add(member.getName());
    }

    return memberNames;
  }
}