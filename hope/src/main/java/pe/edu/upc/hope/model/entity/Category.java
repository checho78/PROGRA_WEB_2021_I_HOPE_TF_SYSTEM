package pe.edu.upc.hope.model.entity;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Categories")
public class Category{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_category")
    private Integer id;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product> products;

    
    //getters,setters y constructores
    
    
	public Category() {
		products  = new ArrayList<Product>();
	}


	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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