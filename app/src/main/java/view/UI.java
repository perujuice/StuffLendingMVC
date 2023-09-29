package view;

import java.util.Scanner;

public class UI {
    private Scanner scanner;
    
    public UI() {
        scanner = new Scanner(System.in);
    }


    public void displayMenu() {
        System.out.println("Welcome to the Stuff Lending System! ");
            


        scanner.close();
    }
}
