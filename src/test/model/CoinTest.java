package model;


import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CoinTest {
    private Coin btc;
    private Coin eth;
    private Coin nano;
    private Coin xmr;

    @BeforeEach
    public void runbefore() throws IOException, JSONException {
        btc = new Coin("Bitcoin");
        eth = new Coin("Ethereum");
        nano = new Coin("Nano");
        xmr = new Coin("Monero");
    }

    @Test
    public void getCoinNameTest() {
        assertEquals("Bitcoin", btc.getCoinName());

    }

    @Test
    public void getCoinPriceTest() {
        assertEquals(btc.getPrice(), btc.getPrice());
    }



}

