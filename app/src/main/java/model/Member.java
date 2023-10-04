package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class will handle member information.
 */
public class Member {
    private String name;
    private String email;
    private int phoneNr;
    // Generate a unique member ID.
    private String memberID;
    private int credits;
    private List<Item> ownedItems;
    private String creationDate;
    // Owned Items
    // private List<Item> ownedItems = new ArrayList<>();

    public Member(String a_name, String a_email, int a_phoneNr) {
        this.name = a_name;
        this.email = a_email;
        this.phoneNr = a_phoneNr;
        this.memberID = generateMemberID();
        this.ownedItems = new ArrayList<>();
        this.credits = 0;
        //this.creationDate = getCurrentDateTime();
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

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }

    
    private String generateMemberID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] memberID = new char[6];

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(characters.length());
            memberID[i] = characters.charAt(randomIndex);
        }

        return new String(memberID);
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

    /**
     * Links items to its owner.

     * @param item The item owned by the member.
     */
    public void addItem(Item item) {
        ownedItems.add(item);
        this.credits += 100;
    }

    public int getOwnedItemCount() {
        return ownedItems.size();
    }
}
