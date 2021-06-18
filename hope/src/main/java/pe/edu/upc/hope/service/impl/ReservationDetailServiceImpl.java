package pe.edu.upc.hope.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.ReservationDetail;
import pe.edu.upc.hope.model.repository.ReservationDetailRepository;
import pe.edu.upc.hope.service.ReservationDetailService;

@Service
public class ReservationDetailServiceImpl implements ReservationDetailService{

	@Autowired
	private ReservationDetailRepository reservationDetailRepository;
	
	@Override
	public JpaRepository<ReservationDetail, Integer> getRepository(){
		
		return reservationDetailRepository;
	}
}
