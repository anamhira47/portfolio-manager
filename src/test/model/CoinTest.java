package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoinTest {
    private Coin btc;
    private Coin eth;
    private Coin nano;
    private Coin xmr;

    @BeforeEach
    public void runbefore() {
        btc = new Coin("Bitcoin", 10000);
        eth = new Coin("Ethereum", 300);
        nano = new Coin("Nano", 1);
        xmr = new Coin("XMR", 92);
    }

    @Test
    public void getCoinNameTest() {
        assertEquals("Bitcoin", btc.getCoinName());

    }

    @Test
    public void getCoinPriceTest() {
        assertEquals(10000, btc.getPrice());
    }

}
