package com.example.laba7.library;

public class Book {
    private int idBook;
    private String authorBook;
    private String nameBook;
    private double priceBook;
    private String isNewBook;

    public Book(int idBook, String authorBook, String nameBook, double priceBook, String isNewBook) {
        this.idBook = idBook;
        this.authorBook = authorBook;
        this.nameBook = nameBook;
        this.priceBook = priceBook;
        this.isNewBook = isNewBook;
    }

    public Book(String authorBook, String nameBook, double priceBook, String isNewBook) {
        this.authorBook = authorBook;
        this.nameBook = nameBook;
        this.priceBook = priceBook;
        this.isNewBook = isNewBook;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public double getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(double priceBook) {
        this.priceBook = priceBook;
    }

    public String getIsNewBook() {
        return isNewBook;
    }

    public void setIsNewBook(String isNewBook) {
        this.isNewBook = isNewBook;
    }
}
