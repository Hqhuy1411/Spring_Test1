package com.DemoSpring.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DemoSpring.Convert.ForCategory;
import com.DemoSpring.DTO.CategoryDTO;
import com.DemoSpring.Entity.CategoryEntity;
import com.DemoSpring.Repository.CategoryRepository;
import com.DemoSpring.Service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ForCategory forCategory;
	
	@Override
	public void save(CategoryDTO dto) {
		// TODO Auto-generated method stub
		categoryRepository.save(forCategory.toEntity(dto));
		
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> list = categoryRepository.findAll();
		
		return forCategory.toListdto(list);
	}

	@Override
	public CategoryDTO getId(int id) {
		CategoryEntity entity = categoryRepository.findById(id).get();
		return forCategory.toDTO(entity);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		CategoryEntity entity = categoryRepository.findById(id).get();
		categoryRepository.delete(entity);
	}
	
}
