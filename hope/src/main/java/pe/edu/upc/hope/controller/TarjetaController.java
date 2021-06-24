

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

import pe.edu.upc.hope.model.entity.Tarjeta;
import pe.edu.upc.hope.service.TarjetaService;

@Controller
@RequestMapping("/tarjetas")	// GET y POST
@SessionAttributes("tarjetaEdit")
public class TarjetaController {
	
	@Autowired
	private TarjetaService tarjetaService; 
	
	@GetMapping		// GET: /tarjeta
	public String list(Model model) {
		try {
			List<Tarjeta> tarjetas = tarjetaService.getAll();
			model.addAttribute("tarjetas", tarjetas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "tarjetas/list";
	}
	
	@GetMapping("{id}")		// GET: /tarjeta/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Tarjeta> optional = tarjetaService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("tarjeta", optional.get());
				return "tarjetas/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tarjetas";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /tarjeta/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Tarjeta> optional = tarjetaService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("tarjetaEdit", optional.get());
				return "tarjetas/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tarjetas";
	}

	@PostMapping("saveedit")	// POST: /tarjeta/saveedit
	public String saveEdit(Model model, @ModelAttribute("tarjetaEdit") Tarjeta tarjeta) {		
		try {
			tarjetaService.update(tarjeta);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/tarjetas";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /tarjeta/new
	public String newtarjeta(Model model) {
		Tarjeta tarjeta = new Tarjeta();
		model.addAttribute("tarjetaNew", tarjeta);
		return "tarjetas/new";
	}
	@PostMapping("savenew")	// POST: /tarjeta/savenew
	public String saveNew(Model model, @ModelAttribute("tarjetaNew") Tarjeta tarjeta) {		
		try {
			tarjetaService.create(tarjeta);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/tarjetas";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delTarjeta(@PathVariable("id") Integer id ) {
		try {
			Optional<Tarjeta> optional = tarjetaService.findById(id);
			if (optional.isPresent()) {
				tarjetaService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tarjetas";
	}
	
}










