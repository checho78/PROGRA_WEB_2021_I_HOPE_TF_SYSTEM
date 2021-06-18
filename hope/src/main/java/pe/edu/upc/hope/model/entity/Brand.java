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
@Table(name = "Brands")
public class Brand {
	

	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 @Column(name="idBrand")
	    private Integer idBrand;
	 
    @Column(name = "name", length = 30)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brand")
    private List<Product> products;

    
    //getters,setters y constructores
    
	public Brand() {
		products  = new ArrayList<Product>();
	}

    
    
	public Brand(Integer idBrandCategory, String name, List<Product> products) {
		super();
		this.idBrand = idBrand;
		this.name = name;
		this.products = products;
	}



	public Integer getIdBrand() {
		return idBrand;
	}


	public void setIdBrand(Integer idBrand) {
		this.idBrand = idBrand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	


  
}
