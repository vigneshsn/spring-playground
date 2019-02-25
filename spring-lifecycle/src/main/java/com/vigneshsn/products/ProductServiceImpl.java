package com.vigneshsn.products;

public class ProductServiceImpl implements ProductService{
    @Override
    public Product getProduct(String productId) {
        return new Product("1", "product from default vendor");
    }
}
