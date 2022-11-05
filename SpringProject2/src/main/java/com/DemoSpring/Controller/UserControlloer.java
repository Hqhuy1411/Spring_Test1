package com.DemoSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.DemoSpring.Convert.ForProduct;
import com.DemoSpring.DTO.ProductDTO;
import com.DemoSpring.Entity.CartItemEntity;
import com.DemoSpring.Entity.ProductEntity;
import com.DemoSpring.Entity.User;
import com.DemoSpring.Repository.CartItemRepository;
import com.DemoSpring.Repository.ProductRepository;
import com.DemoSpring.Repository.UserRepository;

@Controller
public class UserControlloer {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ForProduct forProduct;
	
	@GetMapping("/user")
	public String view(Authentication authentication,Model model) {
		String name = authentication.getName();
	//	System.out.println(authentication.getPrincipal().toString());
		System.out.println(name);
		User user = userRepository.getUser(name);
		List<ProductEntity> list = cartItemRepository.getProducts(user.getId());
		List<ProductDTO> list2 = forProduct.toListdto(list);
		List<Integer> quantilys = cartItemRepository.getQuantilys(user.getId());
		model.addAttribute("quantilys", quantilys);
		model.addAttribute("list", list2);
		model.addAttribute("user", user);
		return "view-user";
	}
	@GetMapping("/cartitem/get/")
	public String views(Authentication authentication, Model model,
						@RequestParam("quantity") int quantity,@RequestParam("id") int id) {
		
//		System.out.println(quantity);
//		System.out.println(id);
		ProductEntity product = productRepository.findById(id).get();
		String name = authentication.getName();
		User user = userRepository.getUser(name);
		CartItemEntity cartItemEntity = new CartItemEntity();
		cartItemEntity.setQuantily(quantity);
		cartItemEntity.setUser(user);
		cartItemEntity.setProduct(product);
		cartItemRepository.save(cartItemEntity);
		return "redirect:/user";
	}
	@GetMapping("cartitem/delete/{product_id}")
	public String delete(@PathVariable("product_id") int product ,Authentication authentication) {
		String name = authentication.getName();
		User user = userRepository.getUser(name);
		ProductEntity products = productRepository.findById(product).get();
		cartItemRepository.deletebyUserandProduct(user.getId(), products.getId());
		return "redirect:/user";
	}
	
}
