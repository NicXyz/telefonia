package telefonia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import telefonia.db.ClienteRepository;
import telefonia.model.Cliente;
import telefonia.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	ClienteService clienteService;
	
	
	@GetMapping("/clienti")
	public Iterable<Cliente> vediClienti() {
		return clienteRepo.findAll();
	}
	
	@PostMapping("/clienti")
	public Cliente inserisciCliente(@RequestBody Cliente c) {
		return clienteService.inserisciCliente(c);
	}
	
	@RequestMapping(value="/clienti/{codCliente}", method=RequestMethod.PUT)
	public Cliente modificaCliente(@PathVariable("codCliente")Integer codCliente, @RequestBody Cliente c) {
		return clienteService.aggiornaCliente(codCliente, c);
	}
	
	@DeleteMapping("clienti/{codCliente}")
	public Cliente cancellaCliente(@PathVariable("codCliente") Integer codCliente) {
		return clienteService.eliminaCliente(codCliente);
	}

}
