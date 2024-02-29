package org.example;

import org.junit.jupiter.api.Test;

class WalletTest {
    Wallet walletTest01 = new Wallet(
            "Owner01", (new Cards("card01", 2000000.0)),(new double[]{1000.0, 5000.0, 20000.0, 20000.0})
    );
    Wallet walletTest02 = new Wallet(
            "Owner02", (new Cards("card01", 2100000.0)),(new double[]{1000.0, 20000.0, 50000.0})
    );


    @Test
    public void test01 (){
        walletTest01.depositToCard("card02", 100000.0);
    }

    @Test
    public void test02 (){
        walletTest02.depositToCard("card01", 90000.0);
        walletTest02.displayActiveCards();
        walletTest02.displayWalletInfo();
    }

    @Test
    public void test03(){
        System.out.println(walletTest01.countOfFifty());
        System.out.println(walletTest02.countOfFifty());
    }
}