package controller;

import view.MemberView;

/**
 * Controller class for member methods.
 */
public class MemberController {
  MemberView view;
  UserInterface ui;

  public MemberController(MemberView v, UserInterface ui) {
    this.view = v;
    this.ui = ui;
  }

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
    boolean continueManagingMembers = true;

    while (continueManagingMembers) {
      view.displayMemberOptions();

      MemberOptions selectedOption = displayMemberManagementMenu();

      switch (selectedOption) {
        case CREATE_MEMBER:
          continueManagingMembers = view.memberCreateInput();
          break;
        case DELETE_MEMBER:
          view.displayDelete();
          break;
        case VIEW_MEMBER_INFORMATION:
          String email = view.toDisplayMemberInfo();
          view.printMemberInfo(email);
          break;
        case CHANGE_MEMBER_INFORMATION:
          changeMemberInfo();
          break;
        case LIST_MEMBERS_SIMPLE:
          view.displaySimpleList();
          break;
        case LIST_MEMBERS_VERBOSE:
          view.displaySimpleList();
          break;
        case BACK:
          continueManagingMembers = false;
          ui.mainMenu();
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
    }
  }

  private MemberOptions displayMemberManagementMenu() {
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
    String changeEmail = view.promtMemberEmail();
    switch (option) {
      case NAME:
        view.promptChangeName(changeEmail);
        break;
      case EMAIL:
        view.promtChangeEmail(changeEmail);
        break;
      case PHONE:
        view.promtChangePhone(changeEmail);
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
        return ChangeMemberInfo.PHONE;
      case 4:
        return ChangeMemberInfo.BACK;
      default:
        return null;
    }
  }
}