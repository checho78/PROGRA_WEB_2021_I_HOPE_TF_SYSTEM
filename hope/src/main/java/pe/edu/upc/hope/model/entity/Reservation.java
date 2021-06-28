package pe.edu.upc.hope.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reservation")
	private Integer id;

	@Column(name = "description", length = 50, nullable = false)
	private String description;

	@Column(name = "price", length = 50, nullable = false)
	private String price;

	@Column(name = "commission", length = 50, nullable = false)
	private String commission;

	@Column(name = "start_date", nullable = false)
	private String startDate;

	@Column(name = "end_date", nullable = false)
	private String endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_card", nullable = false)
	private Card card;

	//========================= setters and getters and constructores 
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Reservation(Integer id, String description, String price, String commission, String startDate,
			String endDate, Card card) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.commission = commission;
		this.startDate = startDate;
		this.endDate = endDate;
		this.card = card;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}