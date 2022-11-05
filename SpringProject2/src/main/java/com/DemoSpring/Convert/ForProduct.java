package com.DemoSpring.Convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DemoSpring.DTO.ProductDTO;
import com.DemoSpring.Entity.CategoryEntity;
import com.DemoSpring.Entity.ProductEntity;
import com.DemoSpring.Repository.CategoryRepository;

@Component
public class ForProduct {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	public ProductDTO toDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		dto.setImageUrl(entity.getImageUrl());
		dto.setCategoryName(entity.getCategory().getName());
		return dto;
	}
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		CategoryEntity categoryEntity = categoryRepository.findOneByName(dto.getCategoryName());
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setImageUrl(dto.getImageUrl());
		entity.setPrice(dto.getPrice());
		entity.setCategory(categoryEntity);
		return entity;
	}
	public List<ProductDTO> toListdto(List<ProductEntity> list){
		List<ProductDTO> listdto = new ArrayList<ProductDTO>();
		for(ProductEntity entity : list) {
			listdto.add(toDTO(entity));
		}
		return listdto;
	}
}
