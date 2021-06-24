package pe.edu.upc.hope.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class Tarjeta {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarjeta")
    private Integer  idTarjeta;
 
    @Column(name = "num_tarjeta", length = 16, nullable = false)
    private String numTarjeta;
    
    @Column(name = "expiration_month", nullable = false)
    private int expirationMonth; 
    
    @Column(name = "expiration_year", nullable = false)
    private int expirationYear; 

    @Column(name = "cvv", length = 3  ,nullable = false)
    private String cvv;
    
	// -- Constructor, Getter y Setter
    
	public Tarjeta(Integer idTarjeta, String numTarjeta, int expirationMonth, int expirationYear, String cvv) {
		super();
		this.idTarjeta = idTarjeta;
		this.numTarjeta = numTarjeta;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
	}

	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
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
