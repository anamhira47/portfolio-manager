package model;

import java.util.ArrayList;
import java.util.List;
//Keeps track of all transactions

public class Transaction {
    public List<PortfolioEntry> history;

    public Transaction() {
        history = new ArrayList<>();

    }

    //Effects returns the transaction history
    public String transactionHistory() {
        String output = "";
        for (PortfolioEntry i : this.history) {
            Coin c = i.getCoin();
            int price = c.getPrice();
            int quantity = i.getQuantity();
            String name = c.getCoinName();
            output += "Bought " + quantity + " " + name + " @ " + price + "\n";

        }
        return output;
    }

    //Modifies this
    //Effects a transaction to the txhistory
    public void addHistory(Coin c, int q) {
        PortfolioEntry temp = new PortfolioEntry(c,q);

        history.add(temp);


    }


}
