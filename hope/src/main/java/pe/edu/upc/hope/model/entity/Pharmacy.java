package pe.edu.upc.hope.model.entity;

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
@Table(name="Pharmacies")
public class Pharmacy{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idPharmacy")
    private Integer idPharmacy;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "district", length = 30, nullable = false)
    private String district;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "startHour")
    private int startHour;

    @Column(name = "endHour")
    private int endHour;

    @Column(name = "ruc", length = 100 , nullable= false)
    private Long ruc;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "pharmacy")
    private List<Product> products;

	public Pharmacy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pharmacy(Integer idPharmacy, String name, String address, String district, String password, String description,
			int startHour, int endHour, Long ruc, List<Product> products) {
		super();
		this.idPharmacy = idPharmacy;
		this.name = name;
		this.address = address;
		this.district = district;
		this.password = password;
		this.description = description;
		this.startHour = startHour;
		this.endHour = endHour;
		this.ruc = ruc;
		this.products = products;
	}

	public Integer getIdPharmacy() {
		return idPharmacy;
	}

	public void setIdPharmacy(Integer idPharmacy) {
		this.idPharmacy = idPharmacy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public Long getRuc() {
		return ruc;
	}

	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}
    
    
}