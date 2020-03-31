package ui.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Portfolio;
import persistence.Writer;
import ui.View;
import ui.view.MainMenuController;
import java.io.IOException;

public class PortfolioGuiController extends Controller {

    public Button viewTxHistory;
    public Button viewPortValue;
    public Button viewPortEntries;
    public Button saveToFile;
    public Button mainMenubutton;
    public TextField viewPrice;
    public Button addEntry;
    public TextField coinNameEntry;
    public TextField coinQTY;
    public TextArea portfolioValue;
    public TextArea coinPrice;
    public Button priceCoin;

    private Portfolio portfolio;
    Stage main;

    public void initData(Portfolio portfolio1) {
        portfolio = portfolio1;
    }

    public PortfolioGuiController() throws IOException {

    }

    @FXML
    public void addPortfolioEntry(ActionEvent event) {
        String coinName = coinNameEntry.getText().toLowerCase();
        int quantity = Integer.parseInt(coinQTY.getText());

        if (coinName.equals("btc") || coinName.equals("bitcoin")) {
            portfolio.addEntry(btc, quantity);
        } else if ((coinName.equals("eth") || coinName.equals("ethereum"))) {
            portfolio.addEntry(eth, quantity);
        } else if ((coinName.equals("nano") || coinName.equals("nano"))) {
            portfolio.addEntry(nano, quantity);
        } else if ((coinName.equals("xmr") || coinName.equals("monero"))) {
            portfolio.addEntry(xmr, quantity);
        }

    }

    @Override

    @FXML
    public void goBackMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("view/mainMenu.fxml"));
        AnchorPane mainMenu = (AnchorPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(mainMenu);
        Stage window = (Stage) mainMenubutton.getScene().getWindow();
        main = new Stage();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void saveToFile() throws IOException {
        Writer.write(portfolio.viewPortfolioArraylist());
    }

    @FXML
    public void viewPortfolioValue(ActionEvent event) {
        String value = "$ " + String.valueOf(portfolio.getPortfolioValue());
        portfolioValue.setText(value);
    }

    @FXML
    public void viewPriceofCoin(ActionEvent event) {
        String coinName = viewPrice.getText().toLowerCase();
        int price = 0;

        if (coinName.equals("btc") || coinName.equals("bitcoin")) {
            price = btc.getPrice();
        } else if ((coinName.equals("eth") || coinName.equals("ethereum"))) {
            price = eth.getPrice();
        } else if ((coinName.equals("nano") || coinName.equals("nano"))) {
            price = nano.getPrice();
        } else if ((coinName.equals("xmr") || coinName.equals("monero"))) {
            price = xmr.getPrice();
        }
        String value = String.valueOf(price);
        coinPrice.setText(value);

    }

    @FXML
    public void setViewTxHistory() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("view/viewTxHistory.fxml"));
        AnchorPane mainMenu = (AnchorPane) loader.load();
        ViewTxHistoryController controller = loader.getController();
        controller.initData(portfolio);
        // Show the scene containing the root layout.
        Scene scene = new Scene(mainMenu);
        Stage window = (Stage) viewTxHistory.getScene().getWindow();
        main = new Stage();
        window.setScene(scene);
        window.show();

    }

    @FXML
    public void setViewPortEntries() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("view/viewPortfolio.fxml"));
        AnchorPane mainMenu = (AnchorPane) loader.load();
        ViewPortfolioController controller = loader.getController();
        controller.initData(portfolio);
        // Show the scene containing the root layout.
        Scene scene = new Scene(mainMenu);
        Stage window = (Stage) viewPortEntries.getScene().getWindow();
        main = new Stage();
        window.setScene(scene);
        window.show();
    }

    //public Portfolio getLoadedPortfolio() {
    //    return loadedportfolio;
  //  }




}
