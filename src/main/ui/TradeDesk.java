package ui;

import model.Coin;
import model.Portfolio;
import model.PortfolioEntry;
import persistence.Reader;
import persistence.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//Layout gotten from the Teller app project//
public class TradeDesk {
    protected Coin btc = new Coin("Bitcoin");
    protected Coin eth = new Coin("Ethereum");
    protected Coin nano = new Coin("Nano");
    protected Coin xmr = new Coin("Monero");
    private Scanner input2;
    private Scanner input3;
    private Scanner userInput;
    public Portfolio portfolio = new Portfolio();

    //Effects runs the TradeDesk

    public TradeDesk() throws IOException {
        runTradeDesk();
    }

    //Modifies This
    //Effects The tradedesk command line interface processes the input given.

    private void runTradeDesk() throws IOException {
        boolean dontStop = true;
        String command = null;
        userInput = new Scanner(System.in);
        while (dontStop) {
            displayTradeDesk();
            command = userInput.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                dontStop = false;
            } else {
                processCommand(command);
            }


        }
        System.out.println("\nRemember to invest responsibly");

    }
    //Removes c ode will implement later
    //        } else if (command.equals("r")) {
//
//            removePortfolioEntry();
//        }
    //Modifies this
    //Effects processes user command

    private void processCommand(String command) throws IOException {
        if (command.equals("a")) {
            addPortfolioEntry();
        } else if (command.equals("t")) {
            viewTransactionHistory();
        } else if (command.equals("s")) {
            viewPortfolioValue();
        } else if (command.equals("p")) {
            viewCoinPrices();
        } else if (command.equals("v")) {
            viewPortfolioString();

        } else if (command.equals("d")) {
            downloadPortfolio();
        } else if (command.equals("u")) {
            uploadPortfolio();
        } else {
            System.out.println("Selection not valid");
        }

    }

    private void uploadPortfolio() throws FileNotFoundException {
        Reader.reader(portfolio.viewPortfolioArraylist());

    }

    private void downloadPortfolio() throws IOException {
        Writer.write(portfolio.viewPortfolioArraylist());
    }
    //Effects displays the options to the user

    private void displayTradeDesk() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add an entry to Portfolio");
        //  System.out.println("\tr -> Remove entry from portfolio");
        System.out.println("\tt -> View transaction history");
        System.out.println("\ts -> View Portfolio Value");
        System.out.println("\tp -> View Coin prices");
        System.out.println("\tv -> View Portfolio");
        System.out.println("\td -> Download portfolio JSON file");
        System.out.println("\tn -> Download transaction history portfolio value.");
        System.out.println("\tu -> Upload portfolio to trade desk.");
        System.out.println("\tq -> quit");
    }

//
//    private void removePortfolioEntry() {
//        input3 = new Scanner(System.in);
//        System.out.println("What coin would you like to remove BTC/ETH/NANO/XMR");
//        String coinSelection = input3.nextLine().toUpperCase();
//        portfolio.removeEntry(coinSelection);
//
//
//    }
    //Modifies this
    //Effects adds a portfolio entry to the portfolio

    private void addPortfolioEntry() {
        input2 = new Scanner(System.in);
        System.out.println("What coin would you like to add BTC/ETH/NANO/XMR");
        String coinSelection = input2.nextLine().toLowerCase();

        PortfolioEntry pe;
        Coin coinchoise = null;
        if (coinSelection.equals("btc")) {
            coinchoise = btc;
        } else if (coinSelection.equals("eth")) {
            coinchoise = eth;
        } else if (coinSelection.equals("nano")) {
            coinchoise = nano;
        } else if (coinSelection.equals("xmr")) {
            coinchoise = xmr;
        } else {
            System.out.println("This coin has not been implemented yet");
        }
        System.out.println("What quantity would you like to add");
        int quantity = input2.nextInt();
        if (quantity >= 0.0) {
            portfolio.addEntry(coinchoise, quantity);
        } else {
            System.out.println("Cannot deposit negative amount...\n");
        }


    }
    //Effects displays the transaction history

    private void viewTransactionHistory() throws IOException {
        System.out.println(portfolio.transactionHistory());


    }

    //Effects shows the portfolio;

    private void viewPortfolioString() {
        System.out.println(portfolio.viewPortfolio());
    }
    //Effects Shows the total value of the portfolio

    private void viewPortfolioValue() {
        System.out.println(portfolio.getPortfolioValue());

    }
    //Effects Shows the coin prices of the individual coins

    private void viewCoinPrices() {
        input3 = new Scanner(System.in);

        System.out.println("What coin would you like to check the price of. BTC/ETH/NANO/XMR");
        String coinSelection = input3.nextLine().toLowerCase();
        PortfolioEntry pe;
        Coin coinchoice = btc;
        if (coinSelection.equals("btc")) {
            coinchoice = btc;
            System.out.println("The current price is " + coinchoice.getPrice());
        } else if (coinSelection.equals("eth")) {
            coinchoice = eth;
            System.out.println("The current price is " + coinchoice.getPrice());
        } else if (coinSelection.equals("nano")) {
            coinchoice = nano;
            System.out.println("The current price is " + coinchoice.getPrice());
        } else if (coinSelection.equals("xmr")) {
            coinchoice = xmr;
            System.out.println("The current price is " + coinchoice.getPrice());
        } else {
            System.out.println("This coin has not been imp"
                    + "lemented yet, check beck as we are continually adding more coins.");
        }

    }


}