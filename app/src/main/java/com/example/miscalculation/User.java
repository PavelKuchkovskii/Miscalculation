package com.example.miscalculation;


public class User {

    private boolean manager;
    private double CALCPERC;
    private String email;
    private int delivery;
    private double MINPRICE;

    public User(boolean manager, double CALCPERC, String email, int delivery, double MINPRICE) {
        this.manager = manager;
        this.CALCPERC = CALCPERC;
        this.email = email;
        this.delivery = delivery;
        this.MINPRICE = MINPRICE;
    }

    public boolean isManager() {
        return manager;
    }

    public double getCALCPERC() {
        return CALCPERC;
    }

    public String getEmail() {
        return email;
    }

    public int getDelivery() {
        return delivery;
    }

    public double getMINPRICE() {
        return MINPRICE;
    }
}
