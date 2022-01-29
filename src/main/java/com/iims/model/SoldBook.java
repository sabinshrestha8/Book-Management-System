package com.iims.model;

public class SoldBook {
    private int book_id, customer_id;

    public SoldBook() {
    }

    public SoldBook(int book_id, int customer_id) {
        this.book_id = book_id;
        this.customer_id = customer_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

}
