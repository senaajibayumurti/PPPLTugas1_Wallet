package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String name;
    private List<Cards> cards;
    private List<Double> cash;

    public Wallet(String name,Cards cards, double[] cash) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.cards.add(cards);
        this.cash = new ArrayList<>();
        for (double i : cash){
            this.cash.add(i);
        }
    }

    public void depositToCard(String cardName, double depositAmount) {
        Cards targetCard = null;
        for (Cards card : cards) {
            if (card.getCardName().equals(cardName)) {
                targetCard = card;
                break;
            } else {
                System.out.println("Tidak dapat menemukan kartu dengan nama " + cardName);
            }
        }
        if (depositAmount == 50000.0 || depositAmount == 100000.0) {
            if (targetCard != null) {
                if (cash.contains(100000.0)) {
                    double cashToTake = 0.0;
                    cash.remove(cashToTake);

                    double newBalance = targetCard.getBalance() + depositAmount;
                    targetCard.setBalance(newBalance);

                    System.out.println("Deposit berhasil. Saldo baru pada kartu " + cardName + ": " + newBalance);
                } else if (countOfFifty() >= depositAmount / 50000.0){
                    double newBalance = targetCard.getBalance() + depositAmount;
                    targetCard.setBalance(newBalance);

                    System.out.println("Deposit berhasil. Saldo baru pada kartu " + cardName + ": " + newBalance);
                }
            }
        }
        else {
            System.out.println("Hanya bisa deposit dengan uang pecahan 50.000 atau 100.000");
        }
    }

    public int countOfFifty(){
        int count = 0;
        for (double cash : cash){
            if (cash == 50000.0){
                count++;
            }
        }
        return count;
    }

    public void disableCard(String cardName) {
        for (Cards card : cards) {
            if (card.getCardName().equals(cardName)) {
                card.setActive(false);
                System.out.println("Kartu " + cardName + " dinonaktifkan.");
                return;
            }
        }
        System.out.println("Kartu dengan nama " + cardName + " tidak ditemukan.");
    }
    public void enableCard(String cardName) {
        for (Cards card : cards) {
            if (card.getCardName().equals(cardName)) {
                card.setActive(true);
                System.out.println("Kartu " + cardName + " diaktifkan.");
                return;
            }
        }
        System.out.println("Kartu dengan nama " + cardName + " tidak ditemukan.");
    }

    public void displayActiveCards() {
        System.out.println("Kartu-kartu aktif:");
        for (Cards card : cards) {
            if (card.isActive()) {
                System.out.println(" - " + card.getCardName() + ": " + card.getBalance());
            }
        }
    }
//    public void withdraw(double amount) {
//        if (cards.get())
//    }
    public void deposit(double amount) {
        if (totalCash() >= amount) {
            cash.remove(amount);
        } else {
            System.out.println("Saldo tidak mencukupi.");
        }
    }
    public void displayWalletInfo() {
        System.out.println("Info Dompet " + name);
        System.out.println("Kartu-kartu:");
        for (Cards card : cards) {
            System.out.println(" - " + card.getCardName() + ": " + card.getBalance());
        }
        System.out.println("Uang Rupiah:");
        for (double cashAmount : cash) {
            System.out.println(" - " + cashAmount);
        }
        System.out.println("Total Uang di Dompet: " + totalCash());
    }

    public double totalCash() {
        double totalCash = 0.0;
        for (double cashAmount : cash) {
            totalCash += cashAmount;
        }
        return totalCash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    public List<Double> getCash() {
        return cash;
    }

    public void setCash(List<Double> cash) {
        this.cash = cash;
    }
}
