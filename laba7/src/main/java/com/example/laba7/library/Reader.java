package com.example.laba7.library;

public class Reader {
    private int id;
    private String ticketNumber;
    private String phoneNumber;
    private String name;

    public Reader(int id, String ticketNumber, String phoneNumber, String name) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public Reader(String ticketNumber, String phoneNumber, String name) {
        this.ticketNumber = ticketNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
