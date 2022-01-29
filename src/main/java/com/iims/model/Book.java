package com.iims.model;

public class Book {
    private int id;
    private String name, author;
    private int stock;

    public Book(int id, String name, String author, int stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.stock = stock;
    }

    public Book() {
    }

    public Book(String name, String author, int stock) {
        this.name = name;
        this.author = author;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



}
