package pe.edu.upc.hope.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.hope.model.entity.Product;
import pe.edu.upc.hope.model.entity.Reservation;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	

	 List<Product> findByName(String name);
	    List<Product> findByPrice(Double price);
	    List<Product> findByDescription(String description);

	    
	//List<Product> findByReservation(Reservation reservation);
}
