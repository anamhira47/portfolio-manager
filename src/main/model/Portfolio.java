package model;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
//Basic structure from the ASSIGN2 grocerybill

public class Portfolio {
    private List<PortfolioEntry> portfolio;
    private List<PortfolioEntry> history;
    private List<Coin> coinsAdded;
    private List<PortfolioEntry> removed;

    public Portfolio() {
        portfolio = new ArrayList<>();
        history = new ArrayList<>();
        coinsAdded = new ArrayList<>();
        removed = new ArrayList<>();


    }

    //Modifies this
    //Effects adds an entry to portfolio array

    public void addEntry(Coin coin, int quantity) {
        if (coinsAdded.contains(coin)) {
            for (PortfolioEntry i : this.portfolio) {
                if (i.getCoin() == coin) {
                    PortfolioEntry he;
                    PortfolioEntry th;
                    th = new PortfolioEntry(coin, quantity);
                    he = new PortfolioEntry(coin, quantity);
                    i.addQuantity(quantity);
                    history.add(th);
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

    //Modifies this
    //Effects returns portfolio value
    public int getPortfolioValue() {
        int val = 0;
        for (PortfolioEntry i : this.portfolio) {
            val += i.getCoin().getPrice() * i.getQuantity();
        }
        return val;

    }

    //Effects Return transaction history
    public String transactionHistory() {
        String output = "";
        for (PortfolioEntry i: this.history) {
            Coin c = i.getCoin();
            int price = c.getPrice();
            int quantity = i.getQuantity();
            String name = c.getCoinName();
            output += "Bought " + quantity + " " + name + " @ " + price + "\n";

        }
        return output;
    }
    //Effects Return transaction history

    public String viewPortfolio() {
        String output = "";
        for (PortfolioEntry i: this.portfolio) {
            Coin c = i.getCoin();
            int price = c.getPrice();
            int quantity = i.getQuantity();
            String name = c.getCoinName();
            output += "Quantity: " + quantity + " Coin: " + name + " @ " + price + "\n";

        }
        return output;
    }

    //Effects returns number of entries in the portfolio

    public int portfolioNumEntries() {

        return portfolio.size();
    }
    //Modifies this
    //Effects removes an entry from the portfolio

    public void removeEntry(String coin) {

        for (PortfolioEntry i : this.portfolio) {
            Coin c = i.getCoin();
            if (c.getCoinName().equals(coin)) {
                removed.add(i);
                portfolio.remove(i);

            }


        }
    }

}












