package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String name;
    private List<Cards> cards;
    private List<Double> cash;

    public Wallet(String name,List<Cards> cards, double[] cash) {
        this.name = name;
        this.cards = new ArrayList<>(cards);
        this.cash = new ArrayList<>();
        for (double i : cash){
            this.cash.add(i);
        }
    }

    public void deposit(String cardName, double amount) {
        Cards targetCard = null;
        for (Cards card : cards) {
            if (card.getCardName().equals(cardName)) {
                targetCard = card;
                break;
            } else {
                System.out.println("Tidak dapat menemukan kartu dengan nama " + cardName);
            }
        }
        if (amount % 50000.0 == 0 || amount % 100000.0 == 0) {
            if (targetCard != null) {
                if (cash.contains(100000.0)) {
                    double cashToTake = 0.0;
                    cash.remove(cashToTake);

                    double newBalance = targetCard.getBalance() + amount;
                    targetCard.setBalance(newBalance);
                } else if (countOfFifty() >= amount / 50000.0){
                    for (int i = 0; i < amount / 50000.0; i++) {
                        cash.remove(50000.0);
                    }
                    double newBalance = targetCard.getBalance() + amount;
                    targetCard.setBalance(newBalance);
                }
            }
        }
        else {
            System.out.println("Hanya bisa deposit dengan uang pecahan 50.000 atau 100.000");
        }
    }

    public void withdraw(String cardName, double amount) {
        Cards targetCard = null;
        for (Cards card : cards) {
            if (card.getCardName().equals(cardName)) {
                targetCard = card;
                break;
            }
        }
        if (targetCard != null) {
            if (amount % 50000.0 == 0) {
                for (int i = 0; i < amount / 50000.0; i++) {
                    cash.add(50000.0);
                }

                double newBalance = targetCard.getBalance() - amount;
                targetCard.setBalance(newBalance);
            } else {
                System.out.println("Tidak dapat melakukan withdraw. Jumlah harus kelipatan 50000.0.");
            }
        } else {
            System.out.println("Tidak dapat menemukan kartu dengan nama " + cardName);
        }
    }

    public void addCard(String cardName) {
        Cards newCard = new Cards(cardName, 0.0);
        cards.add(newCard);
    }
    public void addCard(String cardName, double balance) {
        Cards newCard = new Cards(cardName, balance);
        cards.add(newCard);
    }
    public void removeCard(String cardName) {
        Cards targetCard = null;
        for (Cards card : cards) {
            if (card.getCardName().equals(cardName)) {
                targetCard = card;
                break;
            }
        }
        if (targetCard != null) {
            cards.remove(targetCard);
        } else {
            System.out.println("Tidak dapat menemukan kartu dengan nama " + cardName);
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
        System.out.println("Total Uang di Dompet: " + getTotalCash());
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
    public double getTotalCash() {
        double totalCash = 0.0;
        for (double cashAmount : cash) {
            totalCash += cashAmount;
        }
        return totalCash;
    }
    public Cards getLastCard() {
        if (!cards.isEmpty()) {
            return cards.get(cards.size() - 1);
        } else {
            return null;
        }
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
