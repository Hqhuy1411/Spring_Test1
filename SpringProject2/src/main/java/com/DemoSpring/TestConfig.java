package com.DemoSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.DemoSpring.Repository.CartItemRepository;
import com.DemoSpring.Repository.ProductRepository;
import com.DemoSpring.Repository.UserRepository;

@RestController
public class TestConfig {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	
	
	
	
//	@GetMapping("/test")
//	public String test() {
//		User user = new User();
//		user.setUsername("user100"); user.setPassword("admin");
//		user.setRole("ROLE_USER"); user.setEnabled(true);
//		userRepository.save(user);
//		User user2 = userRepository.findById(1).get();
//		ProductEntity entity = productRepository.findById(6).get();
//		CartItemEntity entity2 = new CartItemEntity();
//	//	entity.setId(5);
//		entity2.setProduct(entity);
//		entity2.setQuantily(2);
//		entity2.setUser(user2);
//		cartItemRepository.save(entity2);
//		return "hello";
//	}
}
