package com.DemoSpring.Service;

import java.util.List;

import com.DemoSpring.DTO.CategoryDTO;

public interface CategoryService {
	void save(CategoryDTO dto);
	
	List<CategoryDTO> findAll();
	
	CategoryDTO getId(int id);
	
	void delete(int id);
}
