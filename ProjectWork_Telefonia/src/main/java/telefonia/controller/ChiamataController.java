package telefonia.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import telefonia.db.ChiamataRepository;
import telefonia.model.Chiamata;
import telefonia.service.ChiamataService;

@RestController
public class ChiamataController {
	
	@Autowired
	ChiamataRepository chiamataRepo;
	
	@Autowired
	ChiamataService chiamataService;
	
	
	@GetMapping("/chiamate")
	public Iterable<Chiamata> vediChiamate() {
		return chiamataRepo.findAll();
	}
	
	@PostMapping(value="/chiamata")
	public Chiamata inserisciChiamata(@RequestBody Chiamata c) {
		return chiamataService.inserisciChiamata(c);
	}
	
	@RequestMapping(value="/chiamata/{codChiamata}", method=RequestMethod.PUT)
	public Chiamata modificaCliente(@PathVariable("codChiamata")Integer codChiamata, @RequestBody Chiamata c) {
		return chiamataService.aggiornaChiamata(codChiamata, c);
	}
	
	@DeleteMapping("chiamata/{codChiamata}")
	public Chiamata cancellaChiamata(@PathVariable("codChiamata")Integer codChiamata) {
		return chiamataService.eliminaChiamata(codChiamata);
	}
	
	@GetMapping("/reportChiamate/{codLinea}/{dateStart}/{dateEnd}")
	public Long reportChiamate(@PathVariable("codLinea")Integer codLinea, @PathVariable("dateStart")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")Date dateStart, @PathVariable("dateEnd")@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")Date dateEnd) {
		return chiamataService.calcoloDurataChiamata(codLinea, dateStart, dateEnd);
	}
	
}
