package com.kzmpekos.productsservice;

import com.kzmpekos.productsservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findAllByFarmerId(int id);
    public Product findByProductId(int id);
}
