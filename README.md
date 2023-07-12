# Currency Converter
The Currency Converter is a Java application that converts prices of products from various currencies to Euro. It provides functionalities to calculate the sum of all products, the average price, and find the most expensive and cheapest products in Euro.

# Table of Contents

* **Prerequisites**
* **Installation**
* **Usage**

# Prerequisites
Before running the application, make sure you have the following:

* Java Development Kit (JDK) installed on your machine
* Access to the **'products.csv'** file containing the list of products with their prices and currencies
* Access to the **'currencies.csv'** file containing the exchange rates for different currencies to Euro

# Installation

1. Clone this repository to your local machine.
2. Place the products.csv and currencies.csv files in the src/main/resources directory.
3. Open a terminal and navigate to the project directory.
4. Compile the Java files using the following command:
   `javac -d bin -sourcepath src src/org/example/*.java`
5. Run the application using the following command:

shell
Copy code
java -cp bin org.example.Main

# Usage

The application provides the following functionalities:

1. Sum of all products in Euro: Calculates and displays the total sum of all products in Euro.
2. Average price in Euro: Calculates and displays the average price of all products in Euro.
3. Most expensive product: Finds and displays the name and price of the most expensive product in Euro.
4. Cheapest product: Finds and displays the name and price of the cheapest product in Euro.

Please make sure to place the **'products.csv'** and **'currencies.csv'** files in the appropriate directory before running the application.
