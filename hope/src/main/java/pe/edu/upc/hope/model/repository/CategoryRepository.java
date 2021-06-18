package pe.edu.upc.hope.model.repository;

import pe.edu.upc.hope.model.entity.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer>{
	
	List<Category> findByCategoryName(String categoryName); 
}