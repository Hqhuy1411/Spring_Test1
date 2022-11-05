package com.DemoSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DemoSpring.Entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

}
