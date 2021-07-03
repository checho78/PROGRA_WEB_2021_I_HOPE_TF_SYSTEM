package pe.edu.upc.hope.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.hope.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	@Query("select p from Product p where p.name like ?1% ")
	 List<Product> findByName(String name);
	
	    List<Product> findByPrice(Double price);
	
	    @Query("select p from Product p where p.description like ?1% ")
	    List<Product> findByDescription(String description);

	    
	//List<Product> findByReservation(Reservation reservation);
}
