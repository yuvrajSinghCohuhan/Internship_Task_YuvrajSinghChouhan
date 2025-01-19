package com.news;

import java.util.Scanner;

public class SwitchCase {
	
	public void swCase() {
	Scanner scanner = new Scanner(System.in);
	NewsBL news = new NewsBL();
	int choice ;

    do {
        System.out.println("\n> Select your choice");
        System.out.println("1. Add news details");
        System.out.println("2. List news");
        System.out.println("3. Exit app");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                news.addNews(scanner);
                break;
            case 2:
                news.listNews();
                break;
            case 3:
                System.out.println("Exiting application. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 3);

    scanner.close();
}
}


