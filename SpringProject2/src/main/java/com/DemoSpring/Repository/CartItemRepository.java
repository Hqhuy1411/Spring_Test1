package com.DemoSpring.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.DemoSpring.Entity.CartItemEntity;
import com.DemoSpring.Entity.ProductEntity;

public interface CartItemRepository extends JpaRepository<CartItemEntity, Integer>{
	@Query("SELECT a.productEntity from CartItemEntity a where a.user.id=?1 ")
	List<ProductEntity> getProducts(int id);
	
	@Query("SELECT a.quantily from CartItemEntity a where a.user.id=?1 ")
	List<Integer> getQuantilys(int id);
	
	@Query("SELECT a from CartItemEntity a where a.user.id=?1 ")
	List<CartItemEntity> getCartItems(int id);
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM CartItemEntity a WHERE a.user.id=?1 and a.productEntity.id=?2")
	void deletebyUserandProduct(int user, int product);
}
