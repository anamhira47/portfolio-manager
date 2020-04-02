# Cryptoledge

# Keep track of your portfolio in an efficient and informative manner.

A very efficient way to keep track of all your cryptocurrency holdings, in one convenient place, check prices see change in prices
and if you are investing in a proper manner. You can also see a record of all your trades previously. Which can be very useful in for tax purposes.

Main Features of program:
- As a user I want to be able to Add Entries to my portfolio
- As a user I want to be able to view the View Transaction history of my portfolio
- As a user I want to be able View my Portfolio Value
- As a user I want to view the price of a specific coin.
- As a user I want to be able to view the entries in my portfolio
- As a user I want to be able to save my portfolio to file
- As a user I want to be able to save my transaction history to file.
- As a user I want to be able to view my portfolio again after closing the application.

# Instructions For Grader

- You can generate the first required event by running the program, clicking New Portfolio, which also has the audiovisual component as it will say "remember to invest responsible.
from there for the add X to Y requirement enter the name of a coin and a quantity of the coin the press the button that says "add entry".
- To view a list of the entries press the button that says "View" underneath the view portfolio entries tab, this will change the scene, from there press view again to see the list of portfolio entries.
- You can locate my visual component by going to the main menu, it is the image of the cryptocurrencies.
-You can save the state of my portfolio by pressing the button that says "save" underneath the text that says "save portfolio to file"
- You can reload the state of my the portfolio management, by going to the main menu, clicking the "load portfolio"
button and then choosing the previously saved portfolio file.

Here is a video showcasing all these features;

[![Portfolio Management System](https://res.cloudinary.com/marcomontalbano/image/upload/v1584835521/video_to_markdown/images/youtube--q33ZhZBbB_Y-c05b58ac6eb4c4700831b2b3070cd403.jpg)](https://www.youtube.com/watch?v=q33ZhZBbB_Y&feature=youtu.be "Portfolio Management System")




![alt text](https://assets-global.website-files.com/5bc662b786ecfc12c8d29e0b/5d07c76a696bfc4b3cb88294_cryptocurrency.jpg "Logo Title Text 1")

# Phase 4: Task 2
I chose to implement a type hierarchy, there are two type hierarchies within the project.
One of them is an Abstract Class "Controller"
This abstract class is used by the classes MainMenuController, PortfolioGuiCOntroller, ViewHistoryController, ViewTxHistoryController
The interface is ViewHistory and is implemented by the classes ViewPortfolio and ViewTxHistory

# Phase 4: Task 3

One example of poor cohesion within the code was the fact that the Portfolio class tracked the portfolio aswell as the transaction history
to fix this, I have created a seperate class "Transaction" that is utilized by the portfolio class to be more in line with the single responsibility principle.

Another problem within the code is the coupling of the controller class to the Coin class pertaining, to the selection of coins
that the program has. This was fixed with the previous task with the addition of the abstract class Controller. This makes it so the selection of coins would only need to be changed in the fields of the abstract class controller.



