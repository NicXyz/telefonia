package telefonia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telefonia.db.LineaRepository;
import telefonia.model.Linea;

@Service
public class LineaService {

	@Autowired
	LineaRepository lineaRepo;
	
	public Linea inserisciLinea(Linea l) {
		System.out.println(l);
		return lineaRepo.save(l);
	}
	
	public Linea aggiornaLinea(Integer id, Linea l) {
		Linea lineaUpdate = lineaRepo.findByCodLinea(id);
		
		lineaUpdate.setTipo(l.getTipo());
		lineaUpdate.setStato(l.getStato());
		lineaUpdate.setTelefono(l.getTelefono());
		
		return lineaRepo.save(lineaUpdate);		
	}
	
	public Linea eliminaLinea(Integer id) {
		return lineaRepo.deleteByCodLinea(id);
	}
	
	public Linea setStatoLinea(Integer id, String statoLinea) {
		Linea linea = lineaRepo.findByCodLinea(id);
		
		linea.setStato(statoLinea);
		
		return lineaRepo.save(linea);
	}
}
