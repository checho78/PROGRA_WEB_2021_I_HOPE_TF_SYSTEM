package pe.edu.upc.hope.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.hope.model.entity.Tarjeta;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

}
