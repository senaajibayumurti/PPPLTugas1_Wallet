package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet walletTest01 = new Wallet(
            "owner01",
            Arrays.asList(new Cards("card01", 2000000.0)),
            (new double[]{20000.0, 50000.0})
    );
    @Test
    public void testDataOwner(){
        assertEquals("owner01", walletTest01.getName());
        assertEquals("card01", walletTest01.getCards().get(0).getCardName());
        assertNotEquals(1000.0, walletTest01.getTotalCash());
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testCard(){
        walletTest01.addCard("card02");

        assertTrue(walletTest01.getLastCard().getCardName().contains("card02"));

        walletTest01.removeCard("card01");
        List<Cards> wallet01Cards = walletTest01.getCards();

        assertFalse(wallet01Cards.contains(new Cards("card01")));
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testDeposit(){
        assertEquals(70000.0, walletTest01.getTotalCash());

        walletTest01.deposit("card01",50000.0);
        List<Cards> wallet01Cards = walletTest01.getCards();

        assertEquals(2050000.0, wallet01Cards.get(0).getBalance());
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testWithdraw(){
        walletTest01.withdraw("card01", 50000.0);

        assertEquals(120000.0, walletTest01.getTotalCash());
        assertTrue(walletTest01.getCash().size() == 3);

        List<Cards> wallet01Cards = walletTest01.getCards();

        assertEquals(1950000.0, wallet01Cards.get(0).getBalance());
        walletTest01.displayWalletInfo();
    }
}