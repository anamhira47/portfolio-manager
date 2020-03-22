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

public class ViewTxHistoryController extends Controller {
    public Button mainmenu;
    Stage main;
    public TextArea txHistory;
    public Portfolio portfolio;
    public Button view;

    public ViewTxHistoryController() throws IOException {
    }

    public void initData(Portfolio portfolio1) {
        portfolio = portfolio1;
    }

    @FXML
    public void gobackPortfolio() throws IOException {
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

    @FXML
    public void viewTxHistory() {
        String txhistorytext = portfolio.transactionHistory();
        txHistory.setText(txhistorytext);
    }

}
