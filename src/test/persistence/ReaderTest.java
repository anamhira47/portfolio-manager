package persistence;

import com.google.gson.JsonArray;
import model.Coin;
import model.PortfolioEntry;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private Coin btc;
    private Coin eth;
    private Coin nano;
    private Coin xmr;
    private PortfolioEntry pe;
    private PortfolioEntry pe1;
    private PortfolioEntry pe2;
    private PortfolioEntry pe3;
    private List<PortfolioEntry> p1;
    private JSONArray reader;


        @BeforeEach
        public void runbefore() throws IOException {
            btc = new Coin("Bitcoin");
            eth = new Coin("Ethereum");
            nano = new Coin("Nano");
            xmr = new Coin("Monero");
            pe = new PortfolioEntry(xmr, 3);
            pe1 = new PortfolioEntry(btc, 15);
            p1 = new ArrayList<>();


        }

        @Test
        public void readerTest() {
           String reader = {"quantity":3, "coin":{"coinName":"Monero","price":74}},{"quantity":15,"coin":{"coinName":"Bitcoin","price":9149}};

        }


}
