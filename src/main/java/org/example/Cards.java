package org.example;

public class Cards {
    private String cardName;
    private double balance;
    private boolean active;

    public Cards(String cardName) {
        this.cardName = cardName;
        this.active = true;
    }

    public Cards(String cardName, double balance) {
        this.cardName = cardName;
        this.balance = balance;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
