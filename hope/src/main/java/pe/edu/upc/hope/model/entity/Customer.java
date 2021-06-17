

package pe.edu.upc.hope.model.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name=  "idCustomer",nullable=false)
	private Integer idCustomer;
	
	@Column(name = "firstName", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "lastName", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "cellphone", length = 9, nullable = false)
	private String  cellphone;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String  dni;
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "password", length = 20, nullable = false)
	private String password;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Card> cards;

	

	//========================= setters and getters and constructores de Customer
	


	
	public Customer() {
		cards  = new ArrayList<Card>();
	}


	public Customer(Integer idCustomer, String firstName, String lastName, String cellphone, String dni, String email,
			String password) {
		super();
		this.idCustomer = idCustomer;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellphone = cellphone;
		this.dni = dni;
		this.email = email;
		this.password = password;
	
	}


	public Integer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
	

}