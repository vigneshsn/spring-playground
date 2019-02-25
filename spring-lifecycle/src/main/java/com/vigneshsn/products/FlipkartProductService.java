package com.vigneshsn.products;

public class FlipkartProductService implements ProductService{
    @Override
    public Product getProduct(String productId) {
        return new Product("2", "Product from flipkart");
    }
}
