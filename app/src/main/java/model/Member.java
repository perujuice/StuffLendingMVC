package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class will handle member information.
 */
public class Member {
    private String name;
    private String email;
    private String phoneNr;
    // Generate a unique member ID.
    private String memberID;
    private int credits;
    // Owned Items
    // private List<Item> ownedItems = new ArrayList<>();

    public Member(String name, String email, String phoneNr) {
        this.name = name;
        this.email = email;
        this.phoneNr = phoneNr;
    }

    // We can do it like this to make sure the view only depoends on the model.
    // So no toString method should be in the model package.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getMemberId() {
        return memberID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
