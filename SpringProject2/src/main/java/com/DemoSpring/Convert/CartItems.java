package com.DemoSpring.Convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DemoSpring.DTO.CategoryDTO;
import com.DemoSpring.Entity.CategoryEntity;

@Component
public class CartItems {
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		return dto;
	}

	public List<CategoryDTO> toListdto(List<CategoryEntity> list){
		List<CategoryDTO> listdto = new ArrayList<CategoryDTO>();
		for(CategoryEntity entity : list) {
			listdto.add(toDTO(entity));
		}
		return listdto;
	}
}
