

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.hope.model.entity.Product;
import pe.edu.upc.hope.model.entity.Pharmacy;
import pe.edu.upc.hope.model.entity.Category;
import pe.edu.upc.hope.model.entity.Brand;

import pe.edu.upc.hope.service.ProductService;
import pe.edu.upc.hope.service.PharmacyService;
import pe.edu.upc.hope.service.CategoryService;
import pe.edu.upc.hope.service.BrandService;

@Controller
@RequestMapping("/products")	// GET y POST
@SessionAttributes("productEdit")
public class ProductController {
	
	@Autowired
	private ProductService productService; 
	
	@Autowired
	private PharmacyService pharmacyService; 
	

	@Autowired
	private CategoryService categoryService; 
	
	@Autowired
	private BrandService brandService; 
	
	@GetMapping		// GET: /product
	public String list(Model model) {
		try {
			List<Product> products = productService.getAll();
			 
			model.addAttribute("products", products);
		 	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "products/list";
	}
	
	
	// find ================
	
	
	@GetMapping("/searchname")
	public String searchByName(Model model, @RequestParam(value = "name", required = false) String name) {
		try {
			List<Product> products;
			products = productService.findByName(name);
			products = productService.getAll();
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "products/list";
	}

	@GetMapping("/searchprice")
	public String searchByPrice(Model model, @RequestParam(value = "price", required = false) Double price) {
		try {
			List<Product> products;
			products = productService.findByPrice(price);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "products/list";
	}

	@GetMapping("/searchdescription")
	public String searchByDescription(Model model,
			@RequestParam(value = "description", required = false) String description) {
		try {
			List<Product> products;
			products = productService.findByDescription(description);
			model.addAttribute("products", products);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "products/list";
	}
	
	
	@GetMapping("{id}")		// GET: /product/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Product> optional = productService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("product", optional.get());
				return "products/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	

	@GetMapping("{id}/shop")		// GET: /product/{id}
	public String Shopping(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Product> optional = productService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("product", optional.get());
				return "layout/shoppingCart";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /product/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Product> optional = productService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("productEdit", optional.get());
				return "products/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}

	@PostMapping("saveedit")	// POST: /product/saveedit
	public String saveEdit(Model model, @ModelAttribute("productEdit") Product product) {		
		try {
			productService.update(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/products";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /product/new
	public String newproduct(Model model) {
		
		try {
			Product product = new Product();
			List<Pharmacy> pharmacies = pharmacyService.getAll();
			List<Category> categories= categoryService.getAll();
			List<Brand> brands = brandService.getAll();

			
			model.addAttribute("productNew", product);
			model.addAttribute("pharmacies", pharmacies);
			model.addAttribute("brands", brands);
			model.addAttribute("categories", categories);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "products/new";
	}
	@PostMapping("savenew")	// POST: /product/savenew
	public String saveNew(Model model, @ModelAttribute("productNew") Product product) {		
		try {
			productService.create(product);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/products";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delProduct(@PathVariable("id") Integer id ) {
		try {
			Optional<Product> optional = productService.findById(id);
			if (optional.isPresent()) {
				productService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/products";
	}
	
}










