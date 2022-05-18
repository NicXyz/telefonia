package telefonia.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import telefonia.model.Linea;

@Repository
public interface LineaRepository extends CrudRepository<Linea, Integer> {
	
	Linea findByCodLinea(Integer codLinea);
	Linea deleteByCodLinea(Integer codLinea);
	
}
