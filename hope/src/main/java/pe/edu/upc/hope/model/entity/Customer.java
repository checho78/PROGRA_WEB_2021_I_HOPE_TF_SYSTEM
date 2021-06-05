package pe.edu.upc.hope.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name= "Customers",
			indexes = {@Index(columnList = "firstName, lastName", name = "customers_index_first_last_name") },
			uniqueConstraints = { @UniqueConstraint( columnNames = { "email" } ) })
		
@SequenceGenerator(name = "Customers_customer_id_seq", initialValue = 1, allocationSize = 1)
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCustomer" )
	@Column(name=  "idCustomer", columnDefinition = "NUMERIC(6)")
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

	
	

	//=========================
	
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

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
