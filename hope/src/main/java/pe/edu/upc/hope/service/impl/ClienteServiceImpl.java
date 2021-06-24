package pe.edu.upc.hope.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.hope.model.entity.Cliente;
import pe.edu.upc.hope.model.repository.ClienteRepository;
import pe.edu.upc.hope.service.ClienteService;


@Service
public class ClienteServiceImpl  implements ClienteService {

	
	@Autowired
	private ClienteRepository  tarjetaRepository;
	
	
	@Override
	public JpaRepository<Cliente, Integer> getRepository() {
		return tarjetaRepository;
	}

}
