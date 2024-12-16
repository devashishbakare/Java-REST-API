package com.todo.todoApp.Entity;
public class Book {
    private int bookId;
    private String title;
    private String description;
    private double price;

    public Book(int bookId, String title, String description, double price) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
