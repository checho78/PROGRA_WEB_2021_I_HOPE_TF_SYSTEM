package pe.edu.upc.hope.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Integer id;
	
	@Column(name = "name", length = 30)
	private String name;
	
	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	@Column(name = "price")
	private Double price;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "description", length = 100)
	private String description;
	
	
	  @ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "id_brand", nullable = false)
		private Brand brand;
	  
	  
	  @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_category", nullable = false)
	  private Category category;
	  
	
	  @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_pharmacy", nullable = false)
	  private Pharmacy pharmacy;


		@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
		private List<ReservationDetail> reservationDetails;

		

	//===== setters and getters and constructor 
	  
	  
	
		public Product() {
			reservationDetails  = new ArrayList<ReservationDetail>();
		}



		public Product(Integer id, String name, Double price, String description, Brand brand, Category category,
				Pharmacy pharmacy, List<ReservationDetail> reservationDetails) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.description = description;
			this.brand = brand;
			this.category = category;
			this.pharmacy = pharmacy;
			this.reservationDetails = reservationDetails;
		}



		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public Double getPrice() {
			return price;
		}



		public void setPrice(Double price) {
			this.price = price;
		}



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}



		public Brand getBrand() {
			return brand;
		}



		public void setBrand(Brand brand) {
			this.brand = brand;
		}



		public Category getCategory() {
			return category;
		}



		public void setCategory(Category category) {
			this.category = category;
		}



		public Pharmacy getPharmacy() {
			return pharmacy;
		}



		public void setPharmacy(Pharmacy pharmacy) {
			this.pharmacy = pharmacy;
		}



		public List<ReservationDetail> getReservationDetails() {
			return reservationDetails;
		}



		public void setReservationDetails(List<ReservationDetail> reservationDetails) {
			this.reservationDetails = reservationDetails;
		}



	
	
	
	
}
