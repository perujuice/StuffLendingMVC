package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will handle member information.
 */
public class Member {
    private String name;
    private String email;
    private int phoneNr;
    // Generate a unique member ID.
    // Owned Items
    // private List<Item> ownedItems = new ArrayList<>();

    public Member(String new_name, String new_email, int new_phoneNr) {
        name = new_name;
        email = new_email;
        phoneNr = new_phoneNr;
    }

    // We can do it like this to make sure the view only depoends on the model.
    // So no toString method should be in the model package.
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNr() {
        return phoneNr;
    }

}
