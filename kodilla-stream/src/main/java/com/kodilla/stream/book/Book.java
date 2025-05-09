package com.kodilla.stream.book;

public final class Book {
    private final String title;
    private final String author;
    private final int yearOfPublication;
    private final String signature;

    public Book(String title, String author, int yearOfPublication, String signature) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", signature='" + signature + '\'' +
                '}';
    }
}
