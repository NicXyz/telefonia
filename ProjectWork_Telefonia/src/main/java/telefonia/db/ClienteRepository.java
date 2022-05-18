package telefonia.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import telefonia.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	
	Cliente findByCodCliente(Integer codCliente);
	Cliente deleteByCodCliente(Integer codCliente);
}
