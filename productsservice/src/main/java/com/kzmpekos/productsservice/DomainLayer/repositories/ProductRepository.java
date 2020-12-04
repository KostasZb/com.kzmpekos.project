package com.kzmpekos.productsservice.DomainLayer.repositories;

import com.kzmpekos.productsservice.DomainLayer.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findAllByFarmerId(int id);
    public Product findByProductId(int id);
}
