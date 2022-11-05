package com.DemoSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DemoSpring.DTO.CategoryDTO;
import com.DemoSpring.Service.CategoryService;
@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<CategoryDTO> list = categoryService.findAll();
		model.addAttribute("list", list);
		return "listCategory";
	}
	
	@GetMapping("/add")
	public String add() {
		return "addCategory";
	}
	@PostMapping("/add")
	public String postadd(@ModelAttribute("category") CategoryDTO categoryDTO) {
		categoryService.save(categoryDTO);
		return "redirect:/category/list";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") int id,Model model) {
		CategoryDTO dto = categoryService.getId(id);
		model.addAttribute("category", dto);
		return "updateCategory";
	}
	@PostMapping("/update")
	public String postupdate(@ModelAttribute("category") CategoryDTO categoryDTO) {
		categoryService.save(categoryDTO);
		return "redirect:/category/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		categoryService.delete(id);
		return "redirect:/category/list";

	}
}
