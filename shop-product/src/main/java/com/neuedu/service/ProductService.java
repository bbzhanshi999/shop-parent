package com.neuedu.service;

import com.neuedu.bean.Product;
import com.neuedu.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product findByPid(Integer id){
        return productDao.findById(id).orElse(null);
    }
}
