package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    static Wallet walletTest01;

    @BeforeEach
    void initEach() {
        walletTest01 = new Wallet(
                "owner01",
                Arrays.asList(new Cards("card01", 2000000.0)),
                new double[]{20000.0, 50000.0}
        );
        System.out.println("@BeforeEach dijalankan");
    }

    @AfterEach
    void cleanEach() {
        walletTest01 = null;

        System.out.println("@AfterEach dijalankan\n");
    }

    @Test
    public void testDataOwner() {
        System.out.println("testDataOwner dijalankan");
        assertEquals("owner01", walletTest01.getName());
        assertEquals("card01", walletTest01.getCards().get(0).getCardName());
        assertNotEquals(1000.0, walletTest01.getTotalCash());
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testCard() {
        System.out.println("testCard dijalankan");
        walletTest01.addCard("card02");

        assertTrue(walletTest01.getLastCard().getCardName().contains("card02"));

        walletTest01.removeCard("card01");
        List<Cards> wallet01Cards = walletTest01.getCards();

        assertFalse(wallet01Cards.contains(new Cards("card01")));
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testDeposit() {
        System.out.println("testDeposit dijalankan");
        assertEquals(70000.0, walletTest01.getTotalCash());

        List<Cards> wallet01Cards = walletTest01.getCards();
        walletTest01.deposit("card01", 50000.0);
        walletTest01.deposit("card01", 20000.0);
        assertEquals(2050000.0, wallet01Cards.get(0).getBalance());
        assertEquals(2050000.0, wallet01Cards.get(0).getBalance());
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testWithdraw() {
        System.out.println("testWithdraw dijalankan");

        List<Cards> wallet01Cards = walletTest01.getCards();
        walletTest01.withdraw("card01", 50000.0);
        assertEquals(120000.0, walletTest01.getTotalCash());

        walletTest01.withdraw("card01", 70000.0);
        assertEquals(120000.0, walletTest01.getTotalCash());

        walletTest01.withdraw("card01", 3000000.0);
        assertEquals(120000.0, walletTest01.getTotalCash());


        assertEquals(1950000.0, wallet01Cards.get(0).getBalance());
        assertTrue(walletTest01.getCash().size() == 3);
        walletTest01.displayWalletInfo();
    }

    @Test
    public void testRemoveCard() {
        System.out.println("testRemoveCard dijalankan");

        walletTest01.removeCard("card01");
        assertFalse(walletTest01.getCards().contains(new Cards("card01")));
        walletTest01.displayWalletInfo();
    }
}
