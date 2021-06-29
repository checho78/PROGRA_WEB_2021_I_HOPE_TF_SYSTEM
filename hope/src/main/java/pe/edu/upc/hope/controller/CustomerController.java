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

import pe.edu.upc.hope.model.entity.Customer;
import pe.edu.upc.hope.service.CustomerService;

@Controller
@RequestMapping("/customers")	// GET y POST
@SessionAttributes("customerEdit")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService; 
	
	@GetMapping		// GET: /customer
	public String list(Model model) {
		try {
			List<Customer> customers = customerService.getAll();
			model.addAttribute("customers", customers);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "customers/list";
	}
	
	@GetMapping("{id}")		// GET: /customer/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Customer> optional = customerService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("customer", optional.get());
				return "customers/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /customer/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Customer> optional = customerService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("customerEdit", optional.get());
				return "customers/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers";
	}

	@PostMapping("saveedit")	// POST: /customer/saveedit
	public String saveEdit(Model model, @ModelAttribute("customerEdit") Customer customer) {		
		try {
			customerService.update(customer);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/customers";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /customer/new
	public String newcustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customerNew", customer);
		return "customers/new";
	}
	@PostMapping("savenew")	// POST: /customer/savenew
	public String saveNew(Model model, @ModelAttribute("customerNew") Customer customer) {		
		try {
			customerService.create(customer);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/customers";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delCustomer(@PathVariable("id") Integer id ) {
		try {
			Optional<Customer> optional = customerService.findById(id);
			if (optional.isPresent()) {
				customerService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/customers";
	}
	
}










