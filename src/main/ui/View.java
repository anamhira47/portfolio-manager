package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Coin;
import model.Portfolio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class View extends Application {
    protected Coin btc = new Coin("Bitcoin");
    protected Coin eth = new Coin("Ethereum");
    protected Coin nano = new Coin("Nano");
    protected Coin xmr = new Coin("Monero");
    public Portfolio portfolio = new Portfolio();

    public View() throws IOException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Portfolio Management");
        mainMenu();


    }

    public void mainMenu() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(View.class.getResource("view/mainMenu.fxml"));
            AnchorPane mainMenu = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(mainMenu);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
