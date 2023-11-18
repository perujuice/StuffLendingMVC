package controller;

import java.util.List;
import model.DataManager;
import model.Member;
import view.MemberView;

/**
 * Controller class for member methods.
 */
public class MemberController {
  MemberView view;
  UserInterface ui;
  DataManager data;

  /**
   * Constructor for member controller.
   * v Member view.
   * ui User interface.
   * d Data.
   */
  public MemberController(MemberView v, UserInterface ui, DataManager d) {
    this.view = v;
    this.ui = ui;
    this.data = d;
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

  /**
   * Method to handle user options.
   */
  public void handleMemberManagement() {
    boolean continueManagingMembers = true;

    while (continueManagingMembers) {
      view.displayMemberOptions();

      MemberOptions selectedOption = displayMemberManagementMenu();

      switch (selectedOption) {
        case CREATE_MEMBER:
          String name = view.promptMemberName();
          String newEmail = view.promtMemberEmail();
          int phoneNr = view.promptMemberPhone();
          Member newMember = data.getMemberRegistry().createMember(name, newEmail, phoneNr);
          if (newMember != null) {
            continueManagingMembers = view.displayMemberCreated(newMember);
          } else {
            continueManagingMembers = false;
            handleMemberManagement();
          }
          break;
        case DELETE_MEMBER:
          String deleteEmail = view.promtMemberEmail();
          data.getMemberRegistry().deleteMember(deleteEmail);
          view.displayDelete();
          break;
        case VIEW_MEMBER_INFORMATION:
          String email = view.promtMemberEmail();
          Member member = data.getMemberRegistry().searchMember(email);
          view.printMemberInfo(member);
          break;
        case CHANGE_MEMBER_INFORMATION:
          changeMemberInfo();
          break;
        case LIST_MEMBERS_SIMPLE:
          List<Member> members = data.getMemberRegistry().getMembers();
          view.displaySimpleList(members);
          break;
        case LIST_MEMBERS_VERBOSE:
          List<Member> membersVerbose = data.getMemberRegistry().getMembers();
          view.displayVerboseList(membersVerbose);
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
    while (true) {
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
          System.out.println("Invalid option selected. Please enter valid optoin!");
          view.displayMemberOptions(); // Re-display the member menu
      }

    }

  }

  private void changeMemberInfo() {
    ChangeMemberInfo option = displayChange();
    String changeEmail = view.promtMemberEmail();
    switch (option) {
      case NAME:
        String newName = view.promptChangeName();
        data.getMemberRegistry().updateMemberName(changeEmail, newName);
        break;
      case EMAIL:
        String newEmail = view.promtChangeEmail();
        data.getMemberRegistry().updateMemberEmail(changeEmail, newEmail);
        break;
      case PHONE:
        int newPhoneNr = view.promtChangePhone();
        data.getMemberRegistry().updateMemberPhoneNr(changeEmail, newPhoneNr);
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