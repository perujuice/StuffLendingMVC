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
  private String memberId;
  private int credits;
  private List<Item> ownedItems;
  private Random random = new Random();

  /**
   * Constructor for member.
   * New name.
   * New email.
   * New phone number.
   */

  public Member(String newName, String newEmail, int newPhoneNr) {
    this.name = newName;
    this.email = newEmail;
    this.phoneNr = newPhoneNr;
    this.memberId = generateMemberId();
    this.ownedItems = new ArrayList<>();
    this.credits = 0;
  }

  /**
   * Copy constuctor.
   * The member copy
   */

  public Member(Member other) {
    this.name = other.name;
    this.email = other.email;
    this.phoneNr = other.phoneNr;
    this.memberId = other.memberId;
    this.ownedItems = new ArrayList<>(other.ownedItems);
    this.credits = other.credits;
  }

  public String getName() {
    return name;
  }

  public void updateName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void updateEmail(String newEmail) {
    this.email = newEmail;
  }

  public int getPhoneNr() {
    return phoneNr;
  }

  public void updatePhoneNr(int phoneNr) {
    this.phoneNr = phoneNr;
  }

  private String generateMemberId() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char[] memberId = new char[6];

    for (int i = 0; i < 6; i++) {
      int randomIndex = random.nextInt(characters.length());
      memberId[i] = characters.charAt(randomIndex);
    }

    return new String(memberId);
  }

  public String getMemberId() {
    return memberId;
  }

  public void addCredits(int amount) {
    credits += amount;
  }

  public void deductCredits(int amount) {
    credits -= amount;
  }

  public int getCredits() {
    return credits;
  }

  /**
   * Links items to its owner.
   * The item owned by the member.
   * 
   */

  public void addItem(Item item) {
    ownedItems.add(item);
    this.credits += 100;
  }

  public List<Item> getOwnedItems() {
    return new ArrayList<>(ownedItems);
  }

  public int getOwnedItemCount() {
    return ownedItems.size();
  }

  public void removeOwnedItem(Item item) {
    ownedItems.remove(item);
  }
}
