package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xpath.internal.objects.XString;
import model.Portfolio;
import model.PortfolioEntry;

import javax.sound.sampled.Port;
import java.io.*;
import java.util.List;


public class Writer {

    //Effects writes a json file of a list of portfolio entries.
    public static void write(List<PortfolioEntry> p) throws IOException {
        FileWriter fileWriter = new FileWriter("data/portfolio.json");

        GsonBuilder builder = new GsonBuilder();

        Gson gson = new Gson();
        gson.toJson(p, fileWriter);
        fileWriter.close();
        System.out.println("Your file has been downloaded");


    }

}


