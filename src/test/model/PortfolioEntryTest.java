package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void runbefore() {
        btc = new Coin("Bitcoin", 10000);
        eth = new Coin("Ethereum", 300);
        nano = new Coin("Nano", 1);
        xmr = new Coin("XMR", 92);
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
        assertEquals("XMR", c );

    }

    @Test
    public void addQuantityTest() {
        pe.addQuantity(4);
        assertEquals(7, pe.getQuantity());
    }

}



