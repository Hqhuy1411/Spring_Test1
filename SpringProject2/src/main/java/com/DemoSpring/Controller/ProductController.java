package com.DemoSpring.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.DemoSpring.DTO.ProductDTO;
import com.DemoSpring.Repository.CategoryRepository;
import com.DemoSpring.Service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<ProductDTO> list = productService.findAll();
		model.addAttribute("list", list);
		return "listProduct";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("listCategory", categoryRepository.findAllName());
		return "addProduct";
	}
	@PostMapping("/add")
	public String postadd(@ModelAttribute("product") ProductDTO productDTO, 
						  @ModelAttribute("file") MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		productDTO.setImageUrl(fileName);
		productService.save(productDTO);
		String  uploadDir = "./images" ;
		Path uploadPath = Paths.get(uploadDir);
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try(InputStream inputStream = file.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception e) {
			// TODO: handle exception
			//throw new IOException("Could not save upload file " + fileName);
			productService.save(productDTO);
		}
		return "redirect:/product/list";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") int id,Model model) {
		ProductDTO dto  = productService.getId(id);
		model.addAttribute("product", dto);
		List<String> listcategory = categoryRepository.findAllName();
		model.addAttribute("listCategory", listcategory);
		return "updateProduct";
	}
	@PostMapping("/update")
	public String postupdate(@ModelAttribute("product") ProductDTO productDTO, 
							 @ModelAttribute("file") MultipartFile file) throws IOException {
		if(file!=null) {
			String fileName = file.getOriginalFilename();
			String  uploadDir = "./images" ;
			Path uploadPath = Paths.get(uploadDir);
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			try(InputStream inputStream = file.getInputStream()){
				Path filePath = uploadPath.resolve(fileName);
				Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
				productDTO.setImageUrl(fileName);
				productService.save(productDTO);
			}catch (Exception e) {
				// TODO: handle exception
				productService.save(productDTO);
			}
		}
		return "redirect:/product/list";

	}
	@GetMapping("/get/{id}")
	public String view(@PathVariable("id")int id,Model model) {
		ProductDTO dto  = productService.getId(id);
		model.addAttribute("product", dto);
		return "view-product";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		productService.delete(id);
		return "redirect:/product/list";

	}
}
