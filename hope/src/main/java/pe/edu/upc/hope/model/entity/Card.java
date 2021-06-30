package pe.edu.upc.hope.model.entity;

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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
   
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;
	
    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
	private List<Reservation> reservations;
	
    
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
    
	
}
