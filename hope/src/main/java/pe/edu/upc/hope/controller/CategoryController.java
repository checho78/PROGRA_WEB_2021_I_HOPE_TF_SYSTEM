

package pe.edu.upc.hope.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.hope.model.entity.Category;
import pe.edu.upc.hope.service.CategoryService;

@Controller
@RequestMapping("/categories")	// GET y POST
@SessionAttributes("categoryEdit")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService; 
	
	@GetMapping		// GET: /category
	public String list(Model model) {
		try {
			List<Category> categories = categoryService.getAll();
			model.addAttribute("categories", categories);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "categories/list";
	}
	
	@GetMapping("{id}")		// GET: /category/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Category> optional = categoryService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("category", optional.get());
				return "categories/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/categories";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /category/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Category> optional = categoryService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("categoryEdit", optional.get());
				return "categories/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/categories";
	}

	@PostMapping("saveedit")	// POST: /category/saveedit
	public String saveEdit(Model model, @ModelAttribute("categoryEdit") Category category) {		
		try {
			categoryService.update(category);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/categories";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /category/new
	public String newcategory(Model model) {
		Category category = new Category();
		model.addAttribute("categoryNew", category);
		return "categories/new";
	}
	@PostMapping("savenew")	// POST: /category/savenew
	public String saveNew(Model model, @ModelAttribute("categoryNew") Category category) {		
		try {
			categoryService.create(category);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/categories";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delCategory(@PathVariable("id") Integer id ) {
		try {
			Optional<Category> optional = categoryService.findById(id);
			if (optional.isPresent()) {
				categoryService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/categories";
	}
	
}










