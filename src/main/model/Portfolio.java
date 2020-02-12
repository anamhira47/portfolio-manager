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

    public int getPortfolioValue() {
        int val = 0;
        for (PortfolioEntry i : this.portfolio) {
            val += i.getCoin().getPrice() * i.getQuantity();
        }
        return val;

    }

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

    public int portfolioNumEntries() {

        return portfolio.size();
    }

   // public void removeEntry(String coin, int quantity) {

     //   for (PortfolioEntry i: this.portfolio) {
       //     Coin c = i.getCoin();
         //   if (c.getCoinName().equals(coin)) {

           // }

}












