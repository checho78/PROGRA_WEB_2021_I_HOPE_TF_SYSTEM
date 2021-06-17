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
@Table(name = "Cards")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCard;
 
    @Column(name = "numCard", length = 30, nullable = false)
    private String numCard;
    
    @Column(name = "expirationDate", nullable = false)
    private int expirationDate; 

    @Column(name = "cvv", length = 3  ,nullable = false)
    private String cvv;
    
 
    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
	private List<Reservation> reservation;

    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCustomer", nullable = false)
	private Customer  customer;


	//===== setters and getters and constructor 
	
    
	public Card(int idCard, String numCard, int expirationDate, String cvv, Customer customer) {
		super();
		this.idCard = idCard;
		this.numCard = numCard;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
		this.customer = customer; 
	}



	public Card() {
		reservation  = new ArrayList<Reservation>();
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




