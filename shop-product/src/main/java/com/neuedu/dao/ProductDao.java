package com.neuedu.dao;

import com.neuedu.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<Product,Integer> {
}
