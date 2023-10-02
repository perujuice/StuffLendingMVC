package controller;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberController {
    private List<Member> members;

    public MemberController() {
        // start list of members
        this.members = new ArrayList<>();
    }

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

    public List<String> getAllMemberNames() {
        List<String> memberNames = new ArrayList<>();
    
        for (Member member : members) {
            memberNames.add(member.getName());
        }
    
        return memberNames;
    }

    //Probably needs to be modified once we implement everything for the items
    //Since when a member is deleted the items belonging to that member should be deleted as well.
    public boolean deleteMember(String memberID) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberID)) {
                members.remove(member);
                return true; // Member deleted successfully
            }
        }
        return false; // Member not found
    }
}