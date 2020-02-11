package model;

public class Coin {
    private String coinName;
    private int price;

    public Coin(String coinName, int price) {
        this.coinName = coinName;
        this.price = price;
    }

    public String getCoinName() {
        return coinName;
    }

    public int getPrice() {
        return price;
    }

}
