package persistence;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import javafx.application.Application;
import javafx.stage.FileChooser;
import model.PortfolioEntry;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.misc.IOUtils;
import org.apache.commons.io.*;

import javax.annotation.processing.Filer;
import javax.sound.sampled.Port;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Reader  {

    public static JSONArray jsonArray;

    public List<PortfolioEntry> newread;


    //Modifies portfolio entry
    //Effects Reads json file and create a list of portfolio entries from that.
    public static void reader(File file, List<PortfolioEntry> p) throws IOException {

        Gson gson = new Gson();





        String str = FileUtils.readFileToString(file);

        jsonArray = new JSONArray(str);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject entry = jsonArray.getJSONObject(i);
            PortfolioEntry single;
            single = gson.fromJson(String.valueOf(entry), PortfolioEntry.class);
            p.add(single);

        }

    }


}
