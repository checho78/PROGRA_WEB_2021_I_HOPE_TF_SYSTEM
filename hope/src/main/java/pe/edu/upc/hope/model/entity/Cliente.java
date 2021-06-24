package pe.edu.upc.hope.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
    private Integer  idCliente; 


	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 30, nullable = false)
	private String lastName;
	
	@Column(name = "cellphone", length = 9, nullable = false)
	private String  cellphone;
	
	
	@Column(name = "email", length = 40, nullable = false)
	private String email;
	
	@Column(name = "password", length = 20, nullable = false)
	private String password;


	
	// -- Constructor, Getter y Setter
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cliente(Integer idCliente, String firstName, String lastName, String cellphone,String email,
			String password) {
		super();
		this.idCliente = idCliente;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cellphone = cellphone;
		this.email = email;
		this.password = password;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
