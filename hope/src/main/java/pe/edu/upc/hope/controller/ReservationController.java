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

import pe.edu.upc.hope.model.entity.Reservation;
import pe.edu.upc.hope.service.ReservationService;

@Controller
@RequestMapping("/reservations")  //GET y POST
@SessionAttributes("reservationEdit")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<Reservation> reservations = reservationService.getAll();
			model.addAttribute("reservations", reservations);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "reservations/list";
	}
	@GetMapping("{id}")		// GET: /reservation/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Reservation> optional = reservationService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("reservation", optional.get());
				return "reservations/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: //{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Reservation> optional = reservationService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("reservationEdit", optional.get());
				return "reservations/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}

	@PostMapping("saveedit")	// POST: /reservations/saveedit
	public String saveEdit(Model model, @ModelAttribute("reservationEdit") Reservation reservation) {		
		try {
			reservationService.update(reservation);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/reservations";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /reservations/new
	public String newreservation(Model model) {
		Reservation reservation = new Reservation();
		model.addAttribute("reservationNew", reservation);
		return "reservations/new";
	}
	@PostMapping("savenew")	// POST: /reservation/savenew
	public String saveNew(Model model, @ModelAttribute("reservationNew") Reservation reservation) {		
		try {
			reservationService.create(reservation);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/reservations";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delReservation(@PathVariable("id") Integer id ) {
		try {
			Optional<Reservation> optional = reservationService.findById(id);
			if (optional.isPresent()) {
				reservationService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservations";
	}

}
