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

import pe.edu.upc.hope.model.entity.ReservationDetail;
import pe.edu.upc.hope.service.ReservationDetailService;

@Controller
@RequestMapping("/reservationDetails")  //GET y POST
@SessionAttributes("reservationDetailsEdit")

public class ReservationDetailController {

	@Autowired
	private ReservationDetailService reservationDetailService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<ReservationDetail> reservationDetails = reservationDetailService.getAll();
			model.addAttribute("reservationDetails", reservationDetails);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "reservationDetails/list";
	}
	@GetMapping("{id}")		// GET: /reservationDetail/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<ReservationDetail> optional = reservationDetailService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("reservationDetail", optional.get());
				return "reservationDetails/view";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservationDetails";
	}
	//--------Edit -----------------------------
	@GetMapping("{id}/edit")	// GET: /reservationDetail/{id}/edit
	public String editById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<ReservationDetail> optional = reservationDetailService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("reservationDetailEdit", optional.get());
				return "reservationDetails/edit";
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservationDetails";
	}

	@PostMapping("saveedit")	// POST: /reservationDetails/saveedit
	public String saveEdit(Model model, @ModelAttribute("reservationDetailEdit") ReservationDetail reservationDetail) {		
		try {
			reservationDetailService.update(reservationDetail);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/reservationDetails";
	}	
	// -----------------New----------------------
	@GetMapping("new")	// GET: /reservationDetails/new
	public String newreservationDetail(Model model) {
		ReservationDetail reservationDetail = new ReservationDetail();
		model.addAttribute("reservationDetailNew", reservationDetail);
		return "reservationDetails/new";
	}
	@PostMapping("savenew")	// POST: /reservationDetail/savenew
	public String saveNew(Model model, @ModelAttribute("reservationDetailNew") ReservationDetail reservationDetail) {		
		try {
			reservationDetailService.create(reservationDetail);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
		return "redirect:/reservationDetails";
	}	
	//---------- Delete---------------
	@GetMapping("{id}/del")
	public String delReservationDetail(@PathVariable("id") Integer id ) {
		try {
			Optional<ReservationDetail> optional = reservationDetailService.findById(id);
			if (optional.isPresent()) {
				reservationDetailService.deleteById(id);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/reservationDetails";
	}

}
