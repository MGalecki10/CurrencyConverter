package org.example;

import java.math.BigDecimal;

public class ProductWithEuroPrice extends Product {
    private BigDecimal priceInEuro;

    public ProductWithEuroPrice(Product product, BigDecimal priceInEuro) {
        super(product.getName(),product.getPrice(), product.getCurrencyCode());
        this.priceInEuro = priceInEuro;
    }

    public BigDecimal getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(BigDecimal priceInEuro) {
        this.priceInEuro = priceInEuro;
    }
}
