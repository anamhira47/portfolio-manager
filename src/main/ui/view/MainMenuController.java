package ui.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Portfolio;
import persistence.Reader;
import ui.View;

import java.io.File;
import java.io.IOException;

public class MainMenuController extends Controller {

    public Button newPortfolio;
    public Button loadPortfolio;
    Portfolio portfolio = new Portfolio();

    public MainMenuController() throws IOException {
    }


    @FXML
    public void setNewPortfolioClick() throws IOException {
        String musicFile = "invest.mp3";

        //Media sound = new Media(new File(musicFile).toURI().toString());
        //MediaPlayer mediaPlayer = new MediaPlayer(sound);
        //mediaPlayer.play();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("view/portfolioGUI.fxml"));
        AnchorPane mainMenu = (AnchorPane) loader.load();
        PortfolioGuiController controller = loader.getController();
        controller.initData(portfolio);
        // Show the scene containing the root layout.
        Scene scene = new Scene(mainMenu);
        Stage window = (Stage) newPortfolio.getScene().getWindow();
        window.setScene(scene);


    }

    @FXML
    public void setLoadPortfolio() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("view/PortfolioGUI.fxml"));
        //AnchorPane mainMenu = (AnchorPane) loader.load();


        //Show the scene containing the root layout.
        //Scene scene = new Scene(mainMenu);
        Stage window = (Stage) loadPortfolio.getScene().getWindow();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Json Files", "*.json");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setSelectedExtensionFilter(extFilter);

        File file = fileChooser.showOpenDialog(window);
        if (file != null) {

            Reader.reader(file, portfolio.viewPortfolioArraylist());
            FXMLLoader loader1 = new FXMLLoader();

            loader1.setLocation(View.class.getResource("view/portfolioGUI.fxml"));
            PortfolioGuiController controller = loader1.getController();
            controller.initData(portfolio);
            AnchorPane mainMenu1 = (AnchorPane) loader1.load();

            Scene scene1 = new Scene(mainMenu1);


            Stage window1 = (Stage) loadPortfolio.getScene().getWindow();
            //Stage window2 = new Stage();
            window1.setScene(scene1);


        }

    }

    public Portfolio getPortfolio() {
        return portfolio;
    }


}
