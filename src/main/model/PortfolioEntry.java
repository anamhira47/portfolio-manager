package model;

public class PortfolioEntry {
    private int quantity;
    private Coin coin;

    //Modifies This
    //Effects Creates a portfolio entry with a Coin and a quantity
    public PortfolioEntry(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;

    }

    //Effects returns quantity
    public int getQuantity() {
        return quantity;
    }

    //Effects returns coin
    public Coin getCoin() {
        return coin;
    }

    //Modifies this
    //Effects Adds quantity to portfolio entry
    public void addQuantity(int purchase) {
        this.quantity += purchase;
    }

}
