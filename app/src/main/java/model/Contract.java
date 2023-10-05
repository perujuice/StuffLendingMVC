package model;

/**
 * This class will handle the lending contract information.
 */
public class Contract {
  //private Member member; //these are just some ideas for attributes for now.
  //private Item item;
  private String startDate;
  private String endDate;

  /**
   * Constructor for contract.

   * @param newMember Member.
   * @param newItem Item.
   * @param newStartDate Start date.
   * @param newEndDate End date.
   */
  public Contract(Member newMember, Item newItem, String newStartDate, String newEndDate) {
    //member = newMember;
    //item = newItem;
    startDate = newStartDate;
    endDate = newEndDate;
  }


  public String getStartDate() {
    return startDate;
  }

  public String getEndDate() {
    return endDate;
  }
}
