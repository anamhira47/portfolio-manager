package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PortfolioTest {
    private Coin btc;
    private Coin eth;
    private Coin nano;
    private Coin xmr;
    private PortfolioEntry pe;
    private PortfolioEntry pe1;
    private PortfolioEntry pe2;
    private PortfolioEntry pe3;
    private Portfolio p;

    @BeforeEach
    public void runbefore() {
          btc = new Coin("Bitcoin", 10000);
          eth = new Coin("Ethereum", 300);
          nano = new Coin("Nano", 1);
          xmr = new Coin("XMR", 92);
          pe = new PortfolioEntry(xmr, 3);
          pe1 = new PortfolioEntry(btc, 4);
          pe2 = new PortfolioEntry(eth, 4);
          pe3 = new PortfolioEntry(nano, 5);
          p = new Portfolio();

    }

    @Test
    public void testAddEntry() {
        p.addEntry(btc, 4);
        assertEquals(1, p.portfolioNumEntries());
        p.addEntry(btc,4);
        assertEquals(1,p.portfolioNumEntries());
        p.addEntry(eth, 5);
        assertEquals(2, p.portfolioNumEntries());


    }
    @Test
    public void testGetPortfolioValue() {
        p.addEntry(btc, 4);

        assertEquals(40000, p.getPortfolioValue());
        p.addEntry(btc,4);
        assertEquals(80000,p.getPortfolioValue());
        p.addEntry(eth, 5);
        assertEquals(81500, p.getPortfolioValue());
    }
    @Test
    public void testTransactionHistory() {
        p.addEntry(btc, 4);
        assertEquals("Bought 4 Bitcoin @ 10000\n", p.transactionHistory());
        p.addEntry(eth, 5);
        assertEquals("Bought 4 Bitcoin @ 10000\n" +
                "Bought 5 Ethereum @ 300\n", p.transactionHistory());
        p.addEntry(btc, 5);
        assertEquals("Bought 9 Bitcoin @ 10000\n" +
                "Bought 5 Ethereum @ 300\n" +
                "Bought 5 Bitcoin @ 10000\n", p.transactionHistory());

    }

    @Test
    public void testPortfolioNumEntries() {
        p.addEntry(btc, 5);
        assertEquals(1, p.portfolioNumEntries());
        p.addEntry(btc, 3);
        assertEquals(1, p.portfolioNumEntries());
        p.addEntry(eth, 4);
        assertEquals(2, p.portfolioNumEntries());
    }


}
