package com.neuedu.sys;

import com.neuedu.api.ProductService;
import com.neuedu.bean.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceFallBackFactory implements
        FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable throwable) {
        return pid -> {
            throwable.printStackTrace();
            Product product = new Product();
            product.setPid(-1);
            return product;
        };
    }
}
