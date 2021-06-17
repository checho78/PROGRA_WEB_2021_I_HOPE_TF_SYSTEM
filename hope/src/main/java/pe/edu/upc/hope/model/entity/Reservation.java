package pe.edu.upc.hope.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description", length = 50, nullable = false)
	private String description;

	@Column(name = "price", length = 50, nullable = false)
	private String price;

	@Column(name = "commission", length = 50, nullable = false)
	private String commission;

	@Column(name = "startDate", nullable = false)
	private int startDate;

	@Column(name = "endDate", nullable = false)
	private int endDate;

	
	//constructor y getters and  setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public Reservation() {
		super();

	}

	public Reservation(int id, String description, String price, String commission, int startDate, int endDate) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.commission = commission;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
}