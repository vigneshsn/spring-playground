package com.vigneshsn.products;

public class ProductServiceFactory {

    public static ProductService getProductService(String type) {
        if(type.equals("flipkart")) {
            return new FlipkartProductService();
        }
        return new ProductServiceImpl();
    }
}
