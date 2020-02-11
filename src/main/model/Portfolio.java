package model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<PortfolioEntry> portfolio;
    private List<PortfolioEntry> history;
    private List<Coin> coinsAdded;

    public Portfolio() {
        portfolio = new ArrayList<>();
        history = new ArrayList<>();
        coinsAdded = new ArrayList<>();


    }

    public void addEntry(Coin coin, int quantity) {
        if (coinsAdded.contains(coin)) {
            for (PortfolioEntry i : this.portfolio) {
                if (i.getCoin() == coin) {
                    PortfolioEntry he;
                    he = new PortfolioEntry(coin, quantity);
                    i.addQuantity(quantity);
                    history.add(he);
                }
            }
        } else {
            PortfolioEntry pe;
            pe = new PortfolioEntry(coin, quantity);

            portfolio.add(pe);
            coinsAdded.add(coin);
            history.add(pe);

        }


    }
}



