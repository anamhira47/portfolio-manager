package ui.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Portfolio;
import ui.View;

import java.awt.*;
import java.io.IOException;
//Class for showing transaction history

public class ViewTxHistoryController extends Controller implements ViewHistory {
    public Button mainmenu;
    Stage main;
    public TextArea txHistory;
    public Portfolio portfolio;
    public Button view;

    public ViewTxHistoryController() throws IOException {
    }
    //Modifies this
    //effects Intializeds portfolio

    public void initData(Portfolio portfolio1) {
        portfolio = portfolio1;
    }

    //Effects goesbacktomainmenu

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
        main = new Stage();
        window.setScene(scene);
        window.show();
    }
    //Effects shows transaction history on the display

    @FXML
    public void viewHistory() {
        String txhistorytext = portfolio.transactionHistory();
        txHistory.setText(txhistorytext);
    }

}
