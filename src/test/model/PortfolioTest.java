package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    public void runbefore() throws IOException {
          btc = new Coin("Bitcoin");
          eth = new Coin("Ethereum");
          nano = new Coin("Nano");
          xmr = new Coin("Monero");
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

        assertEquals(4*btc.getPrice(), p.getPortfolioValue());
        p.addEntry(btc,4);
        assertEquals(8*btc.getPrice(),p.getPortfolioValue());
        p.addEntry(eth, 5);
        assertEquals(8*btc.getPrice()+5*eth.getPrice(), p.getPortfolioValue());
    }
    @Test
    public void testTransactionHistory() {
        p.addEntry(btc, 4);
        assertEquals("Bought 4 Bitcoin @ " + btc.getPrice() + "\n", p.transactionHistory());
        p.addEntry(eth, 5);
        assertEquals("Bought 4 Bitcoin @ " + btc.getPrice() + "\n" +
                "Bought 5 Ethereum @ " + eth.getPrice() + "\n", p.transactionHistory());
        p.addEntry(btc, 5);
        assertEquals("Bought 9 Bitcoin @ " + btc.getPrice() + "\n" +
                "Bought 5 Ethereum @ " + eth.getPrice() + "\n" +
                "Bought 5 Bitcoin @ " + btc.getPrice() + "\n", p.transactionHistory());

    }
    @Test
    public void viewPortfolioTest() {
        p.addEntry(btc, 4);
        assertEquals("Quantity: 4 Coin: Bitcoin @ " + btc.getPrice() + "\n", p.viewPortfolio());
        p.addEntry(eth, 5);
        assertEquals("Quantity: 4 Coin: Bitcoin @ " + btc.getPrice() + "\n" +
                "Quantity: 5 Coin: Ethereum @ " + eth.getPrice() + "\n", p.viewPortfolio());
        p.addEntry(btc, 5);
        assertEquals("Quantity: 9 Coin: Bitcoin @ " + btc.getPrice() + "\n" +
                "Quantity: 5 Coin: Ethereum @ " + eth.getPrice() + "\n", p.viewPortfolio());
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

//    @Test
//    public void removePortfolioTest() {
//        p.addEntry(btc, 5);
//        assertEquals(1, p.portfolioNumEntries());
//        p.removeEntry("Bitcoin");
//        assertEquals(0, p.portfolioNumEntries());
//        p.addEntry(eth, 4);
//        p.addEntry(btc, 4);
//        p.removeEntry("Ethereum");
//        assertEquals(0, p.portfolioNumEntries());
//    }

}
