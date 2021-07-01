package pe.edu.upc.hope.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name = "customers")
public class Customer {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
    private Integer  id; 


	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "cellphone", length = 9, nullable = false)
	private String  cellphone;
	
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "dni", length = 40, nullable = false)
	private String dni;
	
	@Column(name = "password", length = 20, nullable = false)
	private String password;



	/* @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Card> cards;
	

	
	// -- Constructor, Getter y Setter
	
	public Customer() {
		cards= new ArrayList<Card> ();
	}


	public List<Card> getCards() {
		return cards;
	}


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
*/

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
}
