package controller;

import view.MemberView;

/**
 * Controller class for member methods.
 */
public class MemberController {
  MemberView view;

  private enum MemberOptions {
    CREATE_MEMBER,
    DELETE_MEMBER,
    VIEW_MEMBER_INFORMATION,
    CHANGE_MEMBER_INFORMATION,
    LIST_MEMBERS_SIMPLE,
    LIST_MEMBERS_VERBOSE,
    BACK;
  }

  private enum ChangeMemberInfo {
    NAME,
    EMAIL,
    PHONE, 
    BACK;
  }

  public void handleMemberManagement() {
    view.displayMemberOptions();

    MemberOptions selectedOption = displayMemberManagementMenu();

    switch (selectedOption) {
      case CREATE_MEMBER:

        break;
      case DELETE_MEMBER:

        break;
      case VIEW_MEMBER_INFORMATION:
                // Handle viewing member information
        break;
      case CHANGE_MEMBER_INFORMATION:
        changeMemberInfo();
        break;
      case LIST_MEMBERS_SIMPLE:
                // Handle listing members in a simple way
        break;
      case LIST_MEMBERS_VERBOSE:
                // Handle listing members in a verbose way
        break;
      case BACK:
                // Do nothing or handle going back to the main menu
        break;
      default:
        System.out.println("Invalid option. Please try again.");
        break;
      }
    }

  private MemberOptions displayMemberManagementMenu() {
    // Implement logic to display the member management menu and get user input for the selected option
    int selectedOption = view.getIntInput();

    switch (selectedOption) {
      case 1:
        return MemberOptions.CREATE_MEMBER;
      case 2:
        return MemberOptions.DELETE_MEMBER;
      case 3:
        return MemberOptions.VIEW_MEMBER_INFORMATION;
      case 4:
        return MemberOptions.CHANGE_MEMBER_INFORMATION;
      case 5:
        return MemberOptions.LIST_MEMBERS_SIMPLE;
      case 6:
        return MemberOptions.LIST_MEMBERS_VERBOSE;
      case 7:
        return MemberOptions.BACK;
      default:
        return null;
    }
  }

  private void changeMemberInfo() {
    ChangeMemberInfo option = displayChange();

    switch (option) {
      case NAME:
        break;
      case EMAIL:
        break;
      case BACK:
        break;
      default:
        throw new IllegalArgumentException("Invalid Input! ");
    }
  }

  private ChangeMemberInfo displayChange() {
    view.displayChangeOptions();
    int selectedOption = view.getIntInput();

    switch (selectedOption) {
      case 1:
        return ChangeMemberInfo.NAME;
      case 2:
        return ChangeMemberInfo.EMAIL;
      case 3:
        return ChangeMemberInfo.BACK;
      default:
        return null;
    }
  }
}