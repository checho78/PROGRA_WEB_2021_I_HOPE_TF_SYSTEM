package pe.edu.upc.hope.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Tarjeta;
import pe.edu.upc.hope.model.repository.TarjetaRepository;
import pe.edu.upc.hope.service.TarjetaService;


@Service
public class TarjetaServiceImpl  implements TarjetaService {

	
	@Autowired
	private TarjetaRepository  tarjetaRepository;
	
	
	@Override
	public JpaRepository<Tarjeta, Integer> getRepository() {
		return tarjetaRepository;
	}

}
