package com.DemoSpring.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DemoSpring.Convert.ForProduct;
import com.DemoSpring.DTO.ProductDTO;
import com.DemoSpring.Entity.ProductEntity;
import com.DemoSpring.Repository.ProductRepository;
import com.DemoSpring.Service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ForProduct forProduct;
	
	
	@Override
	public void save(ProductDTO dto) {
		// TODO Auto-generated method stub
		ProductEntity  entity = forProduct.toEntity(dto);
		productRepository.save(entity);
	}


	@Override
	public List<ProductDTO> findAll() {
		// TODO Auto-generated method stub
		List<ProductEntity> entities = productRepository.findAll();
		
		return forProduct.toListdto(entities);
		}


	@Override
	public ProductDTO getId(int id) {
		// TODO Auto-generated method stub
		ProductEntity entity = productRepository.findById(id).get();
		
		return forProduct.toDTO(entity);
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		ProductEntity entity = productRepository.findById(id).get();
		productRepository.delete(entity);
	}

}
