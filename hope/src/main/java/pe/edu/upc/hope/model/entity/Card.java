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
    private Integer  id;
 
    @Column(name = "num_card", length = 16, nullable = false)
    private String numCard;
    
    @Column(name = "expiration_date", nullable = false)
    private String expirationDate; 
    

    @Column(name = "cvv", length = 3  ,nullable = false)
    private String cvv;
   
    
    @ManyToOne
	@JoinColumn(name = "id_customer", nullable = true)
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
    
}
