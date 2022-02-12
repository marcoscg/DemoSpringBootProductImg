package com.mardeveloper.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mardeveloper.app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
