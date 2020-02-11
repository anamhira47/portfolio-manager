package model;

public class PortfolioEntry {
    private int quantity;
    private Coin coin;

    public PortfolioEntry(Coin coin, int quantity) {
        this.coin = coin;
        this.quantity = quantity;

    }

    public int getQuantity() {
        return quantity;
    }

    public Coin getCoin() {
        return coin;
    }

    public void addQuantity(int purchase) {
        this.quantity += purchase;
    }

}
