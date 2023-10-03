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

    public Member searchMember(String memberID) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberID)) {
                return member;
            }
        }
		return null; // member not found
    }

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

    public boolean updateMemberName(String memberId, String newName) {
        Member memberToUpdate = searchMember(memberId);
        if (memberToUpdate != null) {
            memberToUpdate.setName(newName); // Use the existing setter
            return true;
        }
        return false;
    }

    public boolean updateMemberEmail(String memberId, String newEmail) {
        Member memberToUpdate = searchMember(memberId);
        if (memberToUpdate != null) {
            memberToUpdate.setEmail(newEmail); // Use the existing setter
            return true;
        }
        return false;
    }

    public boolean updateMemberPhoneNr(String memberId, int newPhoneNr) {
        Member memberToUpdate = searchMember(memberId);
        if (memberToUpdate != null) {
            memberToUpdate.setPhoneNr(newPhoneNr); // Use the existing setter
            return true;
        }
        return false;
    }
}