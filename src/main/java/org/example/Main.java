package org.example;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String productsListName = "src/main/resources/products.csv";
        String currenciesListName = "src/main/resources/currencies.csv";

        try {
            List<Product> products = FileUtils.readProductsFromFile(productsListName);
            List<ExchangeRates> exchangeRates = FileUtils.readExchangeRatesFromFile(currenciesListName);
            showSumAllProducts(products, exchangeRates);
            showAveragePrice(products, exchangeRates);
            showMaxProduct(products, exchangeRates);
            showMinProduct(products, exchangeRates);
        } catch (FileNotFoundException e) {
            System.out.println("File does not found");
        }
    }

    private static void showSumAllProducts(List<Product> products, List<ExchangeRates> exchangeRates) {
        BigDecimal sumAllProducts = CurrencyConverter.getSumAllProductsInEuro(products, exchangeRates);
        System.out.println("Suma wszystkich produktów w EUR wynosi " + sumAllProducts);
    }

    private static void showAveragePrice(List<Product> products, List<ExchangeRates> exchangeRates) {
        BigDecimal averagePrice = CurrencyConverter.getAveragePriceInEuro(products, exchangeRates);
        System.out.println("Średnia cena za produkty w EUR wynosi " + averagePrice);
    }

    private static void showMaxProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        ProductWithEuroPrice theMostExpensiveProduct = CurrencyConverter
                .getTheMostExpensiveProduct(products, exchangeRates);
        System.out.println("Najdroższym produktem jest " + theMostExpensiveProduct.getName() +
                " o wartosci " + theMostExpensiveProduct.getPriceInEuro());
    }

    private static void showMinProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        ProductWithEuroPrice theCheapestProduct = CurrencyConverter
                .getTheCheapestProduct(products, exchangeRates);
        System.out.println("Najtańszym produktem jest " + theCheapestProduct.getName() +
                " o wartosci " + theCheapestProduct.getPriceInEuro());
    }
}