package org.example.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConverter {

    static List<ProductWithEuroPrice> convertPriceToEuro(List<Product> productList, List<ExchangeRates> ratesList) {
        List<ProductWithEuroPrice> productsInEuro = new ArrayList<>();
        for (Product product : productList) {
            for (ExchangeRates exchangeRates : ratesList) {
                if (product.getCurrencyCode().equals(exchangeRates.getCode())) {
                    BigDecimal priceInEuro = product.getPrice().divide(exchangeRates
                            .getEuroRatesToAnotherCurrency(), 2, RoundingMode.HALF_UP);
                    productsInEuro.add(new ProductWithEuroPrice(product,priceInEuro));
                }
            }
        }
        return productsInEuro;
    }

    public static BigDecimal getSumAllProductsInEuro(List<Product> productList, List<ExchangeRates> ratesList) {
        BigDecimal sum = BigDecimal.ZERO;
        List<ProductWithEuroPrice> priceInEuro = convertPriceToEuro(productList, ratesList);
        for (ProductWithEuroPrice productWithEuroPrice : priceInEuro) {
            sum = sum.add(productWithEuroPrice.getPriceInEuro());
        }
        return sum;
    }

    public static BigDecimal getAveragePriceInEuro(List<Product> productList, List<ExchangeRates> ratesList) {
        BigDecimal sumInEuro = getSumAllProductsInEuro(productList, ratesList);
        return sumInEuro.divide(BigDecimal.valueOf(productList.size()), 2, RoundingMode.HALF_UP);
    }

    public static ProductWithEuroPrice getTheMostExpensiveProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        List<ProductWithEuroPrice> productsInEuro = convertPriceToEuro(products, exchangeRates);
        BigDecimal maxPrice = BigDecimal.ZERO;
        ProductWithEuroPrice theMostExpensiveProduct = null;
        for (ProductWithEuroPrice product : productsInEuro) {
            BigDecimal value = product.getPriceInEuro();
            if (value.compareTo(maxPrice) > 0) {
                maxPrice = value;
                theMostExpensiveProduct = product;
            }
        }
        return theMostExpensiveProduct;
    }

    public static ProductWithEuroPrice getTheCheapestProduct(List<Product> products, List<ExchangeRates> exchangeRates) {
        List<ProductWithEuroPrice> productsInEuro = convertPriceToEuro(products, exchangeRates);
        BigDecimal minPrice = null;
        ProductWithEuroPrice theCheapestProduct = null;
        for (ProductWithEuroPrice product : productsInEuro) {
            BigDecimal value = product.getPriceInEuro();
            if (minPrice == null || value.compareTo(minPrice) < 0) {
                minPrice = value;
                theCheapestProduct = product;
            }
        }
        return theCheapestProduct;
    }
}