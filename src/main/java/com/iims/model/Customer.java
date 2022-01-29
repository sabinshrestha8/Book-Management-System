package com.iims.model;

public class Customer {
    private int id;
    private long contact;
    private String name;

    public Customer(long contact, String name) {
        this.contact = contact;
        this.name = name;
    }

    public Customer() {
    }

    public Customer(int id, long contact, String name) {
        this.id = id;
        this.contact = contact;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
