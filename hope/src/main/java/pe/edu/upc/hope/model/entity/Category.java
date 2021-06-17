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
    @Column(name="idCategory")
    private Integer idCategory;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product> products;

    
    //getters,setters y constructores
    
    
	public Category() {
		products  = new ArrayList<Product>();
	}


	public Category(Integer idCategory, String name) {
		super();
		this.idCategory = idCategory;
		this.name = name;
	}


	public Integer getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
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