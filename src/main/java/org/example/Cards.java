package org.example;

public class Cards {
    private String cardName;
    private double balance;

    public Cards(String cardName) {
        this.cardName = cardName;
        this.balance = 0.0;
    }

    public Cards(String cardName, double balance) {
        this.cardName = cardName;
        this.balance = balance;
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
