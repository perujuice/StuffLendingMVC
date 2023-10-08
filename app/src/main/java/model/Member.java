package model;

import java.util.Random;

/**
 * This class will handle member information.
 */
public class Member {
  private String name;
  private String email;
  private int phoneNr;
  // Generate a unique member ID.
  private String memberId;
  private int credits;
  // Owned Items
  // private List<Item> ownedItems = new ArrayList<>();

  /**.
   *
   * @param aname
   *
   * @param aemail
   * 
   * @param memberId2
   * 
   */
  public Member(String aname, String aemail, int memberId2) {
    this.name = aname;
    this.email = aemail;
    this.phoneNr = memberId2;
    this.memberId = generateMemberId();
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

  private String generateMemberId() {
    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    Random random = new Random();
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

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

<<<<<<< HEAD
  /**
   * Links items to its owner.
   * 
   * @param item The item owned by the member.
   */
  public void addItem(Item item) {
    ownedItems.add(item);
    this.credits += 100;
  }

  public List<Item> getOwnedItems() {
    return this.ownedItems;
  }

  public int getOwnedItemCount() {
    return ownedItems.size();
  }

  public void removeOwnedItem(Item item) {
    ownedItems.remove(item);
=======
  public void editName(String newName) {
>>>>>>> ca32481c4092c530e1ebc90b32e6fe391c8363d3
  }
}
