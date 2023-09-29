package controller;

import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberController {
    private List<Member> members;

    public MemberController() {
        // start list of members
        members = new ArrayList<>();
    }

    public Member createMember(String name, String email, String phoneNr) {
        Member newMember = new Member(name, email, phoneNr);
        members.add(newMember); // Add the new member to the list
        return newMember;
    }
}
