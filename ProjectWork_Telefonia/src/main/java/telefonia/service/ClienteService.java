package telefonia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonia.db.ClienteRepository;
import telefonia.model.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	public Cliente inserisciCliente(Cliente c) {
		System.out.println(c);
		return clienteRepo.save(c);
	}
	
	public Cliente aggiornaCliente(Integer id, Cliente c) {
		Cliente clienteUpdate = clienteRepo.findByCodCliente(id);
		
		clienteUpdate.setNome(c.getNome());
		clienteUpdate.setCognome(c.getCognome());
		clienteUpdate.setCf(c.getCf());
		clienteUpdate.setCodLinea(c.getCodLinea());
		
		return clienteRepo.save(clienteUpdate);		
	}
	
	public Cliente eliminaCliente(Integer id) {
		return clienteRepo.deleteByCodCliente(id);
	}
	
}
