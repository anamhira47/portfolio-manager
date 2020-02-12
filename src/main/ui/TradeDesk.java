package ui;

import model.Coin;
import model.Portfolio;
import model.PortfolioEntry;

import javax.sound.sampled.Port;
import java.sql.SQLOutput;
import java.util.Scanner;


//Layout gotten from the Teller app project//
public class TradeDesk {
    protected Coin btc = new Coin("BTC", 10000);
    protected Coin eth = new Coin("ETH", 300);
    protected Coin nano = new Coin("NANO", 1);
    protected Coin xmr = new Coin("XMR", 92);
    private Scanner input2;
    private Scanner input3;
    private Scanner userInput;
    private Portfolio portfolio = new Portfolio();

    //Effects runs the TradeDesk

    public TradeDesk() {
        runTradeDesk();
    }

    //Modifies This
    //Effects The tradedesk command line interface processes the input given.

    private void runTradeDesk() {
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

    //Modifies this
    //Effects processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addPortfolioEntry();
        } else if (command.equals("r")) {

            removePortfolioEntry();
        } else if (command.equals("t")) {
            viewTransactionHistory();
        } else if (command.equals("s")) {
            viewPortfolioValue();
        } else if (command.equals("p")) {
            viewCoinPrices();
        } else if (command.equals("v"))  {
            viewPortfolioString();
        } else {
            System.out.println("Selection not valid");
        }

    }
    //Effects displays the options to the user

    private void displayTradeDesk() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add an entry to Portfolio");
        System.out.println("\tr -> Remove entry from portfolio");
        System.out.println("\tt -> View transaction history");
        System.out.println("\ts -> View Portfolio Value");
        System.out.println("\tp -> View Coin prices");
        System.out.println("\tv -> View Portfolio");
        System.out.println("\tq -> quit");
    }


    private void removePortfolioEntry() {
        input3 = new Scanner(System.in);
        System.out.println("What coin would you like to remove BTC/ETH/NANO/XMR");
        String coinSelection = input3.nextLine().toUpperCase();
        portfolio.removeEntry(coinSelection);


    }
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

    private void viewTransactionHistory() {
        System.out.println(portfolio.transactionHistory());


    }

    //Effects shows the portfolio;

    private void viewPortfolioString() {
        System.out.println(portfolio.viewPortfolio());
    }
    //Shows the total value of the portfolio

    private void viewPortfolioValue() {
        System.out.println(portfolio.getPortfolioValue());

    }
    //Shows the coin prices of the individual coins

    private void viewCoinPrices() {
        input3 = new Scanner(System.in);

        System.out.println("What coin would you like to check the price of. BTC/ETH/NANO/XMR");
        String coinSelection = input3.nextLine().toLowerCase();
        PortfolioEntry pe;
        Coin coinchoise = btc;
        if (coinSelection.equals("btc")) {
            coinchoise = btc;
            System.out.println("The current price is " + coinchoise.getPrice());
        } else if (coinSelection.equals("eth")) {
            coinchoise = eth;
            System.out.println("The current price is " + coinchoise.getPrice());
        } else if (coinSelection.equals("nano")) {
            coinchoise = nano;
            System.out.println("The current price is " + coinchoise.getPrice());
        } else if (coinSelection.equals("xmr")) {
            coinchoise = xmr;
            System.out.println("The current price is " + coinchoise.getPrice());
        } else {
            System.out.println("This coin has not been imp"
                    + "lemented yet, check beck as we are continually adding more coins.");
        }

    }









}