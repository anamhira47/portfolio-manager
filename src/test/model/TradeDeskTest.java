package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TradeDeskTest {
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
        nano = new Coin("NANO", 1);
        xmr = new Coin("XMR", 92);
        pe = new PortfolioEntry(xmr, 3);
        pe1 = new PortfolioEntry(btc, 4);
        pe2 = new PortfolioEntry(eth, 4);
        pe3 = new PortfolioEntry(nano, 5);
        p = new Portfolio();

    }

}
