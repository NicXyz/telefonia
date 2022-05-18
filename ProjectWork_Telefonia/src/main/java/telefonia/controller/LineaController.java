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

import telefonia.db.LineaRepository;
import telefonia.model.Linea;
import telefonia.service.LineaService;

@RestController
public class LineaController {
	
	@Autowired
	LineaRepository lineaRepo;
	
	@Autowired
	LineaService lineaService;
	
	@GetMapping("/linee")
	public Iterable<Linea> vediLinee() {
		return lineaRepo.findAll();
	}
	
	@PostMapping("/linee")
	public Linea inserisciLinea(@RequestBody Linea l) {
		return lineaService.inserisciLinea(l);
	}
	
	@RequestMapping(value="/linee/{codLinea}", method=RequestMethod.PUT)
	public Linea modificaLinea(@PathVariable("codLinea")Integer codLinea, @RequestBody Linea l) {
		return lineaService.aggiornaLinea(codLinea, l);
	}
	
	@DeleteMapping("linee/{codLinea}")
	public Linea cancellaLinea(@PathVariable("codLinea") Integer codLinea) {
		return lineaService.eliminaLinea(codLinea);
	}
	
	@RequestMapping(value="/setStatoLinea/{codLinea}/{statoLinea}", method=RequestMethod.PATCH)
	public Linea setStatoLinea(@PathVariable("codLinea")Integer codLinea, @PathVariable("statoLinea")String statoLinea) {
		return lineaService.setStatoLinea(codLinea, statoLinea);
	}
}
