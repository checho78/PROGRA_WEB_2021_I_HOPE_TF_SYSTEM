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

import pe.edu.upc.hope.model.entity.Card;
import pe.edu.upc.hope.service.CardService;

import pe.edu.upc.hope.model.entity.Customer;
import pe.edu.upc.hope.service.CustomerService;

@Controller
@RequestMapping("/cards")	// GET y POST
@SessionAttributes("cardEdit")
public class CardController {
	
	@Autowired
	private CardService cardService; 
	
	@Autowired
	private CustomerService customerService; 
	
	
	
	@GetMapping		// GET: /card
	public String list(Model model) {
		try {
			List<Card> cards = cardService.getAll();
			 
			model.addAttribute("cards", cards);
		 	
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "cards/list";
	}
	
	@GetMapping("{id}")		// GET: /card/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Card> optional = cardService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("card", optional.get());
				return "cards/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/cards";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /card/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Card> optional = cardService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("cardEdit", optional.get());
				return "cards/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/cards";
	}

	@PostMapping("saveedit")	// POST: /card/saveedit
	public String saveEdit(Model model, @ModelAttribute("cardEdit") Card card) {		
		try {
			cardService.update(card);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/cards";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /card/new
	public String newcard(Model model) {
		
		try {
			Card card = new Card();
			List<Customer> customers = customerService.getAll();
			model.addAttribute("cardNew", card);
			model.addAttribute("customers", customers);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "cards/new";
	}
	@PostMapping("savenew")	// POST: /card/savenew
	public String saveNew(Model model, @ModelAttribute("cardNew") Card card) {		
		try {
			cardService.create(card);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/cards";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delCard(@PathVariable("id") Integer id ) {
		try {
			Optional<Card> optional = cardService.findById(id);
			if (optional.isPresent()) {
				cardService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/cards";
	}
	
}










