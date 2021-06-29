

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

import pe.edu.upc.hope.model.entity.Cliente;
import pe.edu.upc.hope.service.ClienteService;

@Controller
@RequestMapping("/clientes")	// GET y POST
@SessionAttributes("clienteEdit")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService; 
	
	@GetMapping		// GET: /cliente
	public String list(Model model) {
		try {
			List<Cliente> clientes = clienteService.getAll();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "clientes/list";
	}
	
	@GetMapping("{id}")		// GET: /cliente/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
				return "clientes/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/clientes";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /cliente/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("clienteEdit", optional.get());
				return "clientes/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/clientes";
	}

	@PostMapping("saveedit")	// POST: /cliente/saveedit
	public String saveEdit(Model model, @ModelAttribute("clienteEdit") Cliente cliente) {		
		try {
			clienteService.update(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/clientes";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /cliente/new
	public String newcliente(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("clienteNew", cliente);
		return "clientes/new";
	}
	@PostMapping("savenew")	// POST: /cliente/savenew
	public String saveNew(Model model, @ModelAttribute("clienteNew") Cliente cliente) {		
		try {
			clienteService.create(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/clientes";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delCliente(@PathVariable("id") Integer id ) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if (optional.isPresent()) {
				clienteService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/clientes";
	}
	
}










