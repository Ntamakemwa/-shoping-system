# Shopping System

This project is a Java program that simulates a basic shopping store. It uses object oriented programming to manage users, products, and orders. I have organized the code into different files to keep everything clean and easy to follow.

## Project Structure

The project is built using several classes that work together. Each class has a specific job:

* User is the parent class that holds common information like names and emails.
* Buyer and Seller are child classes that inherit from the User class. I separated these so each role can have its own specific details.
* Product handles the items for sale, including their names, prices, and how many are in stock.
* Order manages the process of a customer buying a product and calculates the total price.
* Main is where the program starts. It creates different users and runs the shopping simulation.

## Programming Concepts Used

I used inheritance to connect the User class with the Buyer and Seller classes. This allows the child classes to use the code from the parent class without writing it again. I also used polymorphism so that the program can identify if a user is a buyer or a seller using the same method name.

## Error Handling

In the exceptional handling branch, I added a custom error called StockError. This part of the code checks if a product is available before an order is placed. If the item is out of stock, the program uses a try and catch block to handle the error. This keeps the program running smoothly instead of crashing when a mistake happens.

## How to Run

1. Open the project in your favorite editor like IntelliJ or VS Code.
2. Go to the Main class.
3. Run the main method to see the store in action. It will show the users, the items being bought, and any messages if an item is out of stock.
