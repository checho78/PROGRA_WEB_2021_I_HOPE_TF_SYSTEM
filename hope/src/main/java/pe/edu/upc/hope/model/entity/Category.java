package pe.edu.upc.hope.model.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="Categories")
public class Category{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private Long idCategory;

    @Column(name = "name", length = 10, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category")
    private List<Product> products;

	public Category() {
		super();
	
	}

	public Category(Long idCategory, String name, List<Product> products) {
		super();
		this.idCategory = idCategory;
		this.name = name;
		this.products = products;
	}

	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
    
}