package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet walletTest01 = new Wallet(
            "Owner01",
            (new Cards("card01", 2000000.0)),
            (new double[]{1000.0, 5000.0, 20000.0, 20000.0})
    );

    @Test
    public void test01 (){
        walletTest01.displayWalletInfo();
        walletTest01.deposit("card01", 150000.0);
        walletTest01.withdraw("card01",100000.0);
        walletTest01.addCard("card02");
        walletTest01.displayWalletInfo();
        walletTest01.removeCard("card02");
        walletTest01.displayWalletInfo();
    }
}