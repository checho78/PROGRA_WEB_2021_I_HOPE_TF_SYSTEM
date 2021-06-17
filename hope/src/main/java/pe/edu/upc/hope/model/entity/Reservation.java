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
	@Column(name = "idReservation")
	private int idReservation;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCard", nullable = false)
	private Card card;

	//========================= setters and getters and constructores 
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Reservation(int idReservation, String description, String price, String commission, int startDate,
			int endDate, Card card) {
		super();
		this.idReservation = idReservation;
		this.description = description;
		this.price = price;
		this.commission = commission;
		this.startDate = startDate;
		this.endDate = endDate;
		this.card = card;
	}




	public int getIdReservation() {
		return idReservation;
	}



	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
}