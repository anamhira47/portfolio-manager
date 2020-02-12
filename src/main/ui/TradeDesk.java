package ui;

import model.Coin;
import model.Portfolio;
import model.PortfolioEntry;

import javax.sound.sampled.Port;
import java.sql.SQLOutput;
import java.util.Scanner;



public class TradeDesk {
    protected Coin btc = new Coin("Bitcoin", 10000);
    protected Coin eth = new Coin("Ethereum", 300);
    protected Coin nano = new Coin("Nano", 1);
    protected Coin xmr = new Coin("XMR", 92);
    private Scanner input2;
    private Scanner input3;
    private Scanner userInput;
    private Portfolio portfolio = new Portfolio();


    public TradeDesk() {
        runTradeDesk();
    }

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
        } else {
            System.out.println("Selection not valid");
        }

    }

    private void displayTradeDesk() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add an entry to Portfolio");
        System.out.println("\tr -> Remove entry from portfolio");
        System.out.println("\tt -> View transaction history");
        System.out.println("\ts -> View Portfolio Value");
        System.out.println("\tp -> View Coin prices");
        System.out.println("\tq -> quit");
    }


    private void removePortfolioEntry() {
    }

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

    private void viewTransactionHistory() {
        System.out.println(portfolio.transactionHistory());


    }

    private void viewPortfolioValue() {
        System.out.println(portfolio.getPortfolioValue());

    }

    private void viewCoinPrices() {
        input3 = new Scanner(System.in);

        System.out.println("What coin would you like to check the price of.");
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