package com.mardeveloper.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mardeveloper.app.entities.Product;
import com.mardeveloper.app.repositories.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}
	
	public Product save(Product product) {
		return repository.save(product);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);	
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Product update(Long id, Product obj) {
		try {
			Product entity = repository.getById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private void updateData(Product entity, Product obj) {
		entity.setName(obj.getName());
		entity.setDescription(obj.getDescription());
		entity.setPrice(obj.getPrice());
		entity.setPhoto(obj.getPhoto());		
	}	
	
}
