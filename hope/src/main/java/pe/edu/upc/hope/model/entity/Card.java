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
@Table(name = "cards")
public class Card {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_card")
    private Integer  idCard;
 
    @Column(name = "num_card", length = 16, nullable = false)
    private String numCard;
    
    @Column(name = "expiration_month", nullable = false)
    private int expirationMonth; 
    
    @Column(name = "expiration_year", nullable = false)
    private int expirationYear; 

    @Column(name = "cvv", length = 3  ,nullable = false)
    private String cvv;
   
    
    @ManyToOne
	@JoinColumn(name = "customer_id", nullable = true)
	private Customer customer;
	
	
    
	// -- Constructor, Getter y Setter
    


	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public int getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public int getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
    
}
