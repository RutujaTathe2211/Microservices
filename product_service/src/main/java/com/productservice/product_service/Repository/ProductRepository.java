package com.microserviceproject2.product_service.Repository;

import com.microserviceproject2.product_service.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {



}
