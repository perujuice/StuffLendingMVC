package model;

/**
 * This class will handle the lending contract information.
 */
public class Contract {
    private Member member; //these are just some ideas for attributes for now.
    private Item item;
    private String startDate;
    private String endDate;

    public Contract(Member a_member, Item a_item, String a_startDate, String a_endDate) {
        member = a_member;
        item = a_item;
        startDate = a_startDate;
        endDate = a_endDate;
    }


    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
