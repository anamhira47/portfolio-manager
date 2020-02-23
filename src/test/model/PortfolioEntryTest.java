package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class PortfolioEntryTest {
    private Coin btc;
    private Coin eth;
    private Coin nano;
    private Coin xmr;
    private PortfolioEntry pe;
    private PortfolioEntry pe1;
    private PortfolioEntry pe2;
    private PortfolioEntry pe3;

    @BeforeEach
    public void runbefore() throws IOException {
        btc = new Coin("Bitcoin");
        eth = new Coin("Ethereum");
        nano = new Coin("Nano");
        xmr = new Coin("Monero");
        pe = new PortfolioEntry(xmr, 3);
        pe1 = new PortfolioEntry(btc, 15);
    }

    @Test
    public void getQuantityTest() {
        assertEquals(3, pe.getQuantity());

    }
    @Test
    public void getCoinTest() {
        String c = pe.getCoin().getCoinName();
        assertEquals("Monero", c );

    }

    @Test
    public void addQuantityTest() {
        pe.addQuantity(4);
        assertEquals(7, pe.getQuantity());
    }

}



