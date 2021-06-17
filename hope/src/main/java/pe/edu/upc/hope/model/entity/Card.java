package pe.edu.upc.hope.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCard;

    @Column(name = "num_card", length = 30)
    private String numCard;
    
    @Column(name = "expiration_date", nullable = false)
    private int expirationDate; 

    @Column(name = "cvv", length = 3)
    private String cvv;
    
    @ManyToOne
	@JoinColumn(name="id")
    private Customer customer;

	public Card() {
		super();
	}

	public Card(int idCard, String numCard, int expirationDate, String cvv, Customer customer) {
		super();
		this.idCard = idCard;
		this.numCard = numCard;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.customer = customer;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    

}