package pe.edu.upc.hope.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FrontController {
	
	
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
	
	
	@GetMapping("home")
	public String home() {
		return "layout/home";
	}
	
	@GetMapping("allProducts")
	public String allProducts() {
		return "layout/allProducts";
	}
	
	@GetMapping("shoppingCart")
	public String shoppingCart() {
		return "layout/shoppingCart";
	}
	@GetMapping("viewDetails")
	public String viewDetails() {
		return "layout/viewDetails";
	}
	
	@GetMapping("pay")
	public String pay() {
		return "layout/pay";
	}
	
	@GetMapping("reservation")
	public String reservation() {
		return "layout/reservation";
	}
	
	@GetMapping("myReservations")
	public String myReservations() {
		return "layout/myReservations";
	}

	
	@GetMapping("allPharmacies")
	public String allPharmacies() {
		return "layout/allPharmacies";
	}

	@GetMapping("viewDetailsPharmacies")
	public String viewDetailsPharmacies() {
		return "layout/viewDetailsPharmacies";
	}
	
	
}
