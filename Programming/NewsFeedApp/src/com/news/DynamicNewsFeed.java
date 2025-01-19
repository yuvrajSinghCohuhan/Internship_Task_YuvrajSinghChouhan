package com.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class News {
    private String title;
    private String details;
    private String imagePath;

    public News(String title, String details, String imagePath) {
        this.title = title;
        this.details = details;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
               "Details: " + details + "\n" +
               "Image Path: " + imagePath + "\n";
    }
}

public class DynamicNewsFeed {
    private static List<News> newsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

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
                    addNews(scanner);
                    break;
                case 2:
                    listNews();
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

    private static void addNews(Scanner scanner) {
        System.out.print("Enter News Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter News Details: ");
        String details = scanner.nextLine();

        System.out.print("Enter Photo Path or URL: ");
        String imagePath = scanner.nextLine();

        News news = new News(title, details, imagePath);
        newsList.add(news);

        System.out.println("News added successfully!");
    }

    private static void listNews() {
        if (newsList.isEmpty()) {
            System.out.println("No news available.");
        } else {
            System.out.println("\nList of News:");
            for (int i = 0; i < newsList.size(); i++) {
                System.out.println("News " + (i + 1) + ":");
                System.out.println(newsList.get(i));
            }
        }
    }
}

