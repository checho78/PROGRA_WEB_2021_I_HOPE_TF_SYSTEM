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
	 @Column(name="id_brand")
	    private Integer id;
	 
    @Column(name = "name", length = 30)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "brand")
    private List<Product> products;

    
    //getters,setters y constructores
    
	public Brand() {
		products  = new ArrayList<Product>();
	}

    
    
	public Brand( String name, List<Product> products, Integer id) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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
