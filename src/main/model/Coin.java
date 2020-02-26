package model;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class Coin {


    private String coinName;
    public int price;

    //Effects Reads a json and creates a string from that
    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //Effects creates JSON object from a given url
    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }




    //Modifies this
    //Effects Creates a coin with x price

    public Coin(String coinName) throws IOException, JSONException {


        this.coinName = coinName;
        String id = coinName.toLowerCase();
        JSONObject json = readJsonFromUrl("https://api.coingecko.com/api/v3/simple/price?ids=" + id + "&vs_currencies=usd");


        JSONObject coin = json.getJSONObject(id);
        price = coin.getInt("usd");



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
