package pe.edu.upc.hope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import pe.edu.upc.hope.model.entity.Pharmacy;
import pe.edu.upc.hope.model.entity.Category;
import pe.edu.upc.hope.service.CategoryService;
import pe.edu.upc.hope.service.PharmacyService;



@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private PharmacyService pharmacyService;
	private CategoryService categoryService;
	
	@PostMapping("district")		// POST: /search/employees
	public String searchDistrict(Model model , @ModelAttribute("employeeSearch") Pharmacy districtSearch) {
		System.out.println("LLEGO");
		List<Pharmacy> district = null;
		try {
			district = pharmacyService.findByDistrict(districtSearch.getDistrict()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("district", district);
		model.addAttribute("districtSearch", districtSearch);
		return "search/district";
	}
	
	@PostMapping("categoryName")		// POST: /search/category
	public String searchCategoryByName(Model model , @ModelAttribute("categorySearch") Category categoryNameSearch) 
	{
		System.out.println("LLEGO");
		List<Category> name = null;
		try {
			name = categoryService.findByCategoryName(categoryNameSearch.getName()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("district", name );
		model.addAttribute("districtSearch", categoryNameSearch);
		return "search/district";
	}
	
}

