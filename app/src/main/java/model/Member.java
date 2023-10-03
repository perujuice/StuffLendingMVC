package model;

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
  // Owned Items
  // private List<Item> ownedItems = new ArrayList<>();

  /**
   * Constructor for Member object.

   * @param a_name New name.
   * @param a_email New email.
   * @param a_phoneNr New phone number.
   */
  public Member(String a_name, String a_email, int a_phoneNr) {
    this.name = a_name;
    this.email = a_email;
    this.phoneNr = a_phoneNr;
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
}
