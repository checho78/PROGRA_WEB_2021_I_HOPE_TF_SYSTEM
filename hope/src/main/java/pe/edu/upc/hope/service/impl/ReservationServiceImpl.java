package pe.edu.upc.hope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Reservation;
import pe.edu.upc.hope.model.repository.ReservationRepository;
import pe.edu.upc.hope.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public JpaRepository<Reservation, Integer> getRepository() {
	
		return reservationRepository;
	}
}
