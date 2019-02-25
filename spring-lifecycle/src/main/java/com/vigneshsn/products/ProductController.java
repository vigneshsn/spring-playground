package com.vigneshsn.products;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
public class ProductController implements ApplicationContextAware{


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{productId}")
    public Product getProducts(@PathVariable String productId) {
        return productService.getProduct(productId);
    }

    /**
     * JSR 250 - we can use this @PostConstruct and @PreDestroy for accessing life cycle methods
     * instead of implementing InitializindBean and DisposableBean Interface.
     * Spring team wouldn't recommend to use these interfaces, since they couple our
     * code tightly with spring framework.
     * @throws Exception
     */
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called");
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("destroy called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("applicationContext.getBeanDefinitionCount() " + applicationContext.getBeanDefinitionCount());
//        System.out.println("applicationContext.getParent() " + applicationContext.getParent());
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        Arrays.stream(beanNames).forEach(System.out::println);
    }
}
