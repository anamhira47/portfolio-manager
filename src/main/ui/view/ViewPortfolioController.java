package ui.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Portfolio;
import ui.View;

import java.io.IOException;

public class ViewPortfolioController extends Controller implements ViewHistory {
    public Button mainmenu;
    Stage main;
    public TextArea viewPortfolio;
    public Portfolio portfolio;
    public Button view;

    public ViewPortfolioController() throws IOException {

    }

    public void initData(Portfolio portfolio1) {
        portfolio = portfolio1;
    }
    //Effects goes back to main menu

    @FXML
    public void goBackMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("view/portfolioGUI.fxml"));
        AnchorPane mainMenu = (AnchorPane) loader.load();
        PortfolioGuiController controller = loader.getController();
        controller.initData(portfolio);
        // Show the scene containing the root layout.
        Scene scene = new Scene(mainMenu);
        Stage window = (Stage) mainmenu.getScene().getWindow();
        //Stagetage window = (Stage) .getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
    //Effects shows the portfolioentries on click

    @FXML
    public void viewHistory() {
        String portfolioentry = portfolio.viewPortfolio();
        viewPortfolio.setText(portfolioentry);
    }

}
