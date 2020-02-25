package persistence;


import com.google.gson.Gson;
import model.PortfolioEntry;

import javax.sound.sampled.Port;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;


public class Reader {

    public List<PortfolioEntry> newread;



    public static void reader(List<PortfolioEntry> p) throws FileNotFoundException {

        Gson gson = new Gson();


        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JSON File", "json");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());

        }
        FileReader fileReader = new FileReader(chooser.getSelectedFile());
        List<PortfolioEntry> newread = (gson.fromJson(fileReader, PortfolioEntry.class));
        p = newread;
    }


}
