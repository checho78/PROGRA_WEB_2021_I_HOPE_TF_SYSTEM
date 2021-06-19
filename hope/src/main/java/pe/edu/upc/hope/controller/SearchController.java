package pe.edu.upc.hope.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.hope.model.entity.Pharmacy;
import pe.edu.upc.hope.model.entity.Category;
import pe.edu.upc.hope.service.CategoryService;
import pe.edu.upc.hope.service.PharmacyService;

@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private PharmacyService pharmacyService;
	
	@GetMapping("district")
	public String district() {
		return "search/district";
	}
	
}

