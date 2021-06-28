

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

import pe.edu.upc.hope.model.entity.Pharmacy;
import pe.edu.upc.hope.service.PharmacyService;

@Controller
@RequestMapping("/pharmacies")	// GET y POST
@SessionAttributes("pharmacyEdit")
public class PharmacyController {
	
	@Autowired
	private PharmacyService pharmacyService; 
	
	@GetMapping		// GET: /pharmacy
	public String list(Model model) {
		try {
			List<Pharmacy> pharmacies = pharmacyService.getAll();
			model.addAttribute("pharmacies", pharmacies);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "pharmacies/list";
	}
	
	@GetMapping("{id}")		// GET: /pharmacy/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Pharmacy> optional = pharmacyService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("pharmacy", optional.get());
				return "pharmacies/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/pharmacies";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /pharmacy/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Pharmacy> optional = pharmacyService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("pharmacyEdit", optional.get());
				return "pharmacies/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/pharmacies";
	}

	@PostMapping("saveedit")	// POST: /pharmacy/saveedit
	public String saveEdit(Model model, @ModelAttribute("pharmacyEdit") Pharmacy pharmacy) {		
		try {
			pharmacyService.update(pharmacy);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/pharmacies";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /pharmacy/new
	public String newpharmacy(Model model) {
		Pharmacy pharmacy = new Pharmacy();
		model.addAttribute("pharmacyNew", pharmacy);
		return "pharmacies/new";
	}
	@PostMapping("savenew")	// POST: /pharmacy/savenew
	public String saveNew(Model model, @ModelAttribute("pharmacyNew") Pharmacy pharmacy) {		
		try {
			pharmacyService.create(pharmacy);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/pharmacies";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delPharmacy(@PathVariable("id") Integer id ) {
		try {
			Optional<Pharmacy> optional = pharmacyService.findById(id);
			if (optional.isPresent()) {
				pharmacyService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/pharmacies";
	}
	
}










