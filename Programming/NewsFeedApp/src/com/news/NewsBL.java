package com.news;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewsBL {
	private static List<News> newsList = new ArrayList<>();

	public static void addNews(Scanner scanner) {
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

    public static void listNews() {
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
