package com.news;

public class News {
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
