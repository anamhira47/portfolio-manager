package model;

public class Coin {
    private String coinName;
    private int price;

    //Modifies this
    //Effects Creates a coin with x price
    public Coin(String coinName, int price) {
        this.coinName = coinName;
        this.price = price;
    }

    //Effects returns the coins name
    public String getCoinName() {
        return coinName;
    }

    //Effects return the price of the coin.
    public int getPrice() {
        return price;
    }

}
