/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package y1s2_assignment;

import java.util.Scanner;

public class Test {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    AccountManager accountManager = new AccountManager();
    User loggedInUser = null;
    boolean login = false;
    boolean exit = false;

    while (!exit) {
        if (!login) {
            System.out.println("Welcome to TheFacebook!");
            System.out.println("==============================================\nMAIN MENU");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choiceStr = sc.nextLine();

            if (choiceStr.matches("\\d+")) {
                int choice = Integer.parseInt(choiceStr);

                switch (choice) {
                    case 1:
                        accountManager.UserRegister();
                        break;
                    case 2:
                        loggedInUser = accountManager.userLogin();
                        login = true;
                        break;
                    case 3:
                        exit = true;
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
            }
        } else {
            UserAccess userAccess = new UserAccess(loggedInUser);
            boolean backToMainMenu = false;

            while (!backToMainMenu) {
                System.out.println("==============================================\nUSER MENU");
                System.out.println("1. Edit Account");
                System.out.println("2. Display Account"); 
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                String choiceStr = sc.nextLine();

                if (choiceStr.matches("\\d+")) {
                    int choice = Integer.parseInt(choiceStr);

                    switch (choice) {
                        case 1:
                            userAccess.EditProfile();
                            break;
                        case 2:
                            userAccess.viewAccount(loggedInUser);
                            break;
                        case 3:
                            System.out.println("Log out successfully. Bye~\n");
                            loggedInUser = null; 
                            login = false;
                            backToMainMenu = true;
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }
                } else {
                    System.out.println("Invalid input! Please enter a number.");
                }
            }
        }
    }
}
}