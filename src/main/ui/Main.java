package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Coin;
import model.Portfolio;

import java.io.IOException;


public class Main extends Application {


    private Stage primaryStage;

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

    //Effects starts the GUI

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Portfolio Management");
        mainMenu();


    }
    //Effects sets the stage

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
