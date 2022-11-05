package com.DemoSpring.Service;

import java.util.List;

import com.DemoSpring.DTO.ProductDTO;

public interface ProductService {
	void save(ProductDTO dto);
	
	List<ProductDTO> findAll();
	
	ProductDTO getId(int id);
	
	void delete(int id);
}
