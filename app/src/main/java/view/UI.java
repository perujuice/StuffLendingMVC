package view;

import controller.MemberController;
import model.Member;
import java.util.Scanner;

public class UI {
    private Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the Stuff Lending System!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Member Management");
            System.out.println("2. Item Management");
            System.out.println("3. Contract Management");
            System.out.println("4. Advance Time");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    // Member Management
                    System.out.println("Creating a new member...\n");

                    System.out.print("Enter the member's name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the member's email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter the member's phone number: ");
                    int phoneNr = scanner.nextInt();

                    // creat instance create a new member
                    MemberController memberController = new MemberController();

                    Member newMember = memberController.createMember(name, email, phoneNr);

                    // Print a confirmatiom message
                    System.out.println("New member created with Member ID: " + newMember.getMemberId());
                    break;

                case 2:
                    // Call a method to handle Item Management
                    handleItemManagement();
                    break;

                case 3:
                    // Call a method to handle Contract Management
                    handleContractManagement();
                    break;

                case 4:
                    // Call a method to handle advancing time
                    advanceTime();
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close(); // Close the scanner before exiting
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice. Please enter a valid option.");
            }
        }
    }

    private int getIntInput() {
        int input = -1;
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Invalid input; do nothing, the loop will prompt again.
        }
        return input;
    }

    // methods to handle different functionalities
    private void handleMemberManagement() {
        System.out.println("Member Management:");
        // member management logic
    }

    private void handleItemManagement() {
        System.out.println("Item Management:");
        // item management logic
    }

    private void handleContractManagement() {
        System.out.println("Contract Management:");
        // contract management logic
    }

    private void advanceTime() {
        System.out.println("Advancing Time:");
        // time advancement logic
    }

    public static void main(String[] args) {
        UI mainMenu = new UI();
        mainMenu.displayMenu();
    }
}
