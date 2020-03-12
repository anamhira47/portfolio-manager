package ui.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Coin;
import model.Portfolio;
import javafx.fxml.FXML;

import javax.sound.sampled.Port;
import java.io.IOException;

public abstract class Controller  {

    protected Coin btc = new Coin("Bitcoin");
    protected Coin eth = new Coin("Ethereum");
    protected Coin nano = new Coin("Nano");
    protected Coin xmr = new Coin("Monero");


    public Controller() throws IOException {
    }
}
