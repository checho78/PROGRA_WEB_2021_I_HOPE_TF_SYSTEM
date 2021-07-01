package pe.edu.upc.hope.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.hope.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT u FROM Customer u WHERE u.email = ?1")
    public Customer findByEmail(String email);
}
